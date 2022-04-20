package com.kcg.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.kcg.pma.entities.UserAccount;

public interface IUserAccountRepository extends CrudRepository<UserAccount, Long>{

}
