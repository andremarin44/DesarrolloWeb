package com.libreria.v1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libreria.v1.Model.UserModel;
@Repository

public interface UserRepository extends JpaRepository <UserModel, Long>{
    
}
