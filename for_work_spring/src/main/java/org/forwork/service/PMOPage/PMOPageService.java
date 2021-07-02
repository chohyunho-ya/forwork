package org.forwork.service.PMOPage;

import java.util.List;

import org.forwork.domain.Member;
import org.forwork.domain.Project;
import org.forwork.dto.PMODto;

public interface PMOPageService {
	
	public int update(PMODto dto);
	public List<PMODto> getList(String approval_id);
	public PMODto getProject(String project_id);
	public List<Member> getMemberList(String project_id);
	public PMODto getProjectTimeline(String project_id);
	public List<PMODto> countProject();
}
