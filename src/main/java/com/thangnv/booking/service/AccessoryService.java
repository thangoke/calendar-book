package com.thangnv.booking.service;

import com.thangnv.booking.dto.AccessoryDTO;

import java.util.List;

public interface AccessoryService {
    List<AccessoryDTO> listAllAccessory();

    AccessoryDTO getAccessoryById(Long id);

    AccessoryDTO addAccessory(AccessoryDTO dto);

    AccessoryDTO modifyAccessory(AccessoryDTO dto);

    void deleteAccessory(Long id);
}
