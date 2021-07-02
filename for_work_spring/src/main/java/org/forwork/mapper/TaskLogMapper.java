package org.forwork.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.forwork.domain.TaskLog;

public interface TaskLogMapper {
	public int insertLog(@Param("task_id")String task_id,@Param("content")String content,@Param("project_id")int project_id);
	public List<TaskLog> getLogList(int task_id);
	public TaskLog getLog(String task_id);
}
