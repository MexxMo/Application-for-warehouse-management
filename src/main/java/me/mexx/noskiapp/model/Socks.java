package me.mexx.noskiapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socks {
    private Size size;
    private Color color;
    @Min(value = 1, message = "Процент содержания хлопка не может быть < 1")
    @Max(value = 100, message = "Процент содержания хлопка не может быть > 100")
    private int cottonPart;
    @Min(value = 1, message = "Количество не может быть < 1")
    private int quantity;
}
