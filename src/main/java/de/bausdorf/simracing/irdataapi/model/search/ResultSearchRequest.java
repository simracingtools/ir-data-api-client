package de.bausdorf.simracing.irdataapi.model.search;

/*-
 * #%L
 * de.bausdorf.simracing:ir-data-api-client
 * %%
 * Copyright (C) 2022 bausdorf engineering
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import de.bausdorf.simracing.irdataapi.client.CategoryType;

import java.time.ZonedDateTime;
import java.util.List;

public class ResultSearchRequest extends SearchRequest {
    // ISO-8601 UTC time zero offset: \"2022-04-01T15:45Z\".
    private final ZonedDateTimeSearchParameter startRangeBegin;
    // ISO-8601 UTC time zero offset: \"2022-04-01T15:45Z\". Exclusive. May be omitted if start_range_begin is less than 90 days in the past.
    private final ZonedDateTimeSearchParameter startRangeEnd;
    // Session finish times. ISO-8601 UTC time zero offset: "2022-04-01T15:45Z".
    private final ZonedDateTimeSearchParameter finishRangeBegin;
    // ISO-8601 UTC time zero offset: "2022-04-01T15:45Z". Exclusive. May be omitted if finish_range_begin is less than 90 days in the past.
    private final ZonedDateTimeSearchParameter finishRangeEnd;
    private final SearchParameter<Long> custId;
    // Track categories to include in the search.  Defaults to all. ?category_ids=1,2,3,4
    private final CategoryListSearchParameter categories;

    protected ResultSearchRequest() {
        this.startRangeBegin = new ZonedDateTimeSearchParameter("start_range_begin");
        this.startRangeEnd = new ZonedDateTimeSearchParameter("start_range_end");
        this.finishRangeBegin = new ZonedDateTimeSearchParameter("finish_range_begin");
        this.finishRangeEnd = new ZonedDateTimeSearchParameter("finish_range_end");
        this.custId = new SearchParameter<>("cust_id");
        this.categories = new CategoryListSearchParameter("category_ids");
    }

    public ResultSearchRequest withStartRangeBegin(ZonedDateTime begin) {
        this.startRangeBegin.setParameterValue(begin);
        return this;
    }

    public ResultSearchRequest withStartRangeEnd(ZonedDateTime end) {
        this.startRangeEnd.setParameterValue(end);
        return this;
    }

    public ResultSearchRequest withFinishRangeBegin(ZonedDateTime begin) {
        this.finishRangeBegin.setParameterValue(begin);
        return this;
    }

    public ResultSearchRequest withFinishRangeEnd(ZonedDateTime end) {
        this.finishRangeEnd.setParameterValue(end);
        return this;
    }

    public ResultSearchRequest withCustId(Long id) {
        this.custId.setParameterValue(id);
        return this;
    }

    public ResultSearchRequest withCategories(List<CategoryType> categories) {
        this.categories.setParameterValue(categories);
        return this;
    }

    @Override
    protected String toParameterString() {
        return this.startRangeBegin.toUrlParameter()
                + this.startRangeEnd.toUrlParameter()
                + this.finishRangeBegin.toUrlParameter()
                + this.finishRangeEnd.toUrlParameter()
                + this.custId.toUrlParameter()
                + this.categories.toUrlParameter();
    }
}
