package Enum;

public enum EnumText {
    bold ("\u001B[1m"),
    unbold ("\\u001B[21m"),
    reset("\u001B[0m"),
    black("\u001B[30m"),
    red("\u001B[31m"),
    green("\u001B[32m"),
    light_green("\u001B[92m"),
    light_blue("\u001B[94m"),
    light_purple("\u001B[95m"),
    light_cyan("\u001B[96m"),
    light_white("\u001B[97m"),
    gray("\u001B[90m"),
    light_red("\u001B[91m"),

    light_yellow("\u001B[93m"),
    yellow("\u001B[33m"),
    blue("\u001B[34m"),
    purple("\u001B[35m"),
    cyan("\u001B[36m"),
    white("\u001B[37m"),
    black_bcg("\u001B[40m"),
    red_bcg("\u001B[41m"),
    green_bcg("\u001B[42m"),
    cyan_bcg("\u001B[46m"),
    white_bcg("\u001B[47m"),
    yellow_bcg("\u001B[43m"),
    blue_bcg("\u001B[44m"),
    purple_bcg("\u001B[45m");

    private final String colorValue;

    public String getColorValue() {
        return colorValue;
    }

    EnumText(String colorValue) {
        this.colorValue = colorValue;

    }
    @Override
    public String toString() {
        return "Color is "+colorValue;
    }
}
