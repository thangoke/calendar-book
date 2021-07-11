package com.thangnv.booking.controller;

import com.thangnv.booking.controller.exception.DataNotFoundException;
import com.thangnv.booking.dto.AccessoryTypeDTO;
import com.thangnv.booking.service.AccessoryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accessory-type")
public class AccessoryTypeController {

    @Autowired
    AccessoryTypeService accessoryTypeService;

    @GetMapping("/list-all")
    List<AccessoryTypeDTO> listAllAccessoryType() {
        return accessoryTypeService.listAllAccessoryType();
    }

    @GetMapping("/get/{id}")
    AccessoryTypeDTO getById(@RequestParam Long id) {
        AccessoryTypeDTO result = accessoryTypeService.getAccessoryTypeById(id);
        if (result == null) {
            throw new DataNotFoundException(String.format("Accessory type not found, id = [%s]", id));
        }

        return result;
    }

    @PostMapping("/add")
    AccessoryTypeDTO addAccessoryType(@RequestBody AccessoryTypeDTO dto) {
        return accessoryTypeService.addAccessoryType(dto);
    }

    @PutMapping("/modify")
    AccessoryTypeDTO modifyAccessoryType(@RequestBody AccessoryTypeDTO dto) {
        return accessoryTypeService.modifyAccessoryType(dto);
    }

    @DeleteMapping("/delete")
    void deleteAccessoryType(@RequestParam Long id) {
        accessoryTypeService.deleteAccessoryType(id);
    }
}
