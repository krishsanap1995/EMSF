package com.EMS.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EMS.models.Account;

public interface AccountReposity extends JpaRepository<Account, Integer>{

}
