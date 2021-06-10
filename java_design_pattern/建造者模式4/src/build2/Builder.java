package build2;

public class Builder {
     String cpu;
     String screen;
     String memory;
     String mainboard;

    public Builder cpu(String val) {
        cpu = val;
        return this;
    }
    public Builder screen(String val) {
        screen = val;
        return this;
    }
    public Builder memory(String val) {
        memory = val;
        return this;
    }
    public Builder mainboard(String val) {
        mainboard = val;
        return this;
    }
    public Computer build() {
        return new Computer(this);}
}
