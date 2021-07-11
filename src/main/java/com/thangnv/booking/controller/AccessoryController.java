package com.thangnv.booking.controller;

import com.thangnv.booking.controller.exception.DataNotFoundException;
import com.thangnv.booking.dto.AccessoryDTO;
import com.thangnv.booking.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/accessory")
public class AccessoryController {

    @Autowired
    AccessoryService accessoryService;

    @GetMapping("/list-all")
    List<AccessoryDTO> listAllAccessory() {
        return accessoryService.listAllAccessory();
    }

    @GetMapping("/get/{id}")
    AccessoryDTO getById(@RequestParam Long id) {
        AccessoryDTO result = accessoryService.getAccessoryById(id);
        if (result == null) {
            throw new DataNotFoundException(String.format("Accessory not found, id = [%s]", id));
        }

        return result;
    }

    @PostMapping("/add")
    AccessoryDTO addAccessory(@RequestBody AccessoryDTO dto) {
        return accessoryService.addAccessory(dto);
    }

    @PutMapping("/modify")
    AccessoryDTO modifyAccessory(@RequestBody AccessoryDTO dto) {
        return accessoryService.modifyAccessory(dto);
    }

    @DeleteMapping("/delete")
    void deleteAccessory(@RequestParam Long id) {
        accessoryService.deleteAccessory(id);
    }
}
