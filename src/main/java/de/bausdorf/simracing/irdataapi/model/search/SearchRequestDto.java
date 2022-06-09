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

public abstract class SearchRequestDto {
    private final SearchParameter<Long> lowerBound;
    private final SearchParameter<Long> upperBound;
    private final SearchParameter<String> search;
    private final SearchParameter<OrderType> order;

    protected SearchRequestDto() {
        this.upperBound = new SearchParameter<>("upperbound");
        this.lowerBound = new SearchParameter<>("lowerbound");
        this.search = new SearchParameter<>("search");
        this.order = new SearchParameter<>("order");
    }

    public SearchRequestDto withLowerBound(Long lowerBound) {
        this.lowerBound.setParameterValue(lowerBound);
        return this;
    }

    public SearchRequestDto withUpperBound(Long upperBound) {
        this.upperBound.setParameterValue(upperBound);
        return this;
    }

    public SearchRequestDto withSearch(String search) {
        this.search.setParameterValue(search);
        return this;
    }

    public SearchRequestDto withOrder(OrderType orderType) {
        this.order.setParameterValue(orderType);
        return this;
    }

    public String toQueryString() {
        return toParameterString().replaceFirst("&", "?");
    }

    protected String toParameterString() {
        return lowerBound.toUrlParameter()
                + upperBound.toUrlParameter()
                + search.toUrlParameter()
                +order.toUrlParameter();
    }
}
