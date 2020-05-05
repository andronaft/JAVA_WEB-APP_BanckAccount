package eduard.krasnui.controller;


import eduard.krasnui.dto.TransactionDto;
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
@RequestMapping(value = "/api/transaction/")
public class TransactionRestController {

    private final TransactionService transactionService;
    private final UserService userService;
    private final AccountService accountService;

    @Autowired
    public TransactionRestController(TransactionService transactionService, UserService userService, AccountService accountService) {
        this.transactionService = transactionService;
        this.userService = userService;
        this.accountService = accountService;
    }

    @PostMapping(value = "transfer")
    public ResponseEntity transfer(@RequestBody TransactionDto transactionDto){
        if((userService.findById(transactionDto.getReceiverId())!=null)&&(userService.findById(transactionDto.getSenderId())!=null)){
            if(accountService.transfer(transactionDto.getSum(),transactionDto.getSenderId())!=null){
                if(accountService.getMoney(transactionDto.getSum(),transactionDto.getReceiverId())!=null){

                    return new ResponseEntity<>(transactionService.save(transactionDto.toTransaction()), HttpStatus.OK);
                }
                else {
                    Map<Object, Object> response = new HashMap<>();
                    response.put("message", "Try later");
                    return ResponseEntity.ok(response);
                }
            }
            else {
                Map<Object, Object> response = new HashMap<>();
                response.put("message", "Try later");
                return ResponseEntity.ok(response);
            }
        }
        else {
            Map<Object, Object> response = new HashMap<>();
            response.put("message", "Try later");
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping(value = "findBySenderId")
    public ResponseEntity findBySenderId(@RequestBody TransactionDto transactionDto){
        return new ResponseEntity<>(transactionService.findBySenderId(transactionDto.getSenderId()), HttpStatus.OK);
    }

}
