package com.example.project_blueprint.service.subscription;

import com.example.project_blueprint.domains.subscription.Subscription;
import com.example.project_blueprint.dto.subscription.SubscriptionCreateDTO;
import com.example.project_blueprint.dto.subscription.SubscriptionDTO;
import com.example.project_blueprint.mappers.subscription.SubscriptionMapper;
import com.example.project_blueprint.repository.subscription.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 23/10/22 00:05 (Sunday)
 * hh.uz_analog/IntelliJ IDEA
 */
@RequiredArgsConstructor
@Service
public class SubscriptionServiceImpl implements SubscriptionService{

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;

    @Override
    public SubscriptionDTO create(SubscriptionCreateDTO dto) {
        Subscription subscription = subscriptionMapper.fromSubscriptionCreateDTO(dto);
        Subscription save = subscriptionRepository.save(subscription);
        SubscriptionDTO subscriptionDTO = subscriptionMapper.toSubscription(save);
        return subscriptionDTO;
    }
}
