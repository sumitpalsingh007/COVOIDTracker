package com.sps.covoid.tracker.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The type State wise corona stats.
 */
@Entity(name = "STATE_WISE_CORONA_STATS")
public class StateStats {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ACTIVE_CASE_COUNT")
    private Long activeCasesCount;

    @Column(name = "RESOLVED_CASE_COUNT")
    private Long resolvedCasesCount;

    @Column(name = "DEATH_CASE_COUNT")
    private Long deathCasesCount;

    @Column(name = "TOTAL_CASES_COUNT")
    private Long totalCasesCount;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets active cases count.
     *
     * @return the active cases count
     */
    public Long getActiveCasesCount() {
        return activeCasesCount;
    }

    /**
     * Sets active cases count.
     *
     * @param activeCasesCount the active cases count
     */
    public void setActiveCasesCount(final Long activeCasesCount) {
        this.activeCasesCount = activeCasesCount;
    }

    /**
     * Gets resolved cases count.
     *
     * @return the resolved cases count
     */
    public Long getResolvedCasesCount() {
        return resolvedCasesCount;
    }

    /**
     * Sets resolved cases count.
     *
     * @param resolvedCasesCount the resolved cases count
     */
    public void setResolvedCasesCount(final Long resolvedCasesCount) {
        this.resolvedCasesCount = resolvedCasesCount;
    }

    /**
     * Gets death cases count.
     *
     * @return the death cases count
     */
    public Long getDeathCasesCount() {
        return deathCasesCount;
    }

    /**
     * Sets death cases count.
     *
     * @param deathCasesCount the death cases count
     */
    public void setDeathCasesCount(final Long deathCasesCount) {
        this.deathCasesCount = deathCasesCount;
    }

    /**
     * Gets total cases count.
     *
     * @return the total cases count
     */
    public Long getTotalCasesCount() {
        return totalCasesCount;
    }

    /**
     * Sets total cases count.
     *
     * @param totalCasesCount the total cases count
     */
    public void setTotalCasesCount(final Long totalCasesCount) {
        this.totalCasesCount = totalCasesCount;
    }
}
