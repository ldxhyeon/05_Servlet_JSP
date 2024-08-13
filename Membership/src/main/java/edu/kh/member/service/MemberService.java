package edu.kh.member.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.kh.member.dto.Member;

public interface MemberService {

	boolean addMember(String name, String phone) throws FileNotFoundException, IOException;

	List<Member> getMemberList();

	List<Member> selectName(String searchName);


}
