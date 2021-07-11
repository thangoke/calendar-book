package com.thangnv.booking.service.impl;

import com.thangnv.booking.controller.exception.DataNotFoundException;
import com.thangnv.booking.controller.exception.MissingQueryParamException;
import com.thangnv.booking.dto.AccessoryDTO;
import com.thangnv.booking.entity.Accessory;
import com.thangnv.booking.entity.AccessoryType;
import com.thangnv.booking.repository.AccessoryRepository;
import com.thangnv.booking.repository.AccessoryTypeRepository;
import com.thangnv.booking.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccessoryServiceImpl implements AccessoryService {

    @Autowired
    AccessoryRepository accessoryRepository;

    @Autowired
    AccessoryTypeRepository accessoryTypeRepository;

    private AccessoryDTO accessory2DTO(Accessory accessory) {
        AccessoryDTO dto = new AccessoryDTO();
        dto.id = accessory.getId();
        dto.code = accessory.getCode();
        dto.name = accessory.getName();

        return dto;
    }

    @Override
    public List<AccessoryDTO> listAllAccessory() {
        List<Accessory> accessoryList = accessoryRepository.findAll();

        List<AccessoryDTO> result = new ArrayList<>();

        for (Accessory accessory : accessoryList) {
            result.add(this.accessory2DTO(accessory));
        }

        return result;
    }

    @Override
    public AccessoryDTO getAccessoryById(Long id) {
        Optional<Accessory> optionalAccessory = accessoryRepository.findById(id);
        return optionalAccessory.map(this::accessory2DTO).orElse(null);
    }

    @Override
    public AccessoryDTO addAccessory(AccessoryDTO dto) {
        Objects.requireNonNull(dto);

        if (dto.accessoryTypeId == null) {
            throw new MissingQueryParamException("Missing dto.accessory_type_id");
        }

        Optional<AccessoryType> optionalAccessoryType = accessoryTypeRepository.findById(dto.accessoryTypeId);

        if (!optionalAccessoryType.isPresent()) {
            throw new DataNotFoundException(String.format("Accessory type not found, id = [%s]", dto.accessoryTypeId));
        }

        Accessory accessory = new Accessory();
        accessory.setCode(dto.code);
        accessory.setName(dto.name);
        accessory.setAccessoryType(optionalAccessoryType.get());

        Accessory persisted = accessoryRepository.save(accessory);
        return this.accessory2DTO(persisted);
    }

    @Override
    public AccessoryDTO modifyAccessory(AccessoryDTO dto) {
        Objects.requireNonNull(dto);

        if (dto.id == null) {
            throw new MissingQueryParamException("Missing dto.id");
        }

        Optional<Accessory> optionalAccessory = accessoryRepository.findById(dto.id);

        if (!optionalAccessory.isPresent()) {
            throw new DataNotFoundException(String.format("Accessory not found, id = [%s]", dto.id));
        }

        Accessory accessory = optionalAccessory.get();
        accessory.setCode(dto.code);
        accessory.setName(dto.name);

        if (dto.accessoryTypeId != null) {
            Optional<AccessoryType> optionalAccessoryType = accessoryTypeRepository.findById(dto.accessoryTypeId);

            if (!optionalAccessoryType.isPresent()) {
                throw new DataNotFoundException(String.format("Accessory type not found, id = [%s]", dto.accessoryTypeId));
            }

            accessory.setAccessoryType(optionalAccessoryType.get());
        }

        Accessory persisted = accessoryRepository.save(accessory);
        return this.accessory2DTO(persisted);
    }

    @Override
    public void deleteAccessory(Long id) {
        if (id == null) {
            throw new MissingQueryParamException("Missing id");
        }

        Optional<Accessory> optionalAccessory = accessoryRepository.findById(id);

        if (!optionalAccessory.isPresent()) {
            throw new DataNotFoundException(String.format("Accessory not found, id = [%s]", id));
        }

        accessoryRepository.delete(optionalAccessory.get());
    }
}
