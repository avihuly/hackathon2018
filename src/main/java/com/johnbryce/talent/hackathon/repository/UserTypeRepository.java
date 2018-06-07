package com.johnbryce.talent.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnbryce.talent.hackathon.models.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

}
