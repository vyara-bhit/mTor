package nl.bhit.model;

import java.util.Set;
import java.util.TreeSet;

public class Project {
	private String name;
	private Set<String> messages;
	
	public Project(String name){
		this.name = name;
		this.messages = new TreeSet<String>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	public void addMessage(String message){
		messages.add(message);
	}
	
	public void removeMessage(String message){
		messages.remove(message);
	}
	
}
