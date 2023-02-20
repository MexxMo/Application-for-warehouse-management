package me.mexx.noskiapp.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface FilesService {
    File getSocksDataFile();

    boolean saveSocksToFile(String json);

    String readSocksFromFile();




}
