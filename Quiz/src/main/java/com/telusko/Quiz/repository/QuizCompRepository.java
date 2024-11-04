package com.telusko.Quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.Quiz.entity.QuizComp;

@Repository
public interface QuizCompRepository extends JpaRepository<QuizComp, Integer>{
	
	

}
