package me.mexx.noskiapp.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.mexx.noskiapp.exception.ValidationException;
import me.mexx.noskiapp.model.Color;
import me.mexx.noskiapp.model.Size;
import me.mexx.noskiapp.model.Socks;
import me.mexx.noskiapp.service.SocksService;
import me.mexx.noskiapp.service.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SocksServiceImpl implements SocksService {

    private List<Socks> socksMap = new ArrayList<>();
    private final ObjectMapper objectMapper;
    private final FilesService filesService;
    private final ValidationService validationService;

    @Override
    public List<Socks> getAllSocks() {
        return socksMap;
    }

    @Override
    public Socks addSocks(Socks socks) {
        return null;
    }

    @Override
    public int getSocks(Color color, Size size, int cottonMin, int cottonMax) {
        return 0;
    }

    @Override
    public boolean updateSocks(Socks socks) {
        return false;
    }

    @Override
    public boolean removeSocks(Socks socks) {
        if (!validationService.validate(socks)) {
            throw new ValidationException(socks.toString());
        }
        return socksMap.remove(socks);

    }

//    @PostConstruct
//    private void init() {
//        try {
//            readFromFile();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
