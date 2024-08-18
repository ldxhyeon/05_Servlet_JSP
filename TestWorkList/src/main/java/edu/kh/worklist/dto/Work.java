package edu.kh.worklist.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
// 파일 저장 기능을 사용하기 위한 implements Serializable
public class Work implements Serializable{

	private String title;
	private String detail;
	private boolean complete;
	private LocalDateTime regDate;
	
}
