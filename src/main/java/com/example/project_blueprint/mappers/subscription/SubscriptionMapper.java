package com.example.project_blueprint.mappers.subscription;

import com.example.project_blueprint.domains.subscription.Subscription;
import com.example.project_blueprint.dto.subscription.SubscriptionCreateDTO;
import com.example.project_blueprint.dto.subscription.SubscriptionDTO;
import org.mapstruct.Mapper;

/**
 * @author "Tojaliyev Asliddin"
 * @since 25/10/22 00:58 (Tuesday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
    SubscriptionDTO toSubscription(Subscription subscription);

    Subscription fromSubscriptionCreateDTO(SubscriptionCreateDTO dto);
}
