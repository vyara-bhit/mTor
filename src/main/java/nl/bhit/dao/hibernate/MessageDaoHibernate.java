package nl.bhit.dao.hibernate;

import java.util.List;

import nl.bhit.model.MTorMessage;
import nl.bhit.model.User;
import nl.bhit.dao.MessageDao;
import nl.bhit.dao.hibernate.GenericDaoHibernate;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

@Repository("messageDao")
public class MessageDaoHibernate extends GenericDaoHibernate<MTorMessage, Long> implements MessageDao {

    public MessageDaoHibernate() {
        super(MTorMessage.class);
    }
    
    @SuppressWarnings("unchecked")
    public List<MTorMessage> getMessagesWithTimestamp(MTorMessage message) {
    	String query1 = "select * from message where TIMESTAMP<='"
				+ message.getTimestamp().toString().substring(0, 19) + "';";
    	SQLQuery qry = getSession().createSQLQuery(query1);
        qry.addEntity(MTorMessage.class);
        return qry.list();
    }
}
