package me.mexx.noskiapp.service;



import me.mexx.noskiapp.model.ArrivalSocks;
import me.mexx.noskiapp.model.Color;
import me.mexx.noskiapp.model.Size;
import me.mexx.noskiapp.model.Socks;


import java.util.Map;

public interface SocksService {
    Map<Socks,Integer> getAllSocks();


    void acceptSocks(ArrivalSocks arrivalSocks);

    int getSocks(Color color, Size size, int cottonMin, int cottonMax);

    int updateSocks(ArrivalSocks arrivalSocks);

    int deleteSocks(ArrivalSocks arrivalSocks);
}
