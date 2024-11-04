package com.telusko.Quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.Quiz.entity.Quiz;
import com.telusko.Quiz.service.QuizService;

@RestController
@RequestMapping("quiz/")
public class QuizController {
	
	@Autowired
	QuizService quizServ;
	
	@GetMapping("/fetch")
	public ResponseEntity<List<Quiz>> getAll(){
		return quizServ.getAll() ;
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Quiz>> getByCategory(@PathVariable String category){
		return quizServ.getByCategory(category);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Quiz quiz) {
		return quizServ.addQuestions(quiz);
		
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return quizServ.deleteQuestion(id);
	}
	
	

}
