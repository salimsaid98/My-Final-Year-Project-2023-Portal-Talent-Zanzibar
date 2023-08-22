package com.job_portal.job_portal.services;

import com.job_portal.job_portal.repositories.LoginRepository;
import com.job_portal.job_portal.specific.loginDTO;
import com.job_portal.job_portal.tables.login;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class LoginServices
{
    @Autowired
    public LoginRepository login_repository;
    protected static SecretKeySpec secretKey;
    protected static byte[] key;
    private static final String ALGORITHM = "AES";

    public void prepareSecreteKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String strToEncrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public login saveUsers(loginDTO lgn){
        final String secretKey = "hasuko52@gmail.com";
        login l = new login();
        l.setPassword(encrypt(lgn.getPassword(),secretKey));
        l.setUsername(lgn.getUsername()); l.setStatus("1");
        l.setRole(lgn.getRole());
        Optional<login> check = login_repository.check_existing_user(lgn.getUsername());
        if(check.isPresent()){
            throw new ResponseStatusException(HttpStatus.FOUND,"User exist");
        }else{
            return login_repository.save(l);
        }
    }

    public login login_authentication(String username, String password){
        final String secretKey = "hasuko52@gmail.com";
        String encrypted_password = encrypt(password,secretKey);
        String status = "1";
        Optional<login> l = login_repository.login_authentication(username,encrypted_password,status);
        if(l.isPresent()){
            return l.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User was not found");
        }
    }

    public List<login> getAllUsers(){
        List<login> l = login_repository.getAllUsers();
        if(l.size() > 0){
            return l;
        }else{
            return new ArrayList<>();
        }
    }
    @Transactional
    public Optional<login> resetPassword(int user_id,loginDTO dto){
        return login_repository.findById(user_id).map(l->{
            final String secretKey = "hasuko52@gmail.com";
            l.setPassword(encrypt(dto.getPassword(),secretKey));
            l.setRole(dto.getRole());
            l.setStatus("1");
            l.setUsername(dto.getUsername());
            return l;
        });
    }

}
