package nl.bhit.mtor.server.timer;

import java.util.List;

import nl.bhit.mtor.model.Project;
import nl.bhit.mtor.model.Status;
import nl.bhit.mtor.model.User;
import nl.bhit.mtor.service.MailEngine;
import nl.bhit.mtor.service.ProjectManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class AlertSender {
	@Autowired(
			required = false)
	private ProjectManager projectManager;
	@Autowired
	MailSender mailSender;
	@Autowired
	SimpleMailMessage mailMessage;
	@Autowired
	MailEngine mailEngine;

	protected final Log log = LogFactory.getLog(AlertSender.class);

	public void process() {
		List<Project> projects = projectManager.getAllDistinct();

		for (Project project : projects) {
			if (!project.hasHeartBeat()) {
				sendMailToUsers(project);
			}
			if (!project.hasStatus(Status.ERROR)) {
				sendMailToUsers(project);
			}
		}
	}

	protected void sendMailToUsers(Project project) {
		for (User user : project.getUsers()) {
			sendHeartBeatAlert(user.getEmail());
		}
	}

	private void sendHeartBeatAlert(String to) {
		if (log.isDebugEnabled()) {
			log.debug("sending e-mail to user [" + to + "]...");
		}

		mailMessage.setTo(to + "<" + to + ">");

		mailMessage.setSubject("there is no heartBeat!");
		mailMessage.setText("there is no heartBeat!");
		mailEngine.send(mailMessage);
	}
}
