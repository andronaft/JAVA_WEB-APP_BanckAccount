package eduard.krasnui.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eduard.krasnui.model.Account;
import eduard.krasnui.model.AccountType;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDto {
    private Long id;
    private AccountType accountType;
    private Long userId;
    private int amount;
    private int limit;
    private int percent;
    private String information;


    public Account toAccount(){
        Account account = new Account();
        account.setId(id);
        account.setType(accountType);
        account.setAmount(amount);
        account.setLimit(limit);
        return account;
    }

    public static AccountDto fromAccount(Account account){
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setAccountType(account.getType());
        accountDto.setLimit(account.getLimit());
        accountDto.setAmount(account.getAmount());
        accountDto.setUserId(account.getUser().getId());
        return accountDto;
    }
}
