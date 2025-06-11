package com.warehouse.warehouse.controllers;

import com.warehouse.warehouse.Service.ItemPhotoService;
import com.warehouse.warehouse.dto.PhotoCreateDto;
import com.warehouse.warehouse.entity.ItemPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/photo")
public class ItemPhotoController {
    @Autowired
    ItemPhotoService itemPhotoService;

    @PostMapping("/upload/{itemID}")
    public ResponseEntity<String> uploadPhoto(@PathVariable Integer itemId, @RequestParam("file") MultipartFile file) throws IOException {
        ItemPhoto photo = itemPhotoService.create(new ItemPhoto(file.getName(), file.getContentType(), file.getBytes()),itemId);
        URI location = URI.create("/photo/"+photo.getId());
        return ResponseEntity.created(location).body("Photo uploaded successfully! ID:"+photo.getId());

    }
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> get(@PathVariable Integer id){
        ItemPhoto photo =  itemPhotoService.findById(id);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(photo.getType())).body(photo.getData());
    }
}
