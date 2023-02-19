package me.mexx.noskiapp.model;

public enum Operation {
    SALE("Продажа"), RECEIVING("Получение");

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
