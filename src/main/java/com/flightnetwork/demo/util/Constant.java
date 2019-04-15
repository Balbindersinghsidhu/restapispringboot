/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flightnetwork.demo.util;

/**
 *@Class Name: Constant.java
 * @brief: This class is implementation for Date Format.
 * @author Balbinder Singh
 */
public class Constant {
    
    // API FOMAT DATE
   // public static final String API_FORMAT_DATE = "yyyy/MM/dd HH:mm:ss";
    
    public enum ParamError {

        
        APP_NAME("appName", "Invalid app name"),        
        REDIRECT_URL("redirectUrl", "Invalid redirect URL");
        

        private final String name;
        private final String desc;

        private ParamError(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }

        public String getName() {
            return name;
        }

        public String getDesc() {
            return desc;
        }
    }
    
}
