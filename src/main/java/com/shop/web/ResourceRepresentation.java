package com.shop.web;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResourceRepresentation<T> extends RepresentationModel<ResourceRepresentation<T>>{
	
	private final T content;

	@JsonCreator
	public ResourceRepresentation(@JsonProperty("item") T content) {
		this.content = content;
	}

	public T getContent() {
		return content;
	}

}
