package eduard.krasnui.service.impl;

import eduard.krasnui.model.Account;
import eduard.krasnui.model.Status;
import eduard.krasnui.repository.AccountRepository;
import eduard.krasnui.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class AccountServiceImpl  implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.getOne(id);
    }

    @Override
    public ArrayList<Account> findAll() {
        return (ArrayList<Account>) accountRepository.findAll();
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account activate(Long id) {
        Account account = accountRepository.getOne(id);
        account.setStatus(Status.ACTIVE);
        return update(account);
    }

    @Override
    public ArrayList<Account> findByUserId(Long userId) {
        return (ArrayList<Account>) accountRepository.findByUserId(userId);
    }

    @Override
    public Boolean checkAmount(int amount, Long id) {
        Account findAccount = accountRepository.getOne(id);

        return findAccount.getAmount() >= amount;
    }

    @Override
    public Account transfer(int amount,Long id) {
        if(checkAmount(amount,id)){
            Account findAccount = accountRepository.getOne(id);
            findAccount.setAmount(findAccount.getAmount() - amount);
            return update(findAccount);
        }
        return null;
    }

    @Override
    public Account getMoney(int amount,Long id) {
        Account findAccount = accountRepository.getOne(id);
        findAccount.setAmount(findAccount.getAmount() + amount);
        return update(findAccount);
    }

    @Override
    public ArrayList<Account> getAllNotActive() {
        return (ArrayList<Account>) accountRepository.findByStatus(Status.NOT_ACTIVE);
    }
}
