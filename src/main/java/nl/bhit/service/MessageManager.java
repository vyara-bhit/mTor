package nl.bhit.service;

import nl.bhit.service.GenericManager;
import nl.bhit.model.MTorMessage;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface MessageManager extends GenericManager<MTorMessage, Long> {
    
}