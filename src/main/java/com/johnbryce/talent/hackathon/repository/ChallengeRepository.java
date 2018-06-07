package com.johnbryce.talent.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.johnbryce.talent.hackathon.models.Challenge;
import com.johnbryce.talent.hackathon.models.User;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
	public List<Challenge> findAllChallengeBycreatedBy(User user);
	
}
