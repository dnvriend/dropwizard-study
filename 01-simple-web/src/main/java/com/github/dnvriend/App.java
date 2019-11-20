package com.github.dnvriend;

import com.github.dnvriend.controller.HelloController;
import com.github.dnvriend.controller.PersonController;
import com.github.dnvriend.dao.PersonDao;
import com.github.dnvriend.jpa.PersonJpa;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfig> {

    public static void main(final String[] args) throws Exception {
        new App().run(args);
    }

    private final HibernateBundle<AppConfig> hibernateBundle =
        new HibernateBundle<AppConfig>(PersonJpa.class) {
            @Override
            public DataSourceFactory getDataSourceFactory(AppConfig configuration) {
                return configuration.getDataSourceFactory();
            }
        };

    @Override
    public String getName() {
        return "simple-web";
    }

    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap) {
        super.initialize(bootstrap);
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final AppConfig configuration, final Environment environment) {
        PersonDao personDao = new PersonDao(hibernateBundle.getSessionFactory());
        environment.jersey().register(HelloController.class);
        environment.jersey().register(new PersonController(personDao));
    }

}
