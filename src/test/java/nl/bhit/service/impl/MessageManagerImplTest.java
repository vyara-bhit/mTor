package nl.bhit.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import nl.bhit.dao.MessageDao;
import nl.bhit.model.Message;
import nl.bhit.model.Project;
import nl.bhit.model.Status;
import nl.bhit.model.soap.SoapMessage;
import nl.bhit.service.GenericManager;

import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageManagerImplTest extends BaseManagerMockTestCase2 {
	private MessageManagerImpl manager = null;
	private MessageDao dao = null;
	@Autowired
	private GenericManager<Project, Long> projectManager;

	@Before
	public void setUp() {
		dao = context.mock(MessageDao.class);
		manager = new MessageManagerImpl(dao);
		manager.setProjectManager(projectManager);
	}

	@After
	public void tearDown() {
		manager = null;
	}

	@Test
	public void testGetMessage() {
		log.debug("testing get...");

		final Long id = 7L;
		final Message message = new Message();

		// set expected behavior on dao
		context.checking(new Expectations() {
			{
				one(dao).get(with(equal(id)));
				will(returnValue(message));
			}
		});

		Message result = manager.get(id);
		assertSame(message, result);
	}

	@Test
	public void testAddSoapMessage() {
		log.debug("testAddSoapMessage...");
		SoapMessage soapMessage = new SoapMessage();
		String content = "blablabla";
		soapMessage.setContent(content);
		soapMessage.setProjectId(-1L);
		soapMessage.setStatus(Status.INFO);
		final Message example = manager.soapMessageToMessage(soapMessage);
		// set expected behavior on dao
		context.checking(new Expectations() {
			{
				one(dao).save(with(equal(example)));
				will(returnValue(example));
			}
		});

		Message message = manager.saveMessage(soapMessage);
		assertNotNull(message.getProject());
		assertEquals(new Long(-1L), message.getProject().getId());
		assertEquals(content, message.getContent());
		assertEquals(Status.INFO, message.getStatus());

	}

	@Test
	public void testGetMessages() {
		log.debug("testing getAll...");

		final List messages = new ArrayList();

		// set expected behavior on dao
		context.checking(new Expectations() {
			{
				one(dao).getAll();
				will(returnValue(messages));
			}
		});

		List result = manager.getAll();
		assertSame(messages, result);
	}

	@Test
	public void testSaveMessage() {
		log.debug("testing save...");

		final Message message = new Message();
		// enter all required fields
		message.setContent("PeIjCqNwWhSwHnKrVgDiTrWvJmBuGhNfGcMqUsWfSrBcFvCcTfWfIaBeKcBvEpYwQcSlSgPmGsYoUbNzEzXhTcMpKxKoItUqOxVnKdLgOjClWcBkCiXcUmKzUxRiOqWjLlXuSkBxCjLaHmNnRoSnNwOwCnGvZxUwWbRoGvOyQgQqRwUaRhOtKwLqRjNlFbEyOfBbXfMcPyBbIaDvXvDfMfSwMgTjXgNqRmHdQhNiIfDwGrNaBsHaTfVdJnOpPkB");

		// set expected behavior on dao
		context.checking(new Expectations() {
			{
				one(dao).save(with(same(message)));
			}
		});

		manager.save(message);
	}

	@Test
	public void testRemoveMessage() {
		log.debug("testing remove...");

		final Long id = -11L;

		// set expected behavior on dao
		context.checking(new Expectations() {
			{
				one(dao).remove(with(equal(id)));
			}
		});

		manager.remove(id);
	}
}