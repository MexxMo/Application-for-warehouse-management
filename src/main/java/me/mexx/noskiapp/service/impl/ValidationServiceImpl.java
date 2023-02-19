package me.mexx.noskiapp.service.impl;

import me.mexx.noskiapp.model.Socks;
import me.mexx.noskiapp.service.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean validate(Socks socks) {
        return socks.getSize()!=null&&
                socks.getColor()!=null&&
                socks.getQuantity()<1;
    }
}
