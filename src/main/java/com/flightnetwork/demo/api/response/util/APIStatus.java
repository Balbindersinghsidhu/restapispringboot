/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flightnetwork.demo.api.response.util;

/**
 *
 * @author Balbinder Singh
 */
public enum APIStatus {
    
    ERR_INVALID_DATA(100, "Input data is not valid."),   
    INVALID_PARAMETER(200, "Invalid request parameter"),
    
    
    // Common status
    OK(200, null),
    ERR_INTERNAL_SERVER(500, "Internal Error"),    
    ERR_BAD_REQUEST(400, "Bad request"),        
    //User status
    ERR_USER_NOT_FOUND(404, "User Not Found"),
    ERR_USER_ADDRESS_NOT_FOUND(405, "User Address Not Found"),
    ERR_GET_LIST_USERS(406, "Get list user error");   
   

    private final int code;
    private final String description;

    private APIStatus(int s, String v) {
        code = s;
        description = v;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
    
}
