package edu.kh.member.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor  // 기본 생성자
@NoArgsConstructor // 전체 필드 매개 변수 생성자
@ToString // toString() 오버라이딩
@EqualsAndHashCode // equals(), hashCode() 오버라이딩
public class Member implements Serializable{
	
	public static final int Common = 0;
	public static final int GOLD = 1;
	public static final int DIAMOND = 2;
	
	private String name;
	private String phone;
	private int amount;
	private int grade;

}
