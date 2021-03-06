package org.openmrs.utils.odoo.aggregator;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.stereotype.Component;

/**
 * Camel strategy to set the ODOO_ID to copy properties from newExchange
 * and put them into oldExchange
 */
@Component
public class ObsSequenceAggregationStrategy implements AggregationStrategy {

    @Override
    public Exchange aggregate(final Exchange oldExchange, final Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }

        newExchange.getProperties().forEach(oldExchange::setProperty);

        return oldExchange;
    }
}
