package nl.bhit.dao.hibernate;

import nl.bhit.model.Message;
import nl.bhit.dao.MessageDao;
import nl.bhit.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("messageDao")
public class MessageDaoHibernate extends GenericDaoHibernate<Message, Long> implements MessageDao {

    public MessageDaoHibernate() {
        super(Message.class);
    }
}
