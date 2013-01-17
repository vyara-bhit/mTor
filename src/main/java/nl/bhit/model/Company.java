package nl.bhit.model;

import java.util.Set;
import java.util.TreeSet;

public class Company {
	private String name;
	private Set<Project> projects;
	
	public Company(String name){
		this.name = name;
		this.projects = new TreeSet<Project>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addProject(Project project){
		projects.add(project);
	}
	
	public void removeProject(Project project){
		projects.remove(project);
	}
}
