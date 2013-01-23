package nl.bhit.model;

import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT")
public class Project {
	private Long id;
	private String name;
	private Set<Message> messages;
	private Company company;

	public Project() {
		this.messages = new TreeSet<Message>();
	}

	public Project(String name) {
		this.name = name;
		this.messages = new TreeSet<Message>();
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COMPANY_FK")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME", unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "PROJECT_FK")
	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public void addMessage(Message message) {
		messages.add(message);
	}

	public void removeMessage(String message) {
		messages.remove(message);
	}

	public String statusOfProject() {
		Set<Message> currentMessages = getMessages();
		if (!currentMessages.isEmpty()) {
			for (Message message : currentMessages) {
				Status status = message.getStatus();
				if (status.equals(Status.ERROR)) {
					return Status.ERROR.toString();
				}
			}
			for (Message message : currentMessages) {
				Status status = message.getStatus();
				if (status.equals(Status.WARN)) {
					return Status.WARN.toString();
				}
			}
		}
		return Status.INFO.toString();
	}
}