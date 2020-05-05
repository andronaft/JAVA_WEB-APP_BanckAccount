package eduard.krasnui.repository;

import eduard.krasnui.model.Account;
import eduard.krasnui.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository  extends JpaRepository<Account, Long> {
    List<Account> findByUserId(Long userId);

    List<Account> findByStatus(Status status);
}
