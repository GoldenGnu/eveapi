package com.beimin.eveapi.member.security;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ParserTest {

	@Test
	public void testMemberTrackingParser() throws IOException, SAXException {
		Parser parser = Parser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/MemberSecurity.xml");
		Response response = parser.getResponse(input);
		assertNotNull(response);
		// Set<Member> members = response.getMembers();
		// for (Member member : members) {
		// System.out.println(member.getName());
		// }
		assertTrue("Todo: ", true);
	}
}