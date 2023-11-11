package com.desafiopicpay.service;

import com.desafiopicpay.domain.users.User;
import com.desafiopicpay.domain.users.UserType;
import com.desafiopicpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuário não está autorizado a realizar transações!");
        }
        if(sender.getBalance().compareTo(amount)<0) {
            throw  new Exception("Saldo insuficiente");
        }
    }

    public User findUserById(Long id) throws Exception {
       return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public void saveUser(User user){
        this.repository.save(user);
    }

}
