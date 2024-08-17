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
	
	
	@Override
	public Member getMember(int index) {
		
		return dao.getMember(index);
	}
	
	
	@Override
	public boolean updateMember(int index, String phone) throws FileNotFoundException, IOException {
		
		Member target = dao.getMember(index);
		target.setPhone(phone);
		
		dao.saveFile();
		
		return true;
	}
	
	
	
	@Override
	public int updateAmount(int index, int amount) throws FileNotFoundException, IOException {
		
		Member target = dao.getMember(index);
		
		// 이전 금액
		int before = target.getAmount();
		
		// 대상 회원의 금액 누적하기
		target.setAmount(before + amount);
		
		
		// 등급 판별
		// 일반   : 0 ~ 100,000 미만
		// 골드   : 100,000 이상 ~ 1,000,000 미만
		// 다이아 : 1,000,000 이상
		
		int grade = 0;
		
		int currentAmount = target.getAmount();
		if(currentAmount < 100000) grade = Member.Common;
		else if (currentAmount < 1000000) grade = Member.GOLD;
		else grade = Member.DIAMOND;
		
		int result = 4; // 등급 변경 없으면 4 반환
		
		// 이전 회원의 등급과 새로 판별된 등급이 다른 경우
		if(target.getGrade() != grade) {
			// 회원의 등급을 판별된 등급으로 변경
			target.setGrade(grade);
			result = grade;
		}
		
		
		dao.saveFile();
		
		return result;
	}
	
	
	@Override
	public boolean deleteMember(int index) throws FileNotFoundException, IOException {
		
			List<Member> memberList = dao.getMemberList();
			
			Member target = dao.getMember(index);
			
			boolean result = memberList.remove(target);
			
			dao.saveFile(); 
			
			return result;
	}
	
	
	
	
	
	

}
