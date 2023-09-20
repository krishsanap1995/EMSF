package com.EMS.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EMS.models.Address;

public interface AddressRepositry extends JpaRepository<Address, Integer> {

}
