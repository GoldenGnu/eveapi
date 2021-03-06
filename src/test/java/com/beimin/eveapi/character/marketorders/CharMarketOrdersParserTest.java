package com.beimin.eveapi.character.marketorders;


import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.MarketOrder;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.CharMarketOrdersParser;
import com.beimin.eveapi.response.shared.MarketOrdersResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static com.beimin.eveapi.utils.Assert.assertDate;

public class CharMarketOrdersParserTest extends FullAuthParserTest {
    public CharMarketOrdersParserTest() {
        super(ApiPath.CHARACTER, ApiPage.MARKET_ORDERS);
    }

    @Test
    public void getResponse() throws ApiException {
        final CharMarketOrdersParser parser = new CharMarketOrdersParser();
        final MarketOrdersResponse response = parser.getResponse(auth);
        assertNotNull(response);
        final Collection<MarketOrder> orders = response.getAll();
        assertEquals(9, orders.size());
        boolean found = false;
        for (final MarketOrder order : orders) {
            if (order.getOrderID() == 5630641) {
                found = true;
                assertEquals(150208955, order.getCharID());
                assertEquals(60010783, order.getStationID());
                assertEquals(2891, order.getVolEntered());
                assertEquals(2889, order.getVolRemaining());
                assertEquals(1, order.getMinVolume());
                assertEquals(0, order.getOrderState());
                assertEquals(27351, order.getTypeID());
                assertEquals(32767, order.getRange());
                assertEquals(1000, order.getAccountKey());
                assertEquals(90, order.getDuration());
                assertEquals(0.00, order.getEscrow(), 0.0001);
                assertEquals(325.00, order.getPrice(), 0.0001);
                assertEquals(0, order.getBid());
                assertDate(2007, 12, 2, 12, 18, 18, order.getIssued());
            }
        }
        assertTrue("test order wasn't found.", found);
    }
}

