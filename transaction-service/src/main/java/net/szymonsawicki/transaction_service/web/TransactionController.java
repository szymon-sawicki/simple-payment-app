package net.szymonsawicki.transaction_service.web;

import net.szymonsawicki.transaction_service.application.TransactionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/test1/{message}")
    public String createTransaction(@PathVariable("message") String text) {
        return transactionService.createMessage(text);
    }
    @PostMapping("test-partition-key/{message}")
    public String createTransactionKey(@PathVariable("message") String text, @RequestParam("key") String key) {
        return transactionService.createMessagePartitionWithRoutingKey(text,key);
    }

    @PostMapping("test-partition-no-key/{message}")
    public String createTransactionNoKey(@PathVariable("message") String text) {
        return transactionService.createMessagePartitionWithoutRoutingKey(text);
    }

    @PostMapping("test-consumer-group/{message}")
    public String createMessageConsumerGroup(@PathVariable("message") String text) {
        return transactionService.createMessageConsumerGroup(text);
    }
}
