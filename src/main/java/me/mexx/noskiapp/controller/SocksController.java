package me.mexx.noskiapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.mexx.noskiapp.model.ArrivalSocks;
import me.mexx.noskiapp.model.Color;
import me.mexx.noskiapp.model.Size;
import me.mexx.noskiapp.model.Socks;
import me.mexx.noskiapp.service.SocksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/socks")
@Tag(name = "API для работы с носками")
@RequiredArgsConstructor
public class SocksController {

    private final SocksService socksService;

    @PostMapping
    @Operation(summary = "Приемка носков на склад")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Удалось добавить приход"),
            @ApiResponse(responseCode = "400", description = "Параметры запроса отсутствуют или имеют некорректный формат."),
            @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны.")
    })
    public ResponseEntity<String> acceptSocks(@Valid @RequestBody ArrivalSocks arrivalSocks) {
        socksService.acceptSocks(arrivalSocks);
        return ResponseEntity.ok("Носки добавлены на склад");
    }

    @PutMapping
    @Operation(summary = "Выдача носков со склада")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Удалось произвести отпуск носков со склада; "),
            @ApiResponse(responseCode = "400", description = "Товара нет на складе в нужном количестве или параметры запроса имеют некорректный формат;"),
            @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны.")
    })
    public ResponseEntity<String> updateSocks(@Valid @RequestBody ArrivalSocks arrivalSocks) {
        int socksCount = socksService.updateSocks(arrivalSocks);
        return ResponseEntity.ok(socksCount + "Убыли со склада");
    }

    @GetMapping
    @Operation(summary = "Получение определенного вида кол-ва носков на складе")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос выполнен, результат в теле ответа в виде строкового представления целого числа."),
            @ApiResponse(responseCode = "400", description = "Параметры запроса отсутствуют или имеют некорректный формат."),
            @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны.")
    })
    public ResponseEntity<String> getSocks(@RequestParam Color color,
                                            @RequestParam Size size,
                                            @RequestParam int cottonMin,
                                            @RequestParam int cottonMax) {
        int quantity = socksService.getSocks(color, size, cottonMin, cottonMax);
        return ResponseEntity.ok(quantity + " шт. данных носков на складе");
    }

    @GetMapping("all")
    @Operation(summary = "Получение кол-во носков на складе")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос выполнен, результат в теле ответа в виде строкового представления целого числа."),
            @ApiResponse(responseCode = "400", description = "Параметры запроса отсутствуют или имеют некорректный формат."),
            @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны.")
    })
    public ResponseEntity<Map<Socks, Integer>> getAllSocks() {
        return ResponseEntity.ok(socksService.getAllSocks());
    }

    @DeleteMapping
    @Operation(summary = "Удаление брака со склада")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос выполнен, товар списан со склада;"),
            @ApiResponse(responseCode = "400", description = "Параметры запроса отсутствуют или имеют некорректный формат."),
            @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны.")
    })
    public ResponseEntity<String> deleteSocks(@RequestBody ArrivalSocks arrivalSocks) {
       int socksCount = socksService.updateSocks(arrivalSocks);
        return ResponseEntity.ok(socksCount + " уничтожены");
    }
}
