package nl.bhit.mTor.client.provider;

import java.io.File;

import nl.bhit.mTor.client.annotation.MTorMessage;
import nl.bhit.mTor.client.annotation.MTorMessageProvider;
import nl.bhit.model.Status;
import nl.bhit.model.soap.SoapMessage;

/**
 * This message provider has one method which will give a soapMessage about the diskSpace.
 * 
 * @author tibi
 */
@MTorMessageProvider
public class DiskSpaceMTorMessageProvider {

	public static long ERROR_LIMIT = 1000000L;
	public static long WARN_LIMIT = 10000000L;

	/**
	 * this method will return a warning message when the WARN_LIMMI is reached and an error message when the ERROR_LIMIT is reached. Null when all is fine.
	 * 
	 * @return
	 */
	@MTorMessage
	public static SoapMessage getDsikSpaceMessage() {
		SoapMessage message = new SoapMessage();
		File tmp = new File("/");
		long free = tmp.getFreeSpace();
		if (free < ERROR_LIMIT) {
			message.setContent("The hard drive is almost full!");
			message.setStatus(Status.ERROR);
			return message;
		}
		if (free < WARN_LIMIT) {
			message.setContent("The hard drive is getting full!");
			message.setStatus(Status.WARN);
			return message;
		}
		return null;
	}
}
