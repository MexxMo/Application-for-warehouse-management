package me.mexx.noskiapp.service.impl;

import me.mexx.noskiapp.service.FilesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FilesServiceImpl implements FilesService {
    @Value(value = "$data.files.path")
    private String dataFilesPath;
    @Value(value = "$socks.data.file.name")
    private String socksDataFileName;

    @Override
    public File getSocksDataFile() {
        return new File(dataFilesPath + "/" + socksDataFileName);
    }

    @Override
    public boolean saveSocksToFile(String json) {
        return saveToFile(json, socksDataFileName);
    }

    @Override
    public String readSocksFromFile() {
        return readFromFile(socksDataFileName);
    }

    public boolean cleanDataFile(String dataFileName) {
        Path path = Path.of(dataFilesPath, dataFileName);
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String readFromFile(String dataFileName) {
        try {
            return Files.readString(Path.of(dataFilesPath, dataFileName));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean saveToFile(String json, String dataFileName) {
        try {
            cleanDataFile(dataFileName);
            Files.writeString(Path.of(dataFilesPath, dataFileName), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
