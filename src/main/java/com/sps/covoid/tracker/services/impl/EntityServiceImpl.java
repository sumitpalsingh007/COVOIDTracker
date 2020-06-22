package com.sps.covoid.tracker.services.impl;

import com.sps.covoid.tracker.entities.StateStats;
import com.sps.covoid.tracker.repository.StatsRepository;
import com.sps.covoid.tracker.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * The type Entity service.
 */
@Service
public class EntityServiceImpl implements EntityService {

    private final EntityManager entityManager;

    private final StatsRepository statsRepository;

    /**
     * Instantiates a new Entity service.
     *
     * @param entityManager the entity manager
     */
    public EntityServiceImpl(final EntityManager entityManager, final StatsRepository statsRepository) {
        this.entityManager = entityManager;
        this.statsRepository = statsRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void persistCoronaData(final List<StateStats> dataList) {
        dataList.forEach(entityManager::merge);
    }

    /**
     * Get the state wise corona data
     *
     * @return {@link List} of {@link StateStats}
     */
    @Override
    public List<StateStats> getStateWiseCoronaData() {
        return statsRepository.getAllStats();
    }
}
