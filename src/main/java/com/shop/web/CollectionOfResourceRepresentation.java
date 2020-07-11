package com.shop.web;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CollectionOfResourceRepresentation<T> extends RepresentationModel<CollectionOfResourceRepresentation<T>>{
	
	private final Collection<ResourceRepresentation<T>> contents;

	@JsonCreator
	public CollectionOfResourceRepresentation(@JsonProperty("items") Collection<ResourceRepresentation<T>> content) {
		this.contents = content;
	}

	public Collection<ResourceRepresentation<T>> getContent() {
		return contents;
	}
	
	/**
	 * @return the resultsCount
	 */
	@JsonGetter("resultsCount")
	public Integer getResultsCount() {
		return CollectionUtils.size(contents);
	}

}
