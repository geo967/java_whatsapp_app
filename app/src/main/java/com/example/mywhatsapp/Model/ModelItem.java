package com.example.mywhatsapp.Model;


public class ModelItem {

	int userId;
	int id;
	String title;
	boolean completed;

	public ModelItem(int userId, int id, String title, boolean completed) {
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.completed = completed;
	}

	public int getUserId() {
		return userId;
	}



	public int getId() {
		return id;
	}



	public String getTitle() {
		return title;
	}



	public boolean isCompleted() {
		return completed;
	}

}