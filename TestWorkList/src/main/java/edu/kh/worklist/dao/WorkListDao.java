package edu.kh.worklist.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.kh.worklist.dto.Work;

public interface WorkListDao {
	
	void saveFile() throws FileNotFoundException, IOException;

	List<Work> workListFullView();

	int workAdd(Work work) throws FileNotFoundException, IOException;

	Work workDetailView(int index);

	boolean workComplete(int index) throws FileNotFoundException, IOException;

	boolean workUpdate(int index, String title, String detail) throws FileNotFoundException, IOException;

	Work workDelete(int index) throws FileNotFoundException, IOException;


}
