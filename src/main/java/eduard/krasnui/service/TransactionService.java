package eduard.krasnui.service;

import eduard.krasnui.model.Transaction;

import java.util.ArrayList;

public interface TransactionService {
    ArrayList<Transaction> findAll();
    Transaction findById(Long id);
    Transaction findBySenderId(Long id);
    ArrayList<Transaction> findAllBySenderId(Long id);
    Transaction findByReceiverId(Long id);

    Transaction save(Transaction transaction);
    Transaction update(Transaction transaction);
}
