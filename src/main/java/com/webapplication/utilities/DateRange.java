package com.webapplication.utilities;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.RangeQueryBuilder;

import java.util.Date;

/**
 * Utility class to hold date range specifications and turn them into elastic search queries.
 */
public final class DateRange {

    /** The field name */
    private String field = null;

    /** The start date */
    private Date startDate = null;

    /** The end date */
    private Date endDate = null;

    /**
     * Creates a new date range specification with the given field name, start and end dates. <code>null</code> may be
     * passed in for start or end dates that should remain unspecified.
     *
     * @param field
     *          the field name
     * @param start
     *          the start date
     * @param end
     *          the end date
     */
    public DateRange(String field, Date start, Date end) {
        this.field = field;
        this.startDate = start;
        this.endDate = end;
    }

    /**
     * Returns the range query that is represented by this date range.
     *
     * @return the range query builder
     */
    QueryBuilder getQueryBuilder() {
        RangeQueryBuilder rqb = new RangeQueryBuilder(field);
        if (startDate != null)
            rqb.from(startDate.getTime());
        if (endDate != null)
            rqb.to(endDate.getTime());
        return rqb;
    }

    /**
     * {@inheritDoc}
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DateRange) {
            return ((DateRange) obj).field.equals(field);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return field.hashCode();
    }

}