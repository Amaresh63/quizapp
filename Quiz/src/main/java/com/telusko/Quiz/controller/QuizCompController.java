package com.telusko.Quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.Quiz.entity.QuizWrapper;
import com.telusko.Quiz.service.QuizCompService;



@RestController
@RequestMapping("quizcomp")
public class QuizCompController {
	
	@Autowired
	QuizCompService quizcompService;
	
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
		return quizcompService.createQuiz(category,numQ,title);
		
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<List<QuizWrapper>> fetch(@PathVariable int id){
		
		return quizcompService.fetchQuiz(id);
		
	}

}
