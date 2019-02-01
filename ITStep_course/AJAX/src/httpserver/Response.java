/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpserver;

/**
 *
 * @author Student
 */
public class Response {
    private int responseCode;
    private String response;
    private String message;

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponse() {
        return response;
    }

    public String getMessage() {
        return message;
    }
    
    
    
}
