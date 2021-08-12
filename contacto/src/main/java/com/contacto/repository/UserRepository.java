package com.contacto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.contacto.models.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

    public Users findByUsername(String username);
}
