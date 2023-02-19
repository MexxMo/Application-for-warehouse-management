package me.mexx.noskiapp.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.mexx.noskiapp.model.Socks;
import me.mexx.noskiapp.service.SocksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/socks")
@Tag(name = "API для работы с товаром")
@RequiredArgsConstructor
public class SocksController {

    private final SocksService socksService;

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос выполнен, результат в теле ответа в виде строкового представления целого числа."),
            @ApiResponse(responseCode = "400", description = "Параметры запроса отсутствуют или имеют некорректный формат."),
            @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны.")
    })
    public ResponseEntity<Socks> getSocks() {

    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Удалось добавить приход"),
            @ApiResponse(responseCode = "400", description = "Параметры запроса отсутствуют или имеют некорректный формат."),
            @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны.")
    })
    public ResponseEntity<> post() {

    }

    @PutMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Удалось произвести отпуск носков со склада; "),
            @ApiResponse(responseCode = "400", description = "Товара нет на складе в нужном количестве или параметры запроса имеют некорректный формат;"),
            @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны.")
    })
    public ResponseEntity<> put() {

    }

    @DeleteMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос выполнен, товар списан со склада;"),
            @ApiResponse(responseCode = "400", description = "Параметры запроса отсутствуют или имеют некорректный формат."),
            @ApiResponse(responseCode = "500", description = "Произошла ошибка, не зависящая от вызывающей стороны.")
    })
    public ResponseEntity<Socks> delete() {

    }
}
