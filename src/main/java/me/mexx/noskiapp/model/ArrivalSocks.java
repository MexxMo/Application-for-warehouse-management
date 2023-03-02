package me.mexx.noskiapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArrivalSocks {
    private Socks socks;

    @Min(value = 1)
    private int quantity;
}
