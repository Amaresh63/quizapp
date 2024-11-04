package com.telusko.Quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.Quiz.entity.Quiz;
import com.telusko.Quiz.repository.QuizRepository;

@Service
public class QuizServiceImplementation implements QuizService {

	@Autowired
	QuizRepository quizRepo;

	@Override
	public ResponseEntity<List<Quiz>> getAll() {
		try {
			return new ResponseEntity<>(quizRepo.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<Quiz>> getByCategory(String category) {
		try {
			return new ResponseEntity<List<Quiz>>(quizRepo.findByCategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Quiz>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<String> addQuestions(Quiz quiz) {
		try {
			quizRepo.save(quiz);
			return new ResponseEntity<>("success", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
	}

	@Override
	public String deleteQuestion(int id) {
		quizRepo.deleteById(id);
		return "deleted";
	}

}
