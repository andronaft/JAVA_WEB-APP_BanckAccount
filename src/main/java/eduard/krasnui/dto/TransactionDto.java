package eduard.krasnui.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eduard.krasnui.model.Account;
import eduard.krasnui.model.Transaction;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDto {
    private Long id;
    private String description;
    private Long senderId;
    private Long receiverId;
    private int sum;

    public Transaction toTransaction(){
        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setId(id);
        Account senderAccount = new Account();senderAccount.setId(senderId);
        transaction.setSenderAccount(senderAccount);
        Account reciverAccount = new Account();senderAccount.setId(receiverId);
        transaction.setReceiverAccount(reciverAccount);
        transaction.setSum(sum);
        return transaction;

    }

    public static TransactionDto fromTransaction(Transaction transaction){
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setDescription(transaction.getDescription());
        transactionDto.setReceiverId(transaction.getReceiverAccount().getId());
        transactionDto.setSenderId(transaction.getSenderAccount().getId());
        transactionDto.setSum(transaction.getSum());
        return transactionDto;
    }
}
