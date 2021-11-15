package com.weather.server.weatherserver;

import java.net.URLEncoder;

import javax.annotation.PostConstruct;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ApiService {

	@Autowired
	private Environment env;

	private String apiKey;

	@PostConstruct
	public void init() {
		apiKey = env.getProperty("api.key");
	}

	public String getWeather(String location) {
		location = URLEncoder.encode(location);
		System.out.println(location);
		if (apiKey.equalsIgnoreCase("demo")) {
			return "{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":10.35,\"feels_like\":9.84,\"temp_min\":9.27,\"temp_max\":11.13,\"pressure\":1023,\"humidity\":92},\"visibility\":10000,\"wind\":{\"speed\":2.57,\"deg\":350},\"clouds\":{\"all\":90},\"dt\":1636874621,\"sys\":{\"type\":2,\"id\":2019646,\"country\":\"GB\",\"sunrise\":1636874224,\"sunset\":1636906382},\"timezone\":0,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
		} else {
			return this.get("weather?q=" + location + "&units=metric");
		}
	}

	public String getForecast(String location) {
		location = URLEncoder.encode(location);
		if (apiKey.equalsIgnoreCase("demo")) {
			return "{\"cod\":\"200\",\"message\":0,\"cnt\":10,\"list\":[{\"dt\":1636891200,\"main\":{\"temp\":11.52,\"feels_like\":11.03,\"temp_min\":11.52,\"temp_max\":12.07,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":1020,\"humidity\":88,\"temp_kf\":-0.55},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":83},\"wind\":{\"speed\":3.49,\"deg\":15,\"gust\":7.75},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-11-14 12:00:00\"},{\"dt\":1636902000,\"main\":{\"temp\":12.47,\"feels_like\":11.78,\"temp_min\":12.47,\"temp_max\":13.08,\"pressure\":1024,\"sea_level\":1024,\"grnd_level\":1021,\"humidity\":77,\"temp_kf\":-0.61},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":3.27,\"deg\":44,\"gust\":5.93},\"visibility\":10000,\"pop\":0.08,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-11-14 15:00:00\"},{\"dt\":1636912800,\"main\":{\"temp\":12.07,\"feels_like\":11.32,\"temp_min\":12.07,\"temp_max\":12.07,\"pressure\":1025,\"sea_level\":1025,\"grnd_level\":1022,\"humidity\":76,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":2.27,\"deg\":68,\"gust\":6.12},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-11-14 18:00:00\"},{\"dt\":1636923600,\"main\":{\"temp\":10.32,\"feels_like\":9.76,\"temp_min\":10.32,\"temp_max\":10.32,\"pressure\":1026,\"sea_level\":1026,\"grnd_level\":1023,\"humidity\":90,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":54},\"wind\":{\"speed\":1.79,\"deg\":69,\"gust\":5.37},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-11-14 21:00:00\"},{\"dt\":1636934400,\"main\":{\"temp\":9.34,\"feels_like\":9.06,\"temp_min\":9.34,\"temp_max\":9.34,\"pressure\":1027,\"sea_level\":1027,\"grnd_level\":1023,\"humidity\":91,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"clouds\":{\"all\":31},\"wind\":{\"speed\":1.35,\"deg\":57,\"gust\":1.97},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-11-15 00:00:00\"},{\"dt\":1636945200,\"main\":{\"temp\":9.09,\"feels_like\":9.09,\"temp_min\":9.09,\"temp_max\":9.09,\"pressure\":1026,\"sea_level\":1026,\"grnd_level\":1023,\"humidity\":87,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":5},\"wind\":{\"speed\":1.12,\"deg\":27,\"gust\":1.15},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-11-15 03:00:00\"},{\"dt\":1636956000,\"main\":{\"temp\":8.53,\"feels_like\":8.53,\"temp_min\":8.53,\"temp_max\":8.53,\"pressure\":1026,\"sea_level\":1026,\"grnd_level\":1023,\"humidity\":88,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":4},\"wind\":{\"speed\":1.13,\"deg\":14,\"gust\":1.15},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-11-15 06:00:00\"},{\"dt\":1636966800,\"main\":{\"temp\":9.25,\"feels_like\":9.25,\"temp_min\":9.25,\"temp_max\":9.25,\"pressure\":1027,\"sea_level\":1027,\"grnd_level\":1024,\"humidity\":83,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":0.77,\"deg\":32,\"gust\":1.21},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-11-15 09:00:00\"},{\"dt\":1636977600,\"main\":{\"temp\":11.84,\"feels_like\":10.86,\"temp_min\":11.84,\"temp_max\":11.84,\"pressure\":1026,\"sea_level\":1026,\"grnd_level\":1023,\"humidity\":68,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":0.66,\"deg\":24,\"gust\":1.02},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-11-15 12:00:00\"},{\"dt\":1636988400,\"main\":{\"temp\":11.87,\"feels_like\":10.89,\"temp_min\":11.87,\"temp_max\":11.87,\"pressure\":1026,\"sea_level\":1026,\"grnd_level\":1023,\"humidity\":68,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":87},\"wind\":{\"speed\":1.31,\"deg\":353,\"gust\":2.36},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-11-15 15:00:00\"}],\"city\":{\"id\":2643743,\"name\":\"London\",\"coord\":{\"lat\":51.5085,\"lon\":-0.1257},\"country\":\"GB\",\"population\":1000000,\"timezone\":0,\"sunrise\":1636874224,\"sunset\":1636906382}}";
		} else {
			return this.get("forecast?q=" + location + "&units=metric");
		}
	}

	public String get(String url) {
		url = env.getProperty("api.baseUrl") + "/" + url + "&appid=" + apiKey;
		System.out.println("URL: " + url);
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

			HttpGet httpget = new HttpGet(url);

			try (CloseableHttpResponse response = httpclient.execute(httpget)) {
				HttpEntity entity = response.getEntity();
				String content = EntityUtils.toString(entity);
				System.out.println(content);
				EntityUtils.consumeQuietly(entity);
				return content;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "{}";
	}
}
