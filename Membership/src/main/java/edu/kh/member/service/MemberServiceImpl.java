package edu.kh.member.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.member.dao.MemberDao;
import edu.kh.member.dao.MemberDaoImpl;
import edu.kh.member.dto.Member;

public class MemberServiceImpl implements MemberService{
	
	private MemberDao dao = null;
	
	public MemberServiceImpl() throws 
			FileNotFoundException, ClassNotFoundException, IOException {
		
		dao = new MemberDaoImpl();
		
	}
	
	
	
	
	
	@Override
	public boolean addMember(String name, String phone) throws FileNotFoundException, IOException {
		
		List<Member> memberList = dao.getMemberList();
		
		
		for(Member member : memberList) {
			if(phone.equals(member.getPhone())) {
				return false;
			}
		}
		
		Member member = new Member(name, phone, 0, Member.Common);
		
		boolean result = dao.addMember(member);
		
		return true;
	}
	
	
	
	
	
	@Override
	public List<Member> getMemberList() {
		
		return dao.getMemberList();
	}
	
	
	
	
	
	
	@Override
	public List<Member> selectName(String searchName) {
		
		// DAO를 이용해서 회원 전체 목록 조회
		List<Member> memberList = dao.getMemberList();
		
		// memberList에 저장된 요소(회원)중
		// 이름이 같은 회원을 찾아서
		// 검색 결과를 저장할 별도 List에 추가
		List<Member> searchList = new ArrayList<Member>();
		
		for(Member member : memberList) {
			if(member.getName().equals(searchName)) {
				searchList.add(member);
			}
		}
		
		
		
		return searchList;
	}
	
	
	
	
	
	

}
