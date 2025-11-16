
/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 30/04/2024, 19:44
 *  * @modified : 30/04/2024, 19:44
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.service.Impl;

import com.fsdm.pfe.ssmdelivery.entity.Transaction;
import com.fsdm.pfe.ssmdelivery.entity.User;
import com.fsdm.pfe.ssmdelivery.model.enums.TransactionType;
import com.fsdm.pfe.ssmdelivery.repository.TransactionRepo;
import com.fsdm.pfe.ssmdelivery.repository.UserRepo;
import com.fsdm.pfe.ssmdelivery.service.TransactionService;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    UserServiceImpl userService;
    TransactionRepo transactionRepo;
    private final UserRepo userRepository;

    public TransactionServiceImpl(TransactionRepo transactionRepo, UserServiceImpl userService, UserRepo userRepository) {
        this.transactionRepo = transactionRepo;
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public Transaction loadTransactionById(Long id) {
        return transactionRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }


    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<Transaction> makeMultipleTransactions(List<Transaction> transactions) {
        return transactionRepo.saveAll(transactions);
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void transfer(@NotNull User fromUser, @NotNull User toUser, @NotNull double amount, @NotNull String description) {

        fromUser.setBalance(fromUser.getBalance() - amount);
        userRepository.save(fromUser);

        toUser.setBalance(toUser.getBalance() + amount);
        userRepository.save(toUser);

        Transaction transactionFromUser = new Transaction();
        transactionFromUser.setUser(fromUser);

        transactionFromUser.setAmount(amount);
        transactionFromUser.setTransactionType(TransactionType.DEBIT);
        transactionFromUser.setDescription(description);

        transactionRepo.save(transactionFromUser);

        Transaction transactionToUser = new Transaction();
        transactionToUser.setUser(toUser);
        transactionToUser.setAmount(amount);
        transactionToUser.setTransactionType(TransactionType.CREDIT);
        transactionToUser.setDescription(description);
        transactionRepo.save(transactionToUser);
    }

}



