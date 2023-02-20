package me.mexx.noskiapp.model;

public enum Size {
    S(23),M(25),L(27),XL(29),XXL(31);

    private final int size;

    Size(int size) {
        this.size = size;
    }


    @Override
    public String toString() {
        return "Размер " + size;
    }
}
