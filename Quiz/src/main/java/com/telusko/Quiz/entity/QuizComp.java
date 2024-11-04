package com.telusko.Quiz.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class QuizComp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="title")
	private String name;

	@ManyToMany
	private List<Quiz> quiz;

	public QuizComp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuizComp(int id, String name, List<Quiz> quiz) {
		super();
		this.id = id;
		this.name = name;
		this.quiz = quiz;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Quiz> getQuiz() {
		return quiz;
	}

	public void setQuiz(List<Quiz> quiz) {
		this.quiz = quiz;
	}

	@Override
	public String toString() {
		return "QuizComp [id=" + id + ", name=" + name + ", quiz=" + quiz + "]";
	}

}
