package com.example.project_blueprint.repository.subscription;

import com.example.project_blueprint.domains.subscription.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Tojaliyev Asliddin"
 * @since 25/10/22 00:04 (Tuesday)
 * hh.uz_analog/IntelliJ IDEA
 */
public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
}
