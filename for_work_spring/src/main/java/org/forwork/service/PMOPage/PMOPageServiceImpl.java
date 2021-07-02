package org.forwork.service.PMOPage;

import java.util.List;

import org.forwork.domain.Member;
import org.forwork.dto.PMODto;
import org.forwork.mapper.MyProfileMapper;
import org.forwork.mapper.PMOPageMapper;
import org.forwork.service.myprofile.MyProfileServiceImpl;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Service
public class PMOPageServiceImpl implements PMOPageService{

	private PMOPageMapper mapper;
	
	@Override
	public List<PMODto> getList(String approval_id) {
		
		return(mapper.getProjectList(approval_id));
	}

	@Override
	public PMODto getProject(String project_id) {
		return (mapper.getProject(project_id));
	}

	@Override
	public List<Member> getMemberList(String project_id) {

		return (mapper.getMemberList(project_id));
	}

	@Override
	public PMODto getProjectTimeline(String project_id) {
		return (mapper.getProjectTimeline(project_id));
	}

	@Override
	public int update(PMODto dto) {
		int value;
		System.out.println("==============="+dto.getApproval_id());
		if(dto.getApproval_id().equals("4")){
		value=	mapper.complete(dto);
		}else{
			value=	mapper.check(dto);
		}
		return value;
	}

	@Override
	public List<PMODto> countProject() {
		return mapper.countProject();
	}



	

	
}
