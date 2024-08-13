package edu.kh.member.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.kh.member.dto.Member;

public interface MemberDao {

	List<Member> getMemberList();

	boolean addMember(Member member) throws FileNotFoundException, IOException;
	
	void saveFile() throws FileNotFoundException, IOException;


}
