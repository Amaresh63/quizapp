package com.telusko.Quiz.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.telusko.Quiz.entity.QuizWrapper;

public interface QuizCompService {

	ResponseEntity<String> createQuiz(String category, int numQ, String title);

	ResponseEntity<List<QuizWrapper>> fetchQuiz(int id);
	

}
