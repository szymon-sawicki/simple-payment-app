package net.szymonsawicki.transaction_service.application;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public TransactionService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String createMessage(String text) {
        for (int i = 1; i <= 5; i++) {
            kafkaTemplate.send("test-topic", "Message: " + text + ". Counter: " + i);
        }
        return "messages created. Text: " + text;
    }

    public String createMessagePartitionWithRoutingKey(String text, String key) {
        for (int i = 1; i <= 5; i++) {
            kafkaTemplate.send("tes-topic-partition", key,"Message: " + text + ". Counter: " + i);
        }
        return "messages created. Text: " + text;
    }

    public String createMessagePartitionWithoutRoutingKey(String text) {
        for (int i = 1; i <= 5; i++) {
            kafkaTemplate.send("tes-topic-partition", "Message: " + text + ". Counter: " + i);
        }
        return "messages created. Text: " + text;
    }

    public String createMessageConsumerGroup(String text) {
        for (int i = 1; i <= 5; i++) {
            kafkaTemplate.send("test-topic-consumer-group", "Message: " + text + ". Counter: " + i);
        }
        return "Messages for topic test-topic-consumer-group created. Text: " + text;
    }
}
