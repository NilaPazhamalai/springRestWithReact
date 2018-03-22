package com.nila.springRestWithReact.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Location {

	
	private String address;
	private String latitude;
	private String longitude;
	private String response;
	
	public Location() {
		// TODO Auto-generated constructor stub
	}

}
