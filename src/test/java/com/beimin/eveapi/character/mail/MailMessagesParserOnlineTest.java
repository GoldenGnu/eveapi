package com.beimin.eveapi.character.mail;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.pilot.MailMessagesParser;
import com.beimin.eveapi.response.pilot.MailMessagesResponse;

public class MailMessagesParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		MailMessagesParser parser = new MailMessagesParser();
		MailMessagesResponse response = parser.getResponse(getPilot());
		testResponse(response);
	}

}