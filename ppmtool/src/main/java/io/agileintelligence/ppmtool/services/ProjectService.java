package io.agileintelligence.ppmtool.services;

import io.agileintelligence.ppmtool.exceptions.ProjectIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.repositories.ProjectRepository;

import java.util.Objects;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdate(Project project) {

		try{
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		}
		catch (Exception ex){
			throw new ProjectIdException("Project Id "+project.getProjectIdentifier().toUpperCase()+" already Exists !!");
		}
	}

	public Project findProjectByIdentifier(String projectId){

		Project project = projectRepository.findByProjectIdentifier(projectId);
		if(Objects.isNull(project)){
			throw new ProjectIdException("Project Id "+projectId+" does not Exist !!");
		}
		return project;
	}

	public Iterable<Project> findAllProjects(){
		return projectRepository.findAll();
	}
}
