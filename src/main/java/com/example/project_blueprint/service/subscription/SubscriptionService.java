package com.example.project_blueprint.service.subscription;

import com.example.project_blueprint.dto.subscription.SubscriptionCreateDTO;
import com.example.project_blueprint.dto.subscription.SubscriptionDTO;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 23/10/22 00:04 (Sunday)
 * hh.uz_analog/IntelliJ IDEA
 */

@Service
public interface SubscriptionService {
    SubscriptionDTO create(SubscriptionCreateDTO dto);
}
