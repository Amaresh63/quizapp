package com.telusko.Quiz.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.telusko.Quiz.entity.Quiz;

public interface QuizService {

	public ResponseEntity<List<Quiz>> getAll();

	public ResponseEntity<List<Quiz>> getByCategory(String category);

	public ResponseEntity<String> addQuestions(Quiz quiz);

	public String deleteQuestion(int id);

}
