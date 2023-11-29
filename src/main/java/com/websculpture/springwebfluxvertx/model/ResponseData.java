package com.websculpture.springwebfluxvertx.model;

import io.vertx.core.json.JsonObject;
import lombok.Data;

/**
 * @Author: Idris Ishaq
 * @Date: 02 Nov, 2023
 */

@Data
public class ResponseData {
    private String message;
    private Integer statusCode;
    private Boolean isDataError;
    private Boolean success;
    private String status;
    private JsonObject data;

    public static ResponseData of() {
        ResponseData responseData = new ResponseData();
        responseData.setMessage("Login Successful");
        responseData.setStatusCode(200);
        responseData.setIsDataError(false);
        responseData.setSuccess(true);
        responseData.setStatus("Successful");
        responseData.setData(new JsonObject().put("message", "Login Successful"));
        return responseData;
    }

}
