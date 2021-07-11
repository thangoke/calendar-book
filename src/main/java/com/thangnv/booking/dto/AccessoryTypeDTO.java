package com.thangnv.booking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessoryTypeDTO {
    @JsonProperty("id")
    public Long id;

    @JsonProperty("code")
    public String code;

    @JsonProperty("name")
    public String name;
}
