package org.forwork.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AttendanceMapper {
	int commute(String member_id);
	int check(String member_id);
	Map<String, String> getTime(String member_id);
	int off(String member_id);
	List<Map<String, String>> getWeekAttendance(@Param("ago")String ago,@Param("member_id")String member_id);
}
