package com.telusko.Quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.Quiz.entity.Quiz;
import com.telusko.Quiz.entity.QuizComp;
import com.telusko.Quiz.entity.QuizWrapper;
import com.telusko.Quiz.repository.QuizCompRepository;
import com.telusko.Quiz.repository.QuizRepository;

@Service
public class QuizCompServiceImplementation implements QuizCompService{
	
	@Autowired
	QuizCompRepository quizcomprepo;
	
	@Autowired
	QuizRepository quizRepo;
	

	@Override
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		QuizComp quizcomp = new QuizComp();
		List<Quiz> quiz = quizRepo.findRandomByCategory(category, numQ);
		
		quizcomp.setName(title);
		quizcomp.setQuiz(quiz);
		quizcomprepo.save(quizcomp);
		return new ResponseEntity<String>("success", HttpStatus.CREATED);
	}


	@Override
	public ResponseEntity<List<QuizWrapper>> fetchQuiz(int id) {
		Optional<QuizComp> quizcomp = quizcomprepo.findById(id);
		List<Quiz> questionsFromDB = quizcomp.get().getQuiz();
		List<QuizWrapper> wrapper = new ArrayList<>();
		for(Quiz quiz: questionsFromDB) {
			QuizWrapper quizWrapper = new QuizWrapper(quiz.getId(), quiz.getQuestionTitle(), quiz.getOption1(), quiz.getOption2(), quiz.getOption3(), quiz.getOption4());
			wrapper.add(quizWrapper);
		}
		return new ResponseEntity<>(wrapper, HttpStatus.OK);
		
	}
	
	

}
