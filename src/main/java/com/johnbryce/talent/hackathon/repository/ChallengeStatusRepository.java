package com.johnbryce.talent.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnbryce.talent.hackathon.models.ChallengeStatus;

public interface ChallengeStatusRepository extends JpaRepository<ChallengeStatus, Long> {

}
