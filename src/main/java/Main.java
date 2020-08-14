import config.AppHealthCheck;
import config.BasicConfig;
import controller.MainController;
import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import logic.DataHarvester;


public class Main extends Application<BasicConfig> {

    public static void main(String[] args) throws Exception {
        new Main().run("server", "config.yml");
    }

    @Override
    public void run(BasicConfig basicConfig, Environment environment) {

        environment
                .healthChecks()
                .register("application", new AppHealthCheck());

        DataHarvester testSelenium = new DataHarvester(basicConfig.getRemoteAddress());

        environment
                .jersey()
                .register(new MainController(testSelenium));
    }

    @Override
    public void initialize(Bootstrap<BasicConfig> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        super.initialize(bootstrap);
    }
}
