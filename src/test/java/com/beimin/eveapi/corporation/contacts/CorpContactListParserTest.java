package com.beimin.eveapi.corporation.contacts;


import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.NamedList;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.CorpContactListParser;
import com.beimin.eveapi.response.corporation.ContactListResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class CorpContactListParserTest extends FullAuthParserTest {
    public CorpContactListParserTest() {
        super(ApiPath.CORPORATION, ApiPage.CONTACT_LIST);
    }

    @Test
    public void getResponse() throws ApiException {
        final CorpContactListParser parser = new CorpContactListParser();
        final ContactListResponse response = parser.getResponse(auth);
        assertNotNull(response);

        final NamedList<Contact> corporateContactList = response.getCorporateContactList();
        assertEquals("corporateContactList", corporateContactList.getName());
        assertEquals(19, corporateContactList.size());
        Contact apiContact = corporateContactList.iterator().next();
        assertEquals(126118228, apiContact.getContactID());
        assertEquals("Alpha Guardians", apiContact.getContactName());
        assertEquals(10.0, apiContact.getStanding(), 1E-15);
        assertFalse(apiContact.isInWatchlist());
        assertEquals(2, apiContact.getContactTypeID());
        assertEquals(3, apiContact.getLabelMask());

        final NamedList<Contact> allianceContactList = response.getAllianceContactList();
        assertEquals("allianceContactList", allianceContactList.getName());
        assertEquals(210, allianceContactList.size());
        apiContact = allianceContactList.iterator().next();
        assertEquals(121766272, apiContact.getContactID());
        assertEquals("X-COM", apiContact.getContactName());
        assertEquals(5.0, apiContact.getStanding(), 1E-15);
        assertFalse(apiContact.isInWatchlist());
        assertEquals(16159, apiContact.getContactTypeID());
        assertEquals(1, apiContact.getLabelMask());
    }
}

