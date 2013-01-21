package nl.bhit.webapp.action;

import com.opensymphony.xwork2.Preparable;
import nl.bhit.service.GenericManager;
import nl.bhit.dao.SearchException;
import nl.bhit.model.Company;
import nl.bhit.model.Message;
import nl.bhit.model.Project;
import nl.bhit.webapp.action.BaseAction;

import java.util.List;

public class MessageAction extends BaseAction implements Preparable {
    private GenericManager<Message, Long> messageManager;
    private GenericManager<Project, Long> projectManager;
    private List messages;
    private List projects;
    private Message message;
    private Long id;
    private String query;

    public void setMessageManager(GenericManager<Message, Long> messageManager) {
        this.messageManager = messageManager;
    }
    
    public void setProjectManager(GenericManager<Project, Long> projectManager) {
        this.projectManager = projectManager;
    }

    public List getMessages() {
        return messages;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String messageId = getRequest().getParameter("message.id");
            if (messageId != null && !messageId.equals("")) {
                message = messageManager.get(new Long(messageId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            messages = messageManager.search(query, Message.class);
        } catch (SearchException se) {
            addActionError(se.getMessage());
            messages = messageManager.getAll();
        }
        return SUCCESS;
    }
    
    public List getProjectCompanyList(){
    	projects = projectManager.getAll();
    	return projects;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String delete() {
        messageManager.remove(message.getId());
        saveMessage(getText("message.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (id != null) {
            message = messageManager.get(id);
        } else {
            message = new Message();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            return "cancel";
        }

        if (delete != null) {
            return delete();
        }

        boolean isNew = (message.getId() == null);

        messageManager.save(message);

        String key = (isNew) ? "message.added" : "message.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}