package com.beimin.eveapi.corporation.wallet.transactions;

import org.junit.Before;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.CorpWalletTransactionsParser;
import com.beimin.eveapi.response.shared.WalletTransactionsResponse;
import static org.junit.Assume.assumeTrue;

public class CorpTransactionsParserOnlineTest extends AbstractOnlineTest {
    private final CorpWalletTransactionsParser classToTest = new CorpWalletTransactionsParser();

    @Before
    public void prepare() {
        before();
        prepareParser(classToTest);
    }

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final WalletTransactionsResponse response = classToTest.getResponse(getCorp());
        testResponse(response);
    }

    @Test
    public void getResponseKey() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final WalletTransactionsResponse response = classToTest.getResponse(getCorp(), 1000);
        testResponse(response);
    }

    @Test
    public void getResponseWalking() throws Exception {
        assumeTrue("Test not completed", TestControl.runTestIncomplete());
        testFail("Transactions walking not tested");
        final WalletTransactionsResponse response = classToTest.getResponse(getCorp(), 0, 0, 0);
        testResponse(response);
    }

}
