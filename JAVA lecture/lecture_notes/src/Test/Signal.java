package Test;

public enum Signal {
    red ("red",1),
    yellow("yellow",2),
    green("green",3);
    private String name;
    private int index;

    private Signal(String name, int value) {
        this.name =name;
        this.index = value;
    }

    public static Signal change(Signal s){
        return yellow;
    }

    public static void main(String[] args) {
        System.out.println(Signal.red.name);

    }
}
