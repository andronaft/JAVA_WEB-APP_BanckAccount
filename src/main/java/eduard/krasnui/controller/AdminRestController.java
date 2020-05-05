package eduard.krasnui.controller;

import eduard.krasnui.dto.AccountDto;
import eduard.krasnui.dto.AdminDto;
import eduard.krasnui.dto.TransactionDto;
import eduard.krasnui.dto.UserDto;
import eduard.krasnui.model.Account;
import eduard.krasnui.service.AccountService;
import eduard.krasnui.service.TransactionService;
import eduard.krasnui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/admin/")
public class AdminRestController {

    private final UserService userService;
    private final TransactionService transactionService;
    private final AccountService accountService;

    @Autowired
    public AdminRestController(UserService userService, TransactionService transactionService, AccountService accountService) {
        this.userService = userService;
        this.transactionService = transactionService;
        this.accountService = accountService;
    }


    @PostMapping(value = "activeUser")
    public ResponseEntity activeUser(@RequestBody AdminDto adminDto, @RequestBody UserDto userDto){
        if(userService.isAdmin(adminDto.toUser())){
            return new ResponseEntity<>(userService.activateUser(userDto.getId()), HttpStatus.OK);
        }
        Map<Object, Object> response = new HashMap<>();
        response.put("message", "check auth");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "getAllUser")
    public ResponseEntity getAllUser(@RequestBody AdminDto adminDto, @RequestBody UserDto userDto){
        if(userService.isAdmin(adminDto.toUser())){
            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        }
        Map<Object, Object> response = new HashMap<>();
        response.put("message", "check auth");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "activeAccount")
    public ResponseEntity activeAccount(@RequestBody AdminDto adminDto, @RequestBody AccountDto accountDto){
        if(userService.isAdmin(adminDto.toUser())){
            return new ResponseEntity<>(accountService.activate(accountDto.getId()), HttpStatus.OK);
        }
        Map<Object, Object> response = new HashMap<>();
        response.put("message", "check auth");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "updateAccount")
    public ResponseEntity updateAccount(@RequestBody AdminDto adminDto, @RequestBody AccountDto accountDto){
        if(userService.isAdmin(adminDto.toUser())){
            return new ResponseEntity<>(accountService.update(accountDto.toAccount()), HttpStatus.OK);
        }
        Map<Object, Object> response = new HashMap<>();
        response.put("message", "check auth");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "findAllAccount")
    public ResponseEntity finadAllAccount(@RequestBody AdminDto adminDto, @RequestBody AccountDto accountDto){
        if(userService.isAdmin(adminDto.toUser())){
            return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
        }
        Map<Object, Object> response = new HashMap<>();
        response.put("message", "check auth");
        return ResponseEntity.ok(response);
    }


    @PostMapping(value = "findAllTransaction")
    public ResponseEntity findAllTransaction(@RequestBody AdminDto adminDto, @RequestBody TransactionDto transactionDto){
        if(userService.isAdmin(adminDto.toUser())){
            return new ResponseEntity<>(transactionService.findAll(), HttpStatus.OK);
        }
        Map<Object, Object> response = new HashMap<>();
        response.put("message", "check auth");
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "updateTransaction")
    public ResponseEntity finadAllAccount(@RequestBody AdminDto adminDto, @RequestBody TransactionDto transactionDto){
        if(userService.isAdmin(adminDto.toUser())){
            return new ResponseEntity<>(transactionService.update(transactionDto.toTransaction()), HttpStatus.OK);
        }
        Map<Object, Object> response = new HashMap<>();
        response.put("message", "check auth");
        return ResponseEntity.ok(response);
    }

}
