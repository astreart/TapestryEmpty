package com.musala.tapestry.tutorial.util;

import java.util.List;

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

	@Override
	public int getAvailableRows() {
		 return dataSource.getAllCelebrities().size();
    }

	@Override
	public Class getRowType() {
		 return Celebrity.class;
	}

	@Override
	public Object getRowValue(int i) {
		System.out.println("Getting value for row " + i);
        return selection.get(i - this.indexFrom);
	}

	@Override
	public void prepare(int indexFrom, int indexTo, List<SortConstraint> arg2) {
		 selection = dataSource.getRange(indexFrom, indexTo);
	        this.indexFrom = indexFrom;
	}

	


}