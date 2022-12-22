package com.prac.springio;


public class HellobeanController {

	private String word;

	public HellobeanController(String word) {
		super();
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return "HellobeanController [word=" + word + "]";
	}
	
}
