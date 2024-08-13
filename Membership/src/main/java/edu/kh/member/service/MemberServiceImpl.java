package edu.kh.member.service;

import java.io.FileNotFoundException;
import java.io.IOException;
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
		
		
		//
		List<Member> memberList = dao.getMemberList();
		
		
		
		return null;
	}
	
	
	
	

}
