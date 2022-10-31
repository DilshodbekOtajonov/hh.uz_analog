package com.example.project_blueprint.repository.address;

import com.example.project_blueprint.domains.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 18:28 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
public interface AddressRepository extends JpaRepository<Address,Long> {
}
