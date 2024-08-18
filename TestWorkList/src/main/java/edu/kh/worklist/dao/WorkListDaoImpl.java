package edu.kh.worklist.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.kh.worklist.dto.Work;

public class WorkListDaoImpl implements WorkListDao{
	
	private final String FILE_PATH = "C:\\io_test/TestWorkList.dat";
	
	private List<Work> workList = null;
	
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;
	

	public WorkListDaoImpl() throws IOException, ClassNotFoundException {
		
		File file = new File(FILE_PATH);
		
		
		// 파일이 존재 하지 않으면
		// 리스트 생성후 리스트에 목록 추가
		if(!file.exists()) {
			workList = new ArrayList<Work>();
			
			workList.add(new Work("Servlet 공부", "수업 내용 복습111", 
					  false, LocalDateTime.now()));

			workList.add(new Work("JSP 공부", "수업 내용 복습2222", 
					false, LocalDateTime.now()));
			
			workList.add(new Work("TodoList 복습", "수업 내용 복습333", 
					false, LocalDateTime.now()));
				
		// 파일이 있다면 파일안에 값을 읽어와
		// 리스트에 추가
		}else {
			try {
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				workList = (ArrayList<Work>)ois.readObject();
			} finally {
				// 여러가지 문제가 생길수 있어
				// 무조건 스트림을 닫아야함
				if(ois != null)ois.close();
			}
			
		}
	}
	
	
	// 파일 저장
	@Override
	public void saveFile() throws FileNotFoundException, IOException {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(workList);
		} finally {
			oos.close();
		}
		
	}
	
	
	
	@Override
	public List<Work> workListFullView() {
		
		return workList;
	}
	
	
	@Override
	public int workAdd(Work work) throws FileNotFoundException, IOException {
		
		// 리스트에 받은 값 추가
		// 추가가 성공되면 파일에 저장 후
		// 마지막 인덱스 번호 반환
		if(workList.add(work)) {
			saveFile();
			// 마지막 인덱스 반환
			return workList.size() -1;
		}
		
		
		return -1;
	}
	
	
	@Override
	public Work workDetailView(int index) {
		
		if(index < 0 || index >= workList.size()) {
			return null;
		}
		
		
		return workList.get(index);
	}
	
	
	@Override
	public boolean workComplete(int index) throws FileNotFoundException, IOException {
		
		if(index < 0 || index >= workList.size()) return false;
			
		
		boolean complete = workList.get(index).isComplete();
		// 반대인 값을 set
		workList.get(index).setComplete(!complete);
		
		saveFile();
		
		return true;
	}
	
	
	
	@Override
	public boolean workUpdate(int index, String title, String detail) throws FileNotFoundException, IOException {
		
		if(index < 0 || index >= workList.size()) return false;
		
		// 생성자 호출해서 값 전달하는거와 비슷한 개념
		Work newWork = new Work();
		
		newWork.setTitle(title);
		newWork.setDetail(detail);
		newWork.setComplete(workList.get(index).isComplete());
		newWork.setRegDate(workList.get(index).getRegDate());
		
		
		// 이건 이해가 안감.
		if(workList.set(index, newWork) != null) {
			saveFile();
			
			return true;
		}
 		
		
		return false;
		
	}
	
	
	@Override
	public Work workDelete(int index) throws FileNotFoundException, IOException {
		
		if(index < 0 || index >= workList.size()) return null;
		
		Work deleteTarget = workList.remove(index);
		
		saveFile();
		
		return deleteTarget;
	}
	
}
