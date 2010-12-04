package com.beimin.eveapi.character.calendar;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.FullApiParserTest;
import com.beimin.eveapi.character.calendar.upcomingevents.ApiUpcomingCalendarEvent;
import com.beimin.eveapi.character.calendar.upcomingevents.UpcomingCalendarEventsParser;
import com.beimin.eveapi.character.calendar.upcomingevents.UpcomingCalendarEventsResponse;

public class UpcomingCalendarEventsParserTest extends FullApiParserTest {
	public UpcomingCalendarEventsParserTest() {
		super("/char/UpcomingCalendarEvents.xml.aspx", "/character/UpcomingCalendarEvents.xml");
	}

	@Test
	public void testUpcomingCalendarEventsParser() throws IOException, SAXException {
		UpcomingCalendarEventsParser parser = UpcomingCalendarEventsParser.getInstance();
		UpcomingCalendarEventsResponse response = parser.getUpcomingCalendarEvents(auth);
		List<ApiUpcomingCalendarEvent> events = response.getUpcomingCalendarEvents();
		assertEquals(1, events.size());
		ApiUpcomingCalendarEvent event = events.iterator().next();
		assertEquals(90864, event.getEventID());
		assertEquals(786344537L, event.getOwnerID());
		assertEquals("Some Alliance", event.getOwnerName());
		assertDate(2010, 11, 28, 17, 00, 00, event.getEventDate());
		assertEquals("Some Mining OP @ 17:00", event.getEventTitle());
		assertEquals(true, event.isImportant());
		assertEquals("Undecided", event.getResponse());
		assertEquals(
				"Alliance Mining OP Part II<br><br>This will be in home system the sunday after the patch..<br>We would really like to see as many mining barges out there as possible. PVPers are also needed for security.. See you there!!!",
				event.getEventText());
	}
}