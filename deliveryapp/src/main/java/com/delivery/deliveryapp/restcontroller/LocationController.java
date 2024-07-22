package com.delivery.deliveryapp.restcontroller;

import com.delivery.deliveryapp.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/locations")
public class LocationController {

    private final KafkaService kafkaService;

    // Returns random coordinates
    @PostMapping("/update")
    public ResponseEntity<?> updateLocation() {
        kafkaService.updateLocation("(" + Math.round(Math.random() * 100) + ", " + Math.round(Math.random() * 100) + ")");
        return new ResponseEntity<>(Map.of("message: ", "location updated"), HttpStatus.OK);
    }
}
