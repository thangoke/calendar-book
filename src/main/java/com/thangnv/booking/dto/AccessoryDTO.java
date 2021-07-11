package com.thangnv.booking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessoryDTO {
    @JsonProperty("id")
    public Long id;

    @JsonProperty("code")
    public String code;

    @JsonProperty("name")
    public String name;

    @JsonProperty("accessory_type_id")
    public Long accessoryTypeId;
}
