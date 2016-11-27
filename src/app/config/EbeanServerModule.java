package config;
import com.avaje.ebean.EbeanServer;
import com.google.inject.*;
public class EbeanServerModule extends AbstractModule {
    @Override
    public void configure() {
        bind(EbeanServer.class).toProvider(EbeanServerProvider.class);
    }
}