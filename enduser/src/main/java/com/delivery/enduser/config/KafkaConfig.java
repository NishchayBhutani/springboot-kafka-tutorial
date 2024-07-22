package com.delivery.enduser.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    private static final Logger log = LoggerFactory.getLogger(KafkaConfig.class);

    @KafkaListener(topics = Constants.LOCATION_UPDATE, groupId = Constants.LOCATION_UPDATE)
    public void updatedLocation(String location) {
        log.info(location);
    }
}
