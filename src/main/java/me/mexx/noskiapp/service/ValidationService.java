package me.mexx.noskiapp.service;

import me.mexx.noskiapp.model.Color;
import me.mexx.noskiapp.model.Size;
import me.mexx.noskiapp.model.Socks;

public interface ValidationService {
    boolean validate(Socks socks);

    boolean validate(Color color, Size size, int cottonMin, int cottonMax);
}
