package eduard.krasnui.controller;


import eduard.krasnui.dto.AccountDto;
import eduard.krasnui.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/accounts/")
public class AccountRestController {

    private final AccountService accountService;

    @Autowired
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "getByUserId")
    public ResponseEntity getAccountByUserId(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.findByUserId(accountDto.getUserId()),HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity create(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.save(accountDto.toAccount()),HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity update(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.update(accountDto.toAccount()),HttpStatus.OK);
    }
}
