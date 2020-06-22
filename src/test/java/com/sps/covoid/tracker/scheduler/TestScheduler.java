package com.sps.covoid.tracker.scheduler;

import com.sps.covoid.tracker.entities.StateStats;
import com.sps.covoid.tracker.repository.UserRepository;
import com.sps.covoid.tracker.scraper.Scraper;
import com.sps.covoid.tracker.services.EntityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class TestScheduler {

    @InjectMocks
    Scheduler scheduler;

    /**
     * The Scraper.
     */
    @Mock
    private Scraper scraper;

    /**
     * The entity service.
     */
    @Mock
    private EntityService entityService;

    /**
     * User repository
     */
    @Mock
    private UserRepository userRepository;

    @Test
    public void testSchedulerForValidResponse() throws IOException {
        StateStats stat = Mockito.mock(StateStats.class);
        //Given
        Mockito.when(scraper.getCovoidData()).thenReturn(Arrays.asList(stat));

        //When
        scheduler.scheduleScraping();

        //Then
        Mockito.verify(entityService).persistCoronaData(Arrays.asList(stat));
    }

    @Test
    public void testSchedulerForNullResponse() throws IOException {
        StateStats stat = Mockito.mock(StateStats.class);
        //Given
        Mockito.when(scraper.getCovoidData()).thenReturn(null);

        //When
        scheduler.scheduleScraping();

        //Then
        Mockito.verify(entityService, Mockito.times(0)).persistCoronaData(null);
    }

    @Test
    public void testSchedulerForNoResponse() throws IOException {
        StateStats stat = Mockito.mock(StateStats.class);
        //Given
        Mockito.when(scraper.getCovoidData()).thenReturn(Arrays.asList());

        //When
        scheduler.scheduleScraping();

        //Then
        Mockito.verify(entityService, Mockito.times(0)).persistCoronaData(Arrays.asList());
    }

    @Test
    public void testSchedulerForException() throws IOException {
        StateStats stat = Mockito.mock(StateStats.class);
        //Given
        Mockito.when(scraper.getCovoidData()).thenThrow(new IOException());

        //When
        scheduler.scheduleScraping();

        //Then
        Mockito.verify(entityService, Mockito.times(0)).persistCoronaData(Mockito.any());
    }
}
