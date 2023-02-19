package me.mexx.noskiapp.service;


import me.mexx.noskiapp.model.Color;
import me.mexx.noskiapp.model.Size;
import me.mexx.noskiapp.model.Socks;

import java.util.List;

public interface SocksService {
    List<Socks> getAllSocks();

    Socks addSocks(Socks socks);

    int getSocks(Color color, Size size, int cottonMin, int cottonMax);

    boolean updateSocks(Socks socks);

    boolean removeSocks(Socks socks);


}
