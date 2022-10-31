package com.example.project_blueprint.service.address;

import com.example.project_blueprint.domains.address.Address;
import com.example.project_blueprint.exceptions.AddressNotFoundException;
import com.example.project_blueprint.repository.address.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/10/22 18:48 (Monday)
 * hh.uz_analog/IntelliJ IDEA
 */
@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService{
   private final AddressRepository addressRepository;

   @Override
   public Address getAddressById(Long id) {
      Address addressNotFoundById = addressRepository.findById(id).orElseThrow(() -> {
         throw new AddressNotFoundException("Address Not Found By Id");
      });
      return addressNotFoundById;
   }
}
