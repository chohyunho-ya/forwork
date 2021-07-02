package org.forwork.mapper;

import java.util.List;

import org.forwork.domain.Project;

public interface ProjectMapper {
	void projectCreate (Project project);
	List<Project> getProjectList(int member_id);
	void createProject(Project project);
    void createMemberProjectRelationPm(Project project);
    void createMemberProjectRelationPa(Project project);
}
