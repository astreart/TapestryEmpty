package com.musala.tapestry.tutorial.util;

import java.util.List;

import org.apache.tapestry5.beaneditor.PropertyModel;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.grid.SortConstraint;

import com.musala.tapestry.tutorial.data.IDataSource;
import com.musala.tapestry.tutorial.model.Celebrity;

public class CelebritySource implements GridDataSource {

	private IDataSource dataSource;
	private List<Celebrity> selection;
	private int indexFrom;

	public CelebritySource(IDataSource ds) {
		this.dataSource = ds;
	}

	public int getAvailableRows() {
		return dataSource.getAllCelebrities().size();
	}

	public void prepare(int indexFrom, int indexTo,
			PropertyModel propertyModel, boolean ascending) {
		System.out.println("Preparing selection.");
		System.out.println("Index from " + indexFrom + " to " + indexTo);
		String propertyName = propertyModel == null ? null : propertyModel
				.getPropertyName();
		System.out.println("Property name is: " + propertyName);
		System.out.println("Sorting order ascending: " + ascending);
		selection = dataSource.getRange(indexFrom, indexTo);
		this.indexFrom = indexFrom;
	}

	public Object getRowValue(int i) {
		System.out.println("Getting value for row " + i);
		return selection.get(i - this.indexFrom);
	}

	public Class getRowType() {
		return Celebrity.class;
	}

	public GridDataSource getCelebritySource() {
		return new CelebritySource(dataSource);
	}

	@Override
	public void prepare(int arg0, int arg1, List<SortConstraint> arg2) {
		// TODO Auto-generated method stub

	}

}