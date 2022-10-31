package com.example.project_blueprint.controller;

import com.example.project_blueprint.dto.subscription.SubscriptionCreateDTO;
import com.example.project_blueprint.dto.subscription.SubscriptionDTO;
import com.example.project_blueprint.service.subscription.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Tojaliyev Asliddin"
 * @since 23/10/22 00:01 (Sunday)
 * hh.uz_analog/IntelliJ IDEA
 */
@RestController
@RequestMapping("/subscription")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping("/create")
    public ResponseEntity<SubscriptionDTO> create(@RequestBody SubscriptionCreateDTO dto) {
        SubscriptionDTO subscriptionDTO = subscriptionService.create(dto);
        return new ResponseEntity<>(subscriptionDTO, HttpStatus.CREATED);
    }
}
