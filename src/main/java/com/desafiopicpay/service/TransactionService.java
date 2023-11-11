package com.desafiopicpay.service;

import com.desafiopicpay.DTOs.TrasactionDTO;
import com.desafiopicpay.domain.users.User;
import com.desafiopicpay.repository.TransactionRepository;
import com.desafiopicpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    private UserService userService;

    public void createTransaction(TrasactionDTO transaction) throws Exception{
        User sender = this.userService.findUserById(transaction.senderId());
        User reciver = this.userService.findUserById(transaction.reciverId());

        userService.validateTransaction(sender, transaction.value());

        if()
    }

    public boolean authorizeTrasaction(User sender, BigDecimal value){


    }
}
