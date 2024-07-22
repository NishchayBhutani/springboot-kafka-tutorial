package com.delivery.deliveryapp.service;

import com.delivery.deliveryapp.config.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public boolean updateLocation(String location) {
        kafkaTemplate.send(Constants.LOCATION_UPDATE, location);
        log.info("event/message produced");
        return true;
    }
}
