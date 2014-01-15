package com.musala.tapestry.tutorial.data;

import java.util.List;

import com.musala.tapestry.tutorial.model.Celebrity;

public interface IDataSource {
	public List<Celebrity> getAllCelebrities();
	public Celebrity getCelebrityById(long id);
	public void addCelebrity(Celebrity c);
	List<Celebrity> getRange(int indexFrom, int indexTo);
}
