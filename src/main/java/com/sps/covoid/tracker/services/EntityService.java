package com.sps.covoid.tracker.services;

import com.sps.covoid.tracker.entities.StateStats;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface Entity service.
 */
public interface EntityService {

    /**
     * Persist corona data.
     *
     * @param dataList the data list
     */
    void persistCoronaData(List<StateStats> dataList);

    /**
     * Get the state wise corona data
     * @return {@link List} of {@link StateStats}
     */
    List<StateStats> getStateWiseCoronaData();
}
