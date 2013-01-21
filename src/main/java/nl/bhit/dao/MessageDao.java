package nl.bhit.dao;

import nl.bhit.dao.GenericDao;

import nl.bhit.model.Message;

/**
 * An interface that provides a data management interface to the Message table.
 */
public interface MessageDao extends GenericDao<Message, Long> {

}