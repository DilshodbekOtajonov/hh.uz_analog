package com.example.project_blueprint.service.address;

import com.example.project_blueprint.domains.address.Address;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 18:47 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
@Service
public interface AddressService {

    Address getAddressById(Long id);
}
