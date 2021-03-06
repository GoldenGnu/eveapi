package com.beimin.eveapi.character.mail;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.pilot.MailingListsParser;
import com.beimin.eveapi.response.pilot.MailingListsResponse;
import static org.junit.Assume.assumeTrue;

public class MailingListsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final MailingListsParser parser = new MailingListsParser();
        prepareParser(parser);

        final MailingListsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
