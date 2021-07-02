package org.forwork.domain;

import lombok.Data;

@Data
public class MemberMessageRelation {
	String member_id;
	String message_id;
	String is_read;
}
