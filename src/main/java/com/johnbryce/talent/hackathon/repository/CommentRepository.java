package com.johnbryce.talent.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnbryce.talent.hackathon.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
