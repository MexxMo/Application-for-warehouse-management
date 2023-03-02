package me.mexx.noskiapp.service.impl;

import me.mexx.noskiapp.model.ArrivalSocks;
import me.mexx.noskiapp.model.Color;
import me.mexx.noskiapp.model.Size;
import me.mexx.noskiapp.service.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean validate(ArrivalSocks arrivalSocks) {
        return arrivalSocks != null &&
                arrivalSocks.getQuantity() > 0 &&
                arrivalSocks.getSocks().getColor() != null &&
                arrivalSocks.getSocks().getSize() != null;

    }

    @Override
    public boolean validate(Color color, Size size, int cottonMin, int cottonMax) {
        return size != null &&
                color != null &&
                cottonMin >= 1 && cottonMax <= 100;
    }

}
