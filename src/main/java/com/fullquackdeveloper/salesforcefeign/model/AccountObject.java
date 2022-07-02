package com.fullquackdeveloper.salesforcefeign.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountObject {
    @JsonProperty("Id")
    String id;
    @JsonProperty("LastName")
    String lastName;
}
