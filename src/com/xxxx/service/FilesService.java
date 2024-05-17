package com.xxxx.service;

import com.xxxx.entity.Files;

import java.io.IOException;
import java.util.List;

public interface FilesService {
    List<Files> selectAll() throws IOException;
}
