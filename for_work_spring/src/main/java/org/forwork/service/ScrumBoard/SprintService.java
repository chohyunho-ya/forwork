package org.forwork.service.ScrumBoard;

import java.util.List;

import org.forwork.domain.Sprint;

public interface SprintService {
	
	public int insertSprint(Sprint sprint);
	
	public List<Sprint> listSprint(String projcet_id);
	
	public Sprint getSprint(int sprint_id);
	
	public int deleteSprint(int sprint_id);
	
	public int updateSprint(Sprint sprint);
}
