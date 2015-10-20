package com.plivo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by santhosh.b on 20/10/15.
 */
public class CallRequest {

    @JsonProperty
    public String to;
    @JsonProperty
    public String from;
    @JsonProperty
    public String answer_url;


    public void setTo(String to)    {

        this.to = to;
    }

    public void setFrom(String from)    {

        this.from = from;
    }

    public void setAnswer_url(String answer_url)    {
        this.answer_url = answer_url;
    }
}
