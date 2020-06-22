package com.sps.covoid.tracker.repository;

import com.sps.covoid.tracker.entities.StateStats;
import com.sps.covoid.tracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Stats repository.
 */
@Repository
public interface StatsRepository extends JpaRepository<StateStats, Long> {

    /**
     * Gets all stats.
     *
     * @return the all stats
     */
    @Query("select s from STATE_WISE_CORONA_STATS s")
    List<StateStats> getAllStats();
}
