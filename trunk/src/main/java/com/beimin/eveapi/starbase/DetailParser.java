package com.beimin.eveapi.starbase;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class DetailParser extends AbstractApiParser<DetailResponse> {
	private static final String STARBASE_DETAIL_URL = "/StarbaseDetail.xml.aspx";

	public DetailParser() {
		super(DetailResponse.class);
	}

	public DetailResponse getDetail(ApiAuth auth, int itemID) throws IOException, SAXException {
		String requestUrl = EVE_API_URL;
		requestUrl += CORP_PATH;
		requestUrl += STARBASE_DETAIL_URL;
		requestUrl += auth.getUrlParams();
		requestUrl += "&version=2";
		requestUrl += "&itemID=" + itemID;
		return getResponse(requestUrl, getDigester());
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addBeanPropertySetter("eveapi/result/generalSettings/usageFlags");
		digester.addBeanPropertySetter("eveapi/result/generalSettings/deployFlags");
		digester.addBeanPropertySetter("eveapi/result/generalSettings/allowCorporationMembers");
		digester.addBeanPropertySetter("eveapi/result/generalSettings/allowAllianceMembers");
		digester.addBeanPropertySetter("eveapi/result/generalSettings/claimSovereignty");

		digester.addObjectCreate("eveapi/result/combatSettings/onStandingDrop", CombatSetting.class);
		digester.addSetProperties("eveapi/result/combatSettings/onStandingDrop");
		digester.addSetNext("eveapi/result/combatSettings/onStandingDrop", "setOnStandingDrop");

		digester.addObjectCreate("eveapi/result/combatSettings/onStatusDrop", CombatSetting.class);
		digester.addSetProperties("eveapi/result/combatSettings/onStatusDrop");
		digester.addSetNext("eveapi/result/combatSettings/onStatusDrop", "setOnStatusDrop");

		digester.addObjectCreate("eveapi/result/combatSettings/onAggression", CombatSetting.class);
		digester.addSetProperties("eveapi/result/combatSettings/onAggression");
		digester.addSetNext("eveapi/result/combatSettings/onAggression", "setOnAggression");

		digester.addObjectCreate("eveapi/result/combatSettings/onCorporationWar", CombatSetting.class);
		digester.addSetProperties("eveapi/result/combatSettings/onCorporationWar");
		digester.addSetNext("eveapi/result/combatSettings/onCorporationWar", "setOnCorporationWar");

		digester.addObjectCreate("eveapi/result/rowset/row", FuelLevel.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addFuelLevel");
		return digester;
	}

	public static DetailParser getInstance() {
		return new DetailParser();
	}
}