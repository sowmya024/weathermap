package com.weather.server.weatherserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

	@Autowired
	private ApiService apiService;

	@RequestMapping(value = "/weather", produces = "application/json")
	public String weather(@RequestParam("location") String location) {
		return apiService.getWeather(location);
	}

	@RequestMapping(value = "/forecast", produces = "application/json")
	public String forecast(@RequestParam("location") String location) {
		return apiService.getForecast(location);
	}
}
