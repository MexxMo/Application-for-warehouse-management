package me.mexx.noskiapp.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import me.mexx.noskiapp.exception.ValidationException;
import me.mexx.noskiapp.model.ArrivalSocks;
import me.mexx.noskiapp.model.Color;
import me.mexx.noskiapp.model.Size;
import me.mexx.noskiapp.model.Socks;
import me.mexx.noskiapp.service.SocksService;
import me.mexx.noskiapp.service.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SocksServiceImpl implements SocksService {

    private final ObjectMapper objectMapper;
    private final FilesServiceImpl filesService;
    private final ValidationService validationService;

    private Map<Socks, Integer> socksMap = new HashMap<>();

    public void CheckValid(ArrivalSocks arrivalSocks) {
        if (!validationService.validate(arrivalSocks)) {
            throw new ValidationException();
        }
    }

    @Override
    public Map<Socks, Integer> getAllSocks() {

        return socksMap;
    }

    @Override
    public void acceptSocks(ArrivalSocks arrivalSocks) {
        Socks socks = arrivalSocks.getSocks();
        CheckValid(arrivalSocks);
        if (socksMap.containsKey(socks)) {
            socksMap.replace(socks, socksMap.get(socks) + arrivalSocks.getQuantity());

        } else {
            socksMap.put(socks, arrivalSocks.getQuantity());
        }
    }

    public int remove(ArrivalSocks arrivalSocks) {
        Socks socks = arrivalSocks.getSocks();
        if (socksMap.containsKey(socks)) {
            int quantity = socksMap.get(socks);
            if (quantity > arrivalSocks.getQuantity()) {
                socksMap.replace(socks, socksMap.get(socks) - arrivalSocks.getQuantity());
                return arrivalSocks.getQuantity();
            } else {
                socksMap.remove(socks);
                return quantity;
            }
        }
        return 0;
    }

    @Override
    public int getSocks(Color color, Size size, int cottonMin, int cottonMax) {
        if (!validationService.validate(color, size, cottonMin, cottonMax)) {
            throw new ValidationException();
        }

        for (Map.Entry<Socks, Integer> socksIntegerEntry : socksMap.entrySet()) {
            Socks socks = socksIntegerEntry.getKey();
            if (socks.getColor().equals(color) &&
                    socks.getSize().equals(size) &&
                    socks.getCottonPart() >= cottonMin &&
                    socks.getCottonPart() <= cottonMax) {
                return socksIntegerEntry.getValue();
            }
        }
        return 0;
    }

    @Override
    public int updateSocks(ArrivalSocks arrivalSocks) {
        CheckValid(arrivalSocks);
        return remove(arrivalSocks);
    }

    @Override
    public int deleteSocks(ArrivalSocks arrivalSocks) {
        CheckValid(arrivalSocks);
        return remove(arrivalSocks);
    }


    private void saveToFile() {
        try {
            String json = objectMapper.writeValueAsString(socksMap);
            filesService.saveSocksToFile(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {
        String json = filesService.readSocksFromFile();
        try {
            if (!json.isBlank()) {
                socksMap = objectMapper.readValue(json, new TypeReference<>() {});
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    private void init() {
        try {
            readFromFile();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
