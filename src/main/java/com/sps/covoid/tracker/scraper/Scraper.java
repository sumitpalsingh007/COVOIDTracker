package com.sps.covoid.tracker.scraper;

import com.sps.covoid.tracker.entities.StateStats;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The type Scraper.
 */
@Component
public class Scraper {


    /**
     * Gets covoid data.
     *
     * @return List of {@link StateStats}the covoid data
     * @throws IOException the io exception
     */
    public List<StateStats> getCovoidData() throws IOException {
        final List<StateStats> statsList
                = new ArrayList<StateStats>();
        final Document doc
                = Jsoup.connect("https://www.mohfw.gov.in/").get();
        final Elements tableRows = doc.getElementById("state-data")
                .select("table")
                .select("tr");
        for (final Element stateData : tableRows) {
            final Elements stateRows = stateData.select("td");
            final Iterator<Element> itr = stateData.select("td")
                    .iterator();
            if (itr.hasNext()) {
                final Element firstElement = itr.next();
                if (!isRowNotRequired(firstElement)) {
                    final StateStats stat = new StateStats();
                    stat.setId(Long.valueOf(firstElement.html()));
                    final Element nameElement = itr.next();
                    if (nameElement.hasText()) {
                       stat.setName(nameElement.html());
                    }
                    if (itr.hasNext()) {
                        final Element activeCasesElement = itr.next();
                        if (activeCasesElement.hasText()) {
                            stat.setActiveCasesCount(
                                    Long.valueOf(activeCasesElement.html()));
                        }
                    }
                    if (itr.hasNext()) {
                        final Element resolvedCasedElement = itr.next();
                        if (resolvedCasedElement.hasText()) {
                            stat.setResolvedCasesCount(
                                    Long.valueOf(resolvedCasedElement.html()));
                        }
                    }
                    if (itr.hasNext()) {
                        final Element deathsElement = itr.next();
                        if (deathsElement.hasText()) {
                            stat.setDeathCasesCount(
                                    Long.valueOf(deathsElement.html()));
                        }
                    }
                    if (itr.hasNext()) {
                        final Element totalElement = itr.next();
                        if (totalElement.hasText()) {
                            stat.setTotalCasesCount(
                                    Long.valueOf(totalElement.html()));
                        }
                    }
                    statsList.add(stat);
                }
            }
        }
        return statsList;
    }

    /**
     * tells wheter the row contains valid data to be scraped or not
     * @param dataItem
     * @return
     */
    private boolean isRowNotRequired(final Element dataItem) {
        return dataItem.hasClass("text-align:center;")
        || !dataItem.hasText()
        || dataItem.html().startsWith("<strong>")
        || dataItem.html().startsWith("Cases being reassigned "
                + "to states");
    }
}
