package nl.bhit.mtor.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import nl.bhit.mtor.model.MTorMessage;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;

public class MessageDaoTest extends BaseDaoTestCase {
	@Autowired
	private MessageDao messageDao;

	@Test
	@ExpectedException(DataAccessException.class)
	public void testAddAndRemoveMessage() {
		MTorMessage message = new MTorMessage();

		// enter all required fields
		message.setContent("JcVhYnKfBkNeWbBvCjTlXpKsYaHiXpHnOdNzKoFdAjPbVcDmLvPrEuLfCnIeNtNyApAoGgXyNkXfJjJdCdUwSgOiWiRbXdVhQlPnSeLzClLhFbZvIvEkCvJoRdNqHtChPbMfTpXzEfAdDwFsTlSbPlImUfIsYsDvCoRwYlFjKcVzQxRiDfCdQiHwPiGsYzTiIrWyUnSmCpTsPzKtOvGyYfFhGjVaAbMcQpOtDyKfYmErJeRpTmHmFbNsOmYvTpA");
		message.setTimestamp(new java.util.Date());

		log.debug("adding message...");
		message = messageDao.save(message);

		message = messageDao.get(message.getId());

		assertNotNull(message.getId());

		log.debug("removing message...");

		messageDao.remove(message.getId());

		// should throw DataAccessException
		messageDao.get(message.getId());
	}

	@Test
	public void testGetMessagesWithTimestamp() {
		log.debug("starting testGetMessagesWithTimestamp...");
		MTorMessage message = createMessage(new Date());
		List<MTorMessage> messages = messageDao.getMessagesWithTimestamp(message);
		assertEquals(3, messages.size());

		messageDao.save(createMessage(DateUtils.addDays(new Date(), 1)));
		messages = messageDao.getMessagesWithTimestamp(message);
		assertEquals("message added which is newer", 3, messages.size());

		messageDao.save(createMessage(DateUtils.addDays(new Date(), -1)));
		messages = messageDao.getMessagesWithTimestamp(message);
		assertEquals("older message added", 4, messages.size());
	}

	protected MTorMessage createMessage(Date date) {
		MTorMessage message = new MTorMessage();
		message.setTimestamp(date);
		message.setContent("test message from unit test MessageDaoTest");
		return message;
	}

}