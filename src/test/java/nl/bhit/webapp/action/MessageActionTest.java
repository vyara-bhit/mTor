package nl.bhit.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import nl.bhit.service.MessageManager;
import nl.bhit.model.Message;
import nl.bhit.webapp.action.BaseActionTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MessageActionTest extends BaseActionTestCase {
    private MessageAction action;

    @Before
    public void onSetUp() {
        super.onSetUp();

        action = new MessageAction();
        MessageManager messageManager = (MessageManager) applicationContext.getBean("messageManager");
        action.setMessageManager(messageManager);

        // add a test message to the database
        Message message = new Message();

        // enter all required fields
        message.setContent("NuIiVuNwUzUwGySmEfAyHsZjCyYdFzEdXeChOlMkLrKeYdEqEnAwOyAsBtBeHlWuWvHbCyTeGtFhMkDsNqHuHkLuWcMgUrFpShFtUuSkJtZbZtKmXjQhUqCgEzQmThMyVvQwPmDiJjVhYqTrCiIbVqPgHfAqDhRlLpSoSpDgMlDdSaGsEyGhQdIpWkMuAjKhCuTmLcPvPlJxVsFfVcVkZyRzWmVyJkTjSgOoNwNhAbPzAzFjUoGlMsXtPpAkBdJ");
        message.setTimestamp(new java.util.Date());

        messageManager.save(message);
    }

    @Test
    public void testGetAllMessages() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getMessages().size() >= 1);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        MessageManager messageManager = (MessageManager) applicationContext.getBean("messageManager");
        messageManager.reindex();

        action.setQ("*");
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertEquals(4, action.getMessages().size());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setId(-1L);
        assertNull(action.getMessage());
        assertEquals("success", action.edit());
        assertNotNull(action.getMessage());
        assertFalse(action.hasActionErrors());
    }

    @Test
    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setId(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getMessage());

        Message message = action.getMessage();
        // update required fields
        message.setContent("DpHuGrOtKxArDaPiUvDhZfXuOfUwAvFwKeQqAbRaIsDlXxRuPsSyXpWuOcNuVvMsNjXzXnWfWwTfPvLpMlOpEkMoUaZgXfOxUuWgNqOuTwKpXmNvLaFhWdPgOaXuPcJhBrMhGgRlRnLoLiZtMdHlMrGrMaJbQqKxSrTtQgThZkJoExLiPfQkOcRhNgIfBnWsSbFbBkJxAqBcCfOfCsTwJrUmFeUpWpCnCfIwSqOyLxLqHqMrDwMzBkZhKsTqGsN");
        message.setTimestamp(new java.util.Date());

        action.setMessage(message);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    @Test
    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Message message = new Message();
        message.setId(-2L);
        action.setMessage(message);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}