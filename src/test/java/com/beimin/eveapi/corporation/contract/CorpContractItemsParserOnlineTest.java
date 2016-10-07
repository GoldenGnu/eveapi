package com.beimin.eveapi.corporation.contract;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.model.shared.Contract;
import com.beimin.eveapi.model.shared.ContractType;
import com.beimin.eveapi.parser.corporation.ContractItemsParser;
import com.beimin.eveapi.parser.corporation.ContractsParser;
import com.beimin.eveapi.response.shared.ContractItemsResponse;
import com.beimin.eveapi.response.shared.ContractsResponse;
import java.util.Set;

public class CorpContractItemsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		addNullOk("getDateAccepted"); //Not accepted yet
		addNullOk("getDateCompleted"); //Not completed yet
		addNullOk("getRawQuantity"); //Never returned by the API (API BUG)
		ContractsParser contractsParser = new ContractsParser();
		ContractsResponse contractsResponse = contractsParser.getResponse(getCorp());
		testResponse(contractsResponse);
		Set<Contract> contracts = contractsResponse.getAll();
		ContractItemsParser parser = new ContractItemsParser();
		test(contracts);
		for (Contract contract : contracts) {
			if (contract.getType() == ContractType.COURIER) {
				continue;
			}
			if (contract.getType() == ContractType.LOAN) {
				continue;
			}
			
			ContractItemsResponse response = parser.getResponse(getCorp(), contract.getContractID()); 
			testResponse(response);
		}
	}

}