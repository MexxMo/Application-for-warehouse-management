package me.mexx.noskiapp.model;

public enum Color {
    WHITE("Белый"),BLUE("Синий"),RED("Красный"),YELLOW("Желтый"),BLACK("Черный"),AQUAMARINE("Аквамарин");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
