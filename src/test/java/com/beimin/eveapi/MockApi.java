package com.beimin.eveapi;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import com.beimin.eveapi.utils.EveApiRouteBuilder;

public class MockApi extends Thread {

    public static void main(final String[] args) {
        final MockApi mockApi = new MockApi();
        mockApi.start();
    }

    @Override
    public void run() {
        try {
            final CamelContext context = new DefaultCamelContext();
            context.addRoutes(new EveApiRouteBuilder());
            context.start();
            while (isAlive()) {
                Thread.sleep(1000);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
