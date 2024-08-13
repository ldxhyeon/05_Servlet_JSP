package edu.kh.member.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.kh.member.dto.Member;

public class MemberDaoImpl implements MemberDao{
	
	// 회원 데이터가 저장될 파일 경로를 상수로 지정
	// 데이터베이스 역할
	private final String FILE_PATH = "membership_servlet.dat";
	
	// 리스트 초기화 null
	private List<Member> memberList = null;
	
	// 스트림 객체 참조 변수
	private ObjectInputStream ois = null;
	private ObjectOutputStream  oos= null;
	

	public MemberDaoImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		// 파일 객체 생성
		File file = new File(FILE_PATH);
		
		// 파일 존재여부
		if(file.exists()) {
			
			try {
			
				// 스트림 생성 
				ois = new ObjectInputStream(new FileInputStream(file));
				
				// 저장된 객체를 읽어와
				// 다운 캐스팅하여 memberList가 참조하게 함
				memberList = (ArrayList<Member>)ois.readObject();
				
				
			} finally {
				
				// try에서 발생하는 예외를
				// throws 구문으로 처리하면
				// catch() 구문을 작성하지 않아도 된다!!
				
				if(ois != null) ois.close();
				
			}
			
		}
		
		// 파일이 존재하지 않는 경우
		else {
			
			// 새로운 ArrayList를 만들어서 참조
			memberList = new ArrayList<Member>();
			
		}
		
	}
	
	
	
	@Override
	public List<Member> getMemberList() {
		
		return memberList;
	}
	
	
	
	@Override
	public boolean addMember(Member member) throws FileNotFoundException, IOException {
		
		memberList.add(member);
		
		saveFile();
		
		return true;
	}
	
	
	
	@Override
	public void saveFile() throws FileNotFoundException, IOException {
		
		// memberList를 지정된 파일에 출력(저장)
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(memberList);;
			
		} finally {
			if(oos != null) oos.close(); // flush() + 메모리 반환
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
