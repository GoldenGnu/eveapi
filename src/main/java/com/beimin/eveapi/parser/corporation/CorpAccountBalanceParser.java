package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractAccountBalanceParser;
import com.beimin.eveapi.response.shared.AccountBalanceResponse;

public class CorpAccountBalanceParser extends AbstractAccountBalanceParser {
    public CorpAccountBalanceParser() {
        super(ApiPath.CORPORATION);
    }

    @Override
    public AccountBalanceResponse getResponse(final ApiAuth auth) throws ApiException {
        return super.getResponse(auth);
    }
}
