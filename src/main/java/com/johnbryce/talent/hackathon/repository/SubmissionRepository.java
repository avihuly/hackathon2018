package com.johnbryce.talent.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnbryce.talent.hackathon.models.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Integer> {

}
