package com.whiskeyworldwide.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="quiz")
public class Quiz {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long quizId;
	
	int bbq;
	int sweet;
	int spicy;
	int fruity;
	
	@OneToOne(mappedBy = "quiz")
	private User user;

	public long getQuizId() {
		return quizId;
	}

	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}

	public int getBbq() {
		return bbq;
	}

	public void setBbq(int bbq) {
		this.bbq = bbq;
	}

	public int getSweet() {
		return sweet;
	}

	public void setSweet(int sweet) {
		this.sweet = sweet;
	}

	public int getSpicy() {
		return spicy;
	}

	public void setSpicy(int spicy) {
		this.spicy = spicy;
	}

	public int getFruity() {
		return fruity;
	}

	public void setFruity(int fruity) {
		this.fruity = fruity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
