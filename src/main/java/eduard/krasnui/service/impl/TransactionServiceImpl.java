package eduard.krasnui.service.impl;

import eduard.krasnui.model.Transaction;
import eduard.krasnui.repository.TransactionRepository;
import eduard.krasnui.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public ArrayList<Transaction> findAll() {
        return (ArrayList<Transaction>) transactionRepository.findAll();
    }

    @Override
    public Transaction findById(Long id) {
        return transactionRepository.getOne(id);
    }

    @Override
    public Transaction findBySenderId(Long id) {
        return transactionRepository.findBySenderAccountId(id);
    }

    @Override
    public ArrayList<Transaction> findAllBySenderId(Long id) {
        return (ArrayList<Transaction>) transactionRepository.findAllBySenderAccountId(id);
    }

    @Override
    public Transaction findByReceiverId(Long id) {
        return transactionRepository.getOne(id);
    }

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
