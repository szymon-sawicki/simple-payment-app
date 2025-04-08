package net.szymonsawicki.account_service.application;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountService {


    @KafkaListener(topics = "test-topic")
    public void consumeMessageTest(ConsumerRecord<String, String> record) {
        System.out.println("======================================");
        System.out.println("🔹 Received message: " + record.value());
        System.out.println("📌 From partition: " + record.partition() + " | Offset: " + record.offset());
        System.out.println("======================================");
    }

    @KafkaListener(topics = "tes-topic-partition")
    public void consumeMessagePartition(ConsumerRecord<String, String> record) {
        System.out.println(" CONSUMER PARTITION 1 ======================================");
        System.out.println("🔹 Received message: " + record.value());
        System.out.println("📌 From partition: " + record.partition() + " | Offset: " + record.offset());
        System.out.println("======================================");
    }

    @KafkaListener(topics = "tes-topic-partition")
    public void consumeMessagePartition2(ConsumerRecord<String, String> record) {
        System.out.println("CONSUMER PARTITION 2 ======================================");
        System.out.println("🔹 Received message: " + record.value());
        System.out.println("📌 From partition: " + record.partition() + " | Offset: " + record.offset());
        System.out.println("======================================");
    }


}
