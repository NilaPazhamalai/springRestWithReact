package com.nila.springRestWithReact.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="google")
@Component
public class GoogleApiProperties {

	private String geolocationApiUrl;
	private String geolocationAddressParamKey;
	private String geolocationKeyParamKey;
	private String geolocationKeyParamValue;
	
	public String getGeolocationApiUrl() {
		return geolocationApiUrl;
	}

	public String getGeolocationAddressParamKey() {
		return geolocationAddressParamKey;
	}

	public void setGeolocationAddressParamKey(String geolocationAddressParamKey) {
		this.geolocationAddressParamKey = geolocationAddressParamKey;
	}

	public String getGeolocationKeyParamKey() {
		return geolocationKeyParamKey;
	}

	public void setGeolocationKeyParamKey(String geolocationKeyParamKey) {
		this.geolocationKeyParamKey = geolocationKeyParamKey;
	}

	public String getGeolocationKeyParamValue() {
		return geolocationKeyParamValue;
	}

	public void setGeolocationKeyParamValue(String geolocationKeyParamValue) {
		this.geolocationKeyParamValue = geolocationKeyParamValue;
	}

	public void setGeolocationApiUrl(String geolocationApiUrl) {
		this.geolocationApiUrl = geolocationApiUrl;
	}
	
	
	
	
}
