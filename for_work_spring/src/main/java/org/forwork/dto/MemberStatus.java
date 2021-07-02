package org.forwork.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MemberStatus {
	AWAY("자리비움"),
	MEETING("회의중"),
	WORKING("근무중"),
	OFF("오프라인"),
	NULL("상태없음");
	
	private String statusDetail;
	
	public static MemberStatus getStatusDetailById(String id) {
		if(id == null) {
			return MemberStatus.NULL;
		}
		if(id.equals("1")) {
			return MemberStatus.AWAY;
		} else if(id.equals("2")) {
			return MemberStatus.MEETING;
		} else if (id.equals("3")) {
			return MemberStatus.WORKING;
		} else if (id.equals("4")) {
			return MemberStatus.OFF;
		}
		return MemberStatus.NULL;
	}
}
