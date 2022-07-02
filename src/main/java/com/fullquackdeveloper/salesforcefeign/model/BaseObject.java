package com.fullquackdeveloper.salesforcefeign.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class BaseObject {
    @JsonProperty("attributes")
    ObjectAttribute attributes;
}
