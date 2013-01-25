package nl.bhit.service;

import nl.bhit.service.GenericManager;
import nl.bhit.model.Message;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface MessageManager extends GenericManager<Message, Long> {
    
}