package com.musala.tapestry.tutorial.pages;

import java.text.Format;
import java.util.List;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.grid.GridDataSource;

import com.musala.tapestry.tutorial.data.IDataSource;
import com.musala.tapestry.tutorial.data.MockDataSource;
import com.musala.tapestry.tutorial.model.Celebrity;
import com.musala.tapestry.tutorial.model.User;
import com.musala.tapestry.tutorial.util.CelebrityEncoder;
import com.musala.tapestry.tutorial.util.CelebritySelectModel;
import com.musala.tapestry.tutorial.util.CelebritySource;
import com.musala.tapestry.tutorial.util.Formats;

public class ShowAll {

	@SessionState
	private User user;
	private boolean userExists;

	@SessionState
	private IDataSource dataSource;

	@InjectPage
	private Details detailsPage;

	private Celebrity celebrity;

	String onActivate() {
		if (!userExists)
			return "Index";
		return null;
	}

	/*
	 * @OnEvent(component="detailsLink") Object onShowDetails(long id) {
	 * Celebrity celebrity = dataSource.getCelebrityById(id);
	 * detailsPage.setCelebrity(celebrity); return detailsPage; }
	 */

	public GridDataSource getCelebritySource() {
		return new CelebritySource(dataSource);
	}

	public List<Celebrity> getAllCelebrities() {
		System.out.println("Getting all celebrities...");
		return dataSource.getAllCelebrities();
	}

	public Celebrity getCelebrity() {
		return celebrity;
	}

	public void setCelebrity(Celebrity celebrity) {
		this.celebrity = celebrity;
	}

	public Format getDateFormat() {
		return Formats.getDateFormat();
	}

	public SelectModel getCelebrityModel() {
		return new CelebritySelectModel(getAllCelebrities());
	}

	public ValueEncoder getCelebrityEncoder() {
		return new CelebrityEncoder(dataSource);
	}

	@Persist
	private Celebrity selectedCelebrity;

	public Celebrity getSelectedCelebrity() {
		return selectedCelebrity;
	}

	public void setSelectedCelebrity(Celebrity selectedCelebrity) {
		this.selectedCelebrity = selectedCelebrity;
	}

	public String getSelectedCelebrityName() {
		if (selectedCelebrity == null)
			return "";
		return selectedCelebrity.getFirstName() + " "
				+ selectedCelebrity.getLastName();
	}
}