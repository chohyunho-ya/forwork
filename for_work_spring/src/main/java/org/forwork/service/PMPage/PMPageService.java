package org.forwork.service.PMPage;

import java.util.List;

import org.forwork.domain.Project;
import org.forwork.domain.ProjectLanguage;
import org.forwork.domain.TeamProgress;

public interface PMPageService {
	
	public TeamProgress getColumCount(int project_id);
	public List<TeamProgress> getPersonalCount(int project_id);
	public List<TeamProgress> getPersonalTasks(int project_id,int responsibility);
	public List<Project> getProjects(int member_id);
	public int insertLang(ProjectLanguage prLang);
	public List<ProjectLanguage> getLang(int project_id);
	public int deleteLang(int pr_lang_seq);
	public int updateLang(ProjectLanguage prLang);
	public ProjectLanguage getSeq(int pr_lang_seq);
	public Project isPm(int project_id, int member_id);

}
