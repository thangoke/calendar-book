package com.thangnv.booking.service.impl;

import com.thangnv.booking.controller.exception.DataNotFoundException;
import com.thangnv.booking.controller.exception.MissingQueryParamException;
import com.thangnv.booking.dto.AccessoryTypeDTO;
import com.thangnv.booking.entity.AccessoryType;
import com.thangnv.booking.repository.AccessoryTypeRepository;
import com.thangnv.booking.service.AccessoryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        List<AccessoryType> accessoryTypeList = accessoryTypeRepository.findAll();

        List<AccessoryTypeDTO> result = new ArrayList<>();

        for (AccessoryType accessoryType : accessoryTypeList) {
            result.add(this.accessoryType2DTO(accessoryType));
        }

        return result;
    }

    @Override
    public AccessoryTypeDTO getAccessoryTypeById(Long id) {
        Optional<AccessoryType> optionalAccessoryType = accessoryTypeRepository.findById(id);
        return optionalAccessoryType.map(this::accessoryType2DTO).orElse(null);
    }

    @Override
    public AccessoryTypeDTO addAccessoryType(AccessoryTypeDTO dto) {
        Objects.requireNonNull(dto);

        AccessoryType accessoryType = new AccessoryType();
        accessoryType.setCode(dto.code);
        accessoryType.setName(dto.name);

        AccessoryType persisted = accessoryTypeRepository.save(accessoryType);
        return this.accessoryType2DTO(persisted);
    }

    @Override
    public AccessoryTypeDTO modifyAccessoryType(AccessoryTypeDTO dto) {
        Objects.requireNonNull(dto);

        if (dto.id == null) {
            throw new MissingQueryParamException("Missing dto.id");
        }

        Optional<AccessoryType> optionalAccessoryType = accessoryTypeRepository.findById(dto.id);

        if (!optionalAccessoryType.isPresent()) {
            throw new DataNotFoundException(String.format("Accessory type not found, id = [%s]", dto.id));
        }

        AccessoryType accessoryType = optionalAccessoryType.get();
        accessoryType.setCode(dto.code);
        accessoryType.setName(dto.name);

        AccessoryType persisted = accessoryTypeRepository.save(accessoryType);
        return this.accessoryType2DTO(persisted);
    }

    @Override
    public void deleteAccessoryType(Long id) {
        if (id == null) {
            throw new MissingQueryParamException("Missing id");
        }

        Optional<AccessoryType> optionalAccessoryType = accessoryTypeRepository.findById(id);

        if (!optionalAccessoryType.isPresent()) {
            throw new DataNotFoundException(String.format("Accessory type not found, id = [%s]", id));
        }

        accessoryTypeRepository.delete(optionalAccessoryType.get());
    }
}
