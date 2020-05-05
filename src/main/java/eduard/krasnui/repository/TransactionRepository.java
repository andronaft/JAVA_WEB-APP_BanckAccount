package eduard.krasnui.repository;

import eduard.krasnui.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction findBySenderAccountId(Long senderId);
    Transaction findByReceiverAccountId(Long senderId);
    List<Transaction> findAllBySenderAccountId(Long senderId);
}
