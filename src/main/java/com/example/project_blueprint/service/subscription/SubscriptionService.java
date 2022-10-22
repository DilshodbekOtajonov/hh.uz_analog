package com.example.project_blueprint.service.subscription;

import com.example.project_blueprint.dto.subscription.SubscriptionCreateDTO;
import com.example.project_blueprint.dto.subscription.SubscriptionDTO;
import org.springframework.stereotype.Service;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/22/22 3:05 PM (Saturday)
 * hh.uz_analaog/IntelliJ IDEA
 */

@Service
public interface SubscriptionService {
    SubscriptionDTO create(SubscriptionCreateDTO dto);
}
