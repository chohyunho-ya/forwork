package org.forwork.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.forwork.domain.Project;
import org.forwork.domain.ProjectLanguage;
import org.forwork.domain.TeamProgress;

@Mapper
public interface PMPageMapper {
	
	public TeamProgress getColumCount(int project_id);
	public List<TeamProgress> getPersonalCount(int project_id);
	public List<TeamProgress> getPersonalTasks(@Param("project_id")int project_id,@Param("responsibility")int responsibility);
	public List<Project> getProjects(int member_id);
	public int insertLang(ProjectLanguage prLang);
	public List<ProjectLanguage> getLang(int project_id);
	public int deleteLang(int pr_lang_seq);
	public int updateLang(ProjectLanguage prLang);
	public ProjectLanguage getSeq(int pr_lang_seq);
	public Project isPm(@Param("project_id")int project_id, @Param("member_id")int member_id);

}
