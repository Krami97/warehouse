package com.warehouse.warehouse.photos;


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

    @PostMapping("/upload/{itemId}")
    public ResponseEntity<String> uploadPhoto(@PathVariable Integer itemId, @RequestParam("file") MultipartFile file) throws IOException {
        Photo photo = itemPhotoService.create(new Photo(file.getName(), file.getContentType(), file.getBytes()),itemId);
        URI location = URI.create("/photo/"+photo.getId());
        return ResponseEntity.created(location).body("Photo uploaded successfully! ID:"+photo.getId());

    }
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> get(@PathVariable Integer id){
        Photo photo =  itemPhotoService.findById(id);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(photo.getType())).body(photo.getData());
    }
}
