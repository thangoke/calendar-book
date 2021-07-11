package com.thangnv.booking.service.impl;

import com.thangnv.booking.dto.AccessoryTypeDTO;
import com.thangnv.booking.entity.AccessoryType;
import com.thangnv.booking.repository.AccessoryTypeRepository;
import com.thangnv.booking.service.AccessoryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryTypeServiceImpl implements AccessoryTypeService {

    @Autowired
    AccessoryTypeRepository accessoryTypeRepository;

    private AccessoryTypeDTO accessoryType2DTO(AccessoryType accessoryType) {
        AccessoryTypeDTO dto = new AccessoryTypeDTO();
        dto.id = accessoryType.getId();
        dto.code = accessoryType.getCode();
        dto.name = accessoryType.getName();

        return dto;
    }

    @Override
    public List<AccessoryTypeDTO> listAllAccessoryType() {
        return null;
    }

    @Override
    public AccessoryTypeDTO getAccessoryTypeById(Long id) {
        return null;
    }

    @Override
    public AccessoryTypeDTO addAccessoryType(AccessoryTypeDTO dto) {
        return null;
    }

    @Override
    public AccessoryTypeDTO modifyAccessoryType(AccessoryTypeDTO dto) {
        return null;
    }

    @Override
    public void deleteAccessoryType(Long id) {

    }
}
