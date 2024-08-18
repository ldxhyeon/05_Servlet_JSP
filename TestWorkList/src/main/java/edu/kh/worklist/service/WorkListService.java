package edu.kh.worklist.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import edu.kh.worklist.dto.Work;

public interface WorkListService {

	Map<String, Object> workListFullView();

	int workAdd(String title, String detail) throws FileNotFoundException, IOException;

	Work workDetailView(int index);

	boolean workComplete(int index) throws FileNotFoundException, IOException;

	boolean workUpdate(int index, String title, String detail) throws FileNotFoundException, IOException;

	String todoDelete(int index) throws FileNotFoundException, IOException;


}
