package nl.bhit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(
		name = "MESSAGE")
public class Message {
	private Long id;
	private String content;
	private Project project;

	public Message(){
	}
	
	public Message(String content){
		this.content = content;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJECT_FK")
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	

	
	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO)
	@Column(
			name = "ID",
			unique = true,
			nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Column(
			name = "CONTENT",
			unique = true,
			nullable = false)	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
		
}
