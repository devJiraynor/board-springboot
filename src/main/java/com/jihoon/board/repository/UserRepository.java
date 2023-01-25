package com.jihoon.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jihoon.board.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	public boolean existsByUserEmailAndUserPassword(String userEmail, String userPassword);
}
