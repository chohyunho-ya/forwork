package org.forwork.service.ScrumBoard;

import java.util.List;

import org.forwork.domain.Sprint;
import org.forwork.mapper.SprintMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class SprintServiceImpl implements SprintService {
	
	private SprintMapper mapper;

	@Override
	public int insertSprint(Sprint sprint) {
		
		log.info("Insert Sprint........!!!" + sprint);
		
		return mapper.insertSprint(sprint);
	}

	@Override
	public List<Sprint> listSprint(String projcet_id) {
		
		log.info("List Sprint..........!!!!");
		
		return mapper.listSprint(projcet_id);
	}

	@Override
	public Sprint getSprint(int sprint_id) {

		log.info("Get Sprint..........!!!!" + sprint_id);
				
		return mapper.getSprint(sprint_id);
	}

	@Override
	public int deleteSprint(int sprint_id) {

		log.info("Delete Sprint..........!!!!" + sprint_id);
		
		return mapper.deleteSprint(sprint_id);
	}

	@Override
	public int updateSprint(Sprint sprint) {

		log.info("Update Sprint..........!!!!" + sprint);
		
		return mapper.updateSprint(sprint);
	}

}
