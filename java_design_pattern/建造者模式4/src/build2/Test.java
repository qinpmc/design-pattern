package build2;

public class Test {
    public static void main(String[] args) {
        // 非 Builder 模式
        Computer computer = new Computer("cpu", "screen", "memory", "mainboard");
        // Builder 模式
        Computer newComputer = new Builder()
                .cpu("cpu")
                .screen("screen")
                .memory("memory")
                .mainboard("mainboard")
                .build();

        System.out.println(newComputer.getCpu());
    }
}
