package com.amphibian.weather.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="forecast")
public class Forecast {

	@XmlTransient private String date;

	@XmlTransient private List<ForecastDay> days;
	
	public Forecast() {
		days = new ArrayList<ForecastDay>();
	}
	
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * The forecast days to be set
	 * @param days
	 */
	public void setDays(List<ForecastDay> days) {
		this.days = days;
	}

	/**
	 * This is used when the response is XML format. For whatever reason,
	 * wunderground.com gives the XML forecastday tags wrapped with a forecastdays
	 * object but the JSON version is just an array of forecastday objects.
	 *  
	 * @return
	 */
	@XmlElementWrapper(name="forecastdays")
	@XmlElement(name="forecastday")
	public List<ForecastDay> getDays() {
		return this.days;
	}
	
	/**
	 * This is used when the response is JSON format. For whatever reason,
	 * wunderground.com gives the XML forecastday tags wrapped with a forecastdays
	 * object but the JSON version is just an array of forecastday objects.
	 *  
	 * @return
	 */
	@XmlElement(name="forecastday")
	public List<ForecastDay> getDays2() {
		return this.days;
	}
	
	
	
}
