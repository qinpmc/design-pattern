package build2;

public class Computer {
    private String cpu;
    private String screen;
    private String memory;
    private String mainboard;

    public Computer(Builder builder) {
        cpu = builder.cpu;
        screen = builder.screen;
        memory = builder.memory;
        mainboard = builder.mainboard;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setMainboard(String mainboard) {
        this.mainboard = mainboard;
    }

    public String getCpu() {

        return cpu;
    }

    public String getScreen() {
        return screen;
    }

    public String getMemory() {
        return memory;
    }

    public String getMainboard() {
        return mainboard;
    }

    public Computer(String cpu, String screen, String memory, String mainboard) {
        this.cpu = cpu;
        this.screen = screen;
        this.memory = memory;
        this.mainboard = mainboard;
    }

}
