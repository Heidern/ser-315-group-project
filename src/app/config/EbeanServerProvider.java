package config;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.google.inject.Provider;

public class EbeanServerProvider implements Provider<EbeanServer> {

    @Override
    public EbeanServer get() {

        // EbeanServer configured by ebean.properties
        return Ebean.getDefaultServer();
    }
}