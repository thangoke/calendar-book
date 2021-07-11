package com.thangnv.booking.service;

import com.thangnv.booking.dto.AccessoryTypeDTO;

import java.util.List;

public interface AccessoryTypeService {
    List<AccessoryTypeDTO> listAllAccessoryType();

    AccessoryTypeDTO getAccessoryTypeById(Long id);

    AccessoryTypeDTO addAccessoryType(AccessoryTypeDTO dto);

    AccessoryTypeDTO modifyAccessoryType(AccessoryTypeDTO dto);

    void deleteAccessoryType(Long id);
}
