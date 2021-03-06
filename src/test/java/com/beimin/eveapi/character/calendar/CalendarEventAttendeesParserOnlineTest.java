package com.beimin.eveapi.character.calendar;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.model.pilot.UpcomingCalendarEvent;
import com.beimin.eveapi.parser.pilot.CalendarEventAttendeesParser;
import com.beimin.eveapi.parser.pilot.UpcomingCalendarEventsParser;
import com.beimin.eveapi.response.pilot.CalendarEventAttendeesResponse;
import com.beimin.eveapi.response.pilot.UpcomingCalendarEventsResponse;
import static org.junit.Assume.assumeTrue;

public class CalendarEventAttendeesParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final UpcomingCalendarEventsParser upcomingCalendarEventsParser = new UpcomingCalendarEventsParser();
        final UpcomingCalendarEventsResponse upcomingCalendarEventsResponse = upcomingCalendarEventsParser.getResponse(getCharacter());
        final Set<UpcomingCalendarEvent> upcomingCalendarEvents = upcomingCalendarEventsResponse.getAll();
        test(upcomingCalendarEvents);
        for (final UpcomingCalendarEvent upcomingCalendarEvent : upcomingCalendarEvents) {
            final CalendarEventAttendeesParser parser = new CalendarEventAttendeesParser();
            prepareParser(parser);

            final CalendarEventAttendeesResponse response = parser.getResponse(getCharacter(), upcomingCalendarEvent.getEventID());

            testResponse(response);
        }
    }

}
