package edu.kh.worklist.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.worklist.dao.WorkListDao;
import edu.kh.worklist.dao.WorkListDaoImpl;
import edu.kh.worklist.dto.Work;

public class WorkListServiceImpl implements WorkListService{

	// dao 객체 생성 전 초기화
	private WorkListDao dao = null;
	
	// 기본생성자
	public WorkListServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
		
		dao = new WorkListDaoImpl();
	}
	
	
	
	
	
	@Override
	public Map<String, Object> workListFullView() {
		
		List<Work> workList = dao.workListFullView();
		
		// 완료된 할 일 개수 카운트
		int completeCount = 0;
		
		// isComplete() 기본값 false
		// true이면 count ++
		for(Work work : workList) {
			if(work.isComplete()) {
				completeCount++;
			}
		}
		
		// 메서드에서 반환은 하나의 값 또는 객체 밖에 할 수 없기 때문에
		// Map이라는 컬렉션을 이용해 여러 값을 한 번에 담아서 반환
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("workList", workList);
		map.put("completeCount", completeCount);
		
		
		return map;
	
	}
	
	
	
	@Override
	public int workAdd(String title, String detail) throws FileNotFoundException, IOException {
		
		Work work = new Work(title, detail, false, LocalDateTime.now());
		
		return dao.workAdd(work);
	}
	
	
	
	
	@Override
	public Work workDetailView(int index) {
		
		Work work = dao.workDetailView(index);
		
		return work;
	}
	
	
	
	@Override
	public boolean workComplete(int index) throws FileNotFoundException, IOException {
		
		return dao.workComplete(index);
	}
	
	
	
	@Override
	public boolean workUpdate(int index, String title, String detail) throws FileNotFoundException, IOException {
		
		return dao.workUpdate(index, title, detail);
	}
	
	
	@Override
	public String todoDelete(int index) throws FileNotFoundException, IOException {
		
		Work deleteTarget = dao.workDelete(index);
		
		if(deleteTarget != null) return deleteTarget.getTitle();
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
