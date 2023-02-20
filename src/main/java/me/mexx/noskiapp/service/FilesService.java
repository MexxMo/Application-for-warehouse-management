package me.mexx.noskiapp.service;



import java.io.File;


public interface FilesService {
    File getSocksDataFile();

    boolean saveSocksToFile(String json);

    String readSocksFromFile();




}
