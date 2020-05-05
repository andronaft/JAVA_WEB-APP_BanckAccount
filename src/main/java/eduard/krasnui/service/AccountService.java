package eduard.krasnui.service;

import eduard.krasnui.model.Account;

import java.util.ArrayList;

public interface AccountService {
    Account findById(Long id);
    ArrayList<Account> findAll();

    Account save(Account account);
    Account update(Account account);

    Account activate(Long id);

    ArrayList<Account> findByUserId(Long userId);

    Boolean checkAmount(int amount,Long id);

    Account transfer(int amount, Long id);

    Account getMoney(int amount, Long id);

    ArrayList<Account> getAllNotActive();
}
