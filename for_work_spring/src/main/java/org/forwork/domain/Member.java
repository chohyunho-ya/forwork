package org.forwork.domain;

import java.util.List;
import java.io.Serializable;

import lombok.Data;

@Data
public class Member implements Serializable {
	
	private String member_id;
	private String name;
	private String email;
	private String pw;
	private String status_id;
	private String auth;
	
	private List<Auth> authList;

	private String status_detail;
}
