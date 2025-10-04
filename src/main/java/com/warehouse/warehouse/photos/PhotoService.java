package com.warehouse.warehouse.photos;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService<T extends Photo> {

    T create(MultipartFile multipartFile,Integer parentId) throws IOException;
    void delete(Integer parentId);
    T findById(Integer id);

}
