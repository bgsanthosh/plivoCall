package com.plivo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by santhosh.b on 20/10/15.
 */

public class CallResponse {

    @JsonProperty
    public String api_id;
    @JsonProperty
    public String message;
    @JsonProperty
    public String request_uuid;



}
