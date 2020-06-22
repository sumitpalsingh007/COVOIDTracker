package com.sps.covoid.tracker.scheduler;

import com.sps.covoid.tracker.entities.StateStats;
import com.sps.covoid.tracker.entities.User;
import com.sps.covoid.tracker.repository.UserRepository;
import com.sps.covoid.tracker.scraper.Scraper;
import com.sps.covoid.tracker.services.EntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

/**
 * The type Scheduler.
 */
@Component
public class Scheduler {

    final Logger LOGGER = LoggerFactory.getLogger(Scheduler.class);

    /**
     * The Scraper.
     */
    private final Scraper scraper;

    /**
     * The entity service.
     */
    private final EntityService entityService;

    /**
     * User repository
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * The constant THOUSAND_SECONDS.
     */
    public static final int THOUSAND_SECONDS = 1000000;

    public Scheduler(final Scraper scraper, final EntityService entityService) {
        this.scraper = scraper;
        this.entityService = entityService;
    }

    /**
     * Schedule scraping.
     */
    @Scheduled(fixedDelay = THOUSAND_SECONDS)
    public void scheduleScraping() {
        List<StateStats> sateWiseData = null;
        try {
             sateWiseData = scraper.getCovoidData();
        } catch (final IOException e) {
            LOGGER.error("error occurred while scraping data", e);
        }
        if (null != sateWiseData && !sateWiseData.isEmpty()) {
            entityService.persistCoronaData(sateWiseData);
        }
    }

    @PostConstruct
    public void init(){
        userRepository.save(new User("admin", "admin"));
    }
}
