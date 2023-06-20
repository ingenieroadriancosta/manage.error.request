package com.adrian.costa.errors.manage.manage.error.request.responses;

import java.util.HashMap;
import java.util.Map;

public class ServerResponse {
    Map<String, Object> response = new HashMap<>();
    Object error;
    Object body;
    String bodyName;

    public void setError(Object error) {
        this.error = error;
    }

    public void setBody(String bodyName, Object body) {
        this.bodyName = bodyName;
        this.body = body;
    }

    public Map<String, Object> getResponse() {
        if (error != null) {
            response.put("error", error);
        }
        if (bodyName != null) {
            response.put(bodyName, body);
        }
        return response;
    }

    public ServerResponse(Object error){
        this.error = error;
    }
    
    public ServerResponse(String bodyName, Object body){
        this.setBody(bodyName,body);
    }
}
