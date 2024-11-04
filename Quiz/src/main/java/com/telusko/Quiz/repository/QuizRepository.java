package com.telusko.Quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telusko.Quiz.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

	public List<Quiz> findByCategory(String category);

	@Query(value = "Select * from Quiz q where q.category=:category Order by Rand() limit :numQ", nativeQuery = true)
	public List<Quiz> findRandomByCategory(String category, int numQ);

}
