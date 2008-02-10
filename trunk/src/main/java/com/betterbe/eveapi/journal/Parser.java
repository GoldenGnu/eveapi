package com.betterbe.eveapi.journal;

import org.apache.commons.digester.Digester;

import com.betterbe.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {

	public Parser() {
		super(Response.class);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		// create digester here.
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}