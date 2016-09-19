package com.pjinc.resources;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class V1WordList {

	public final List<String> names;

	@JsonCreator
	public V1WordList(@JsonProperty("names") List<String> names) {
		this.names = names;
	}

	@Override
	public String toString() {
		return "V1WordList {" + names + "}";
	}
}
