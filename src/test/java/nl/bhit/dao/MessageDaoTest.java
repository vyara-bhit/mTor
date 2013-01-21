package nl.bhit.dao;

import nl.bhit.dao.BaseDaoTestCase;
import nl.bhit.model.Message;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.NotTransactional;
import org.springframework.test.annotation.ExpectedException;

import java.util.List;

public class MessageDaoTest extends BaseDaoTestCase {
    @Autowired
    private MessageDao messageDao;

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemoveMessage() {
        Message message = new Message();

        // enter all required fields
        message.setContent("YuVgOiFsEiUgJeCrLcYwIrAhHcIkGoIaMmJlMwLkEwNgLcInDdBiMvBoXfUaFlHrTtLkWmIyAeTpKpKiTcIzGgTiQoBjJfBcDjScHwMrHkWxBeSlYuBiQrGyBaIhTdYoDfGzLjGeSeAuEuKzVbFmLbLxRqVqQiVcSuZoGkGmJgJeQtUdWbLfDuBoMaMpEdAjWqXwMhLgCsIoWxYpEkYcCaFxGvTeLxVxRnCjPmAfEuZyJuQpXrZyUjAvUqTzPwY");

        log.debug("adding message...");
        message = messageDao.save(message);

        message = messageDao.get(message.getId());

        assertNotNull(message.getId());

        log.debug("removing message...");

        messageDao.remove(message.getId());

        // should throw DataAccessException 
        messageDao.get(message.getId());
    }
}