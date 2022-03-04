package com.automation.rest;

import static io.restassured.RestAssured.given;


import com.automation.common.Status;
import com.automation.config.RunConfig;
import io.restassured.response.ValidatableResponse;
import org.json.JSONObject;

public class PetRest extends BaseRest {

    public JSONObject bodyPet(Object id, String petName, String[] photoUrlParam) {

        JSONObject jsonObj = new JSONObject()
            .put("id", id)
            .put("name", petName)
            .put("photoUrls", photoUrlParam)
            .put("status", Status.available);
        return jsonObj;
    }

    public JSONObject postPet(JSONObject requestBodyJO) {

        String responseStr=null;
        try {
            String servicePath = RunConfig.getInstance().getHost() + "pet";
            System.out.println(servicePath);

            ValidatableResponse validatableResponse = given().contentType("application/json")
                .body(requestBodyJO.toString())
                .post(servicePath).then();

            responseStr = validatableResponse.extract().response().body().asString();

        } catch (Exception ex) {
            System.out.println("Exception in postPet ex.getMessage() " + ex.getMessage());
        }
        return getResponseJO(responseStr);
    }

    public String getPet(int id) {

        String responseStr=null;
        try {
            String servicePath = RunConfig.getInstance().getHost() + "pet/"+id;
            System.out.println(servicePath);

            ValidatableResponse validatableResponse = given().contentType("application/json")
                .get(servicePath).then();

            responseStr = validatableResponse.extract().response().body().asString();
            System.out.println(responseStr);

        } catch (Exception ex) {
            System.out.println("Exception in getPet ex.getMessage() " + ex.getMessage());
        }
        //return getResponseJO(responseStr);
        return responseStr;
    }

    public JSONObject putPet(JSONObject requestBodyJO) {

        String responseStr=null;
        try {
            String servicePath = RunConfig.getInstance().getHost() + "pet";

            ValidatableResponse validatableResponse = given().contentType("application/json")
                .body(requestBodyJO.toString())
                .put(servicePath).then();

            responseStr = validatableResponse.extract().response().body().asString();
            System.out.println(responseStr);

        } catch (Exception ex) {
            System.out.println("Exception in putPet ex.getMessage() " + ex.getMessage());
        }
        return getResponseJO(responseStr);
    }


    public JSONObject deletePet(int id) {

        String responseStr=null;
        try {
            String servicePath = RunConfig.getInstance().getHost() + "pet/"+id;

            ValidatableResponse validatableResponse = given().contentType("application/json")
                .delete(servicePath).then();

            responseStr = validatableResponse.extract().response().body().asString();

        } catch (Exception ex) {
            System.out.println("Exception in deletePet ex.getMessage() " + ex.getMessage());
        }
        return getResponseJO(responseStr);
    }


    public int retrievePetId(JSONObject resultJO) {
        return resultJO.getInt("id");
    }

    public String retrievePetName(JSONObject resultJO) {
        return resultJO.getString("name");
    }

    public int retrieveCode(JSONObject resultJO) {
        return resultJO.getInt("code");
    }
}
