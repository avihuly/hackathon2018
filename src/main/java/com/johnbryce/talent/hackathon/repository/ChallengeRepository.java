package com.johnbryce.talent.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnbryce.talent.hackathon.models.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

}
