package jhp.study.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class ConsumerService {

    @KafkaListener(topics = "test-topic")
    public void logMessage1(String message, ConsumerRecordMetadata meta) {
        log.info("message = {}", message);
    }

    /*
    @KafkaListener(topics = "test-topic")
    public void logMessage2(String message, ConsumerRecordMetadata meta) {

    }
    */

}
