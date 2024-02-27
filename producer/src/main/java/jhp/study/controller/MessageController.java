package jhp.study.controller;

import io.azam.ulidj.ULID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        kafkaTemplate.send("spring-topic","tempKey", message);
        String ulid = ULID.random();
        log.info("ULID = {}", ulid);

        return ulid;
    }
}
