package com.sps.covoid.tracker.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * The launcher class.
 */

@SpringBootApplication
@EnableScheduling
@EntityScan(basePackages = {"com.sps.covoid.tracker.entities"})
@ComponentScan({ "com.sps.covoid.tracker.scheduler",
        "com.sps.covoid.tracker.scraper",
        "com.sps.covoid.tracker.services.impl",
        "com.sps.covoid.tracker.controller",
        "com.sps.covoid.tracker.form"
        })
@EnableJpaRepositories(basePackages = "com.sps.covoid.tracker.repository")
public class Launcher {

    /**
     * The main method.
     *
     * @param args the input arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(Launcher.class, args);
    }
}