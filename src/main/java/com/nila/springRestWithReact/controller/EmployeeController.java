package com.nila.springRestWithReact.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nila.springRestWithReact.model.Employee;
import com.nila.springRestWithReact.model.Geolocation;
import com.nila.springRestWithReact.model.GoogleApiProperties;
import com.nila.springRestWithReact.model.Location;

@Controller
public class EmployeeController {

	@Autowired
	private Location location;
	@Autowired
	private GoogleApiProperties googleApiProperties;
	
	
	@RequestMapping(value = "/")
	public String index() {
		return "test";
	}
	
	@RequestMapping(value="/location/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Location getEmployeeLocation(@PathVariable("id") Long id) {
		RestTemplate restTemplate = new RestTemplate();
		
		URI uri;
		try {
			uri = new URI("http://localhost:8080/api/employees/"+id);
			Employee employeeResponse = restTemplate.getForObject(uri,Employee.class);
			// to get location from google api
			
			ResponseEntity<String> response = restTemplate.getForEntity(getResourceUrl(googleApiProperties, employeeResponse.getAddress()),
					String.class);
			location.setAddress(employeeResponse.getAddress());
			JacksonJsonParser jacksonJsonParser = new JacksonJsonParser();
			Map<String, Object> map= jacksonJsonParser.parseMap(response.getBody());
			LinkedHashMap locationMap = (LinkedHashMap)((LinkedHashMap)((LinkedHashMap)((ArrayList)(map.get("results"))).get(0)).get("geometry")).get("location");
			location.setLatitude(locationMap.get("lat").toString()  ); 
			location.setLongitude(locationMap.get("lng").toString()  );
			location.setResponse(map.get("results").toString());
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
		}
		
		return location;
	}
	
	
	/*
	 * https://maps.googleapis.com/maps/api/geocode/json?
	 * address=1600+Amphitheatre+Parkway,+Mountain+View,+CA &
	 * key=AIzaSyCF8-Kzw6JZS_Wppm9g-Fxy64PUMa6hGjg
	 * 
	 */
	public static String getResourceUrl(GoogleApiProperties apiProperties, String address) {
		String googleApiResourceUrl = apiProperties.getGeolocationApiUrl()
				+ apiProperties.getGeolocationAddressParamKey() + "=" + address + "&"
				+ apiProperties.getGeolocationKeyParamKey() + "=" + apiProperties.getGeolocationKeyParamValue();
		return googleApiResourceUrl;
	}

}
