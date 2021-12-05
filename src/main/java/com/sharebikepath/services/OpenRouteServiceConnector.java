package com.sharebikepath.services;

import com.sharebikepath.entities.Point;
import com.sharebikepath.services.models.Coordinate;
import com.sharebikepath.services.models.Coordinates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


@Component
@PropertySource("classpath:apikeys.properties")
public class OpenRouteServiceConnector {

    @Value("${openrouteservice.key}")
    private String key;

    private String URL = "https://api.openrouteservice.org/v2/directions/";
    private String pathProfile = "cycling-regular";
    private String responseType = "geojson";

    public ResponseEntity getRoute(List<Point> pointList){
        String coordinates = convertToCoordinates(pointList)
                .toJSONString();

        ResponseEntity routeRequest = makeRequest(coordinates);

        return routeRequest;
    }

    private Coordinates convertToCoordinates(List<Point> pointList){
        Coordinates coordinates = new Coordinates();
        List<Coordinate> coordinatesList = pointList
                .stream()
                .map(point -> { return new Coordinate(point.getLongitude(),point.getLongitude());})
                .collect(Collectors.toList());

        coordinates.setCoordinates(coordinatesList);
        return coordinates;
    }
    private ResponseEntity makeRequest(String jsonCoordinates){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION,key);
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add(HttpHeaders.ACCEPT, "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8");

        HttpEntity httpEntity = new HttpEntity(jsonCoordinates, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        String requestUrl = makeUrl();
        ResponseEntity<Object> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.POST, httpEntity, Object.class);

        return responseEntity;
    }

    private String makeUrl(){
        return URL + pathProfile + "/" + responseType;
    }

}
