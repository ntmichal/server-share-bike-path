package com.sharebikepath.services.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;

public class Coordinates {

    private List<double[]> coordinates = new ArrayList<>();
    
    public List<double[]> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<double[]> coordinates) {
        this.coordinates = coordinates;
    }
    
    public void addPoint(double[] coordinate){
        coordinates.add(coordinate);
    }

    public String toJSONString(){
        try{
            ObjectMapper objectMapper = new ObjectMapper();

            ArrayNode coordinatesJSON = objectMapper.createArrayNode();

            for (int i = 0; i < coordinates.size(); i++) {
                coordinatesJSON.add(objectMapper
                        .createArrayNode()
                        .add(coordinates.get(i)[0])
                        .add(coordinates.get(i)[1]));
            }

            ObjectNode jsonNode = objectMapper.createObjectNode();
            jsonNode.putPOJO("coordinates",coordinatesJSON);
//            jsonNode.putPOJO("instructions","false");

            return objectMapper.writeValueAsString(jsonNode);
        }catch (JsonProcessingException exception){
            throw new RuntimeException(exception.getMessage());
        }

    }
}
