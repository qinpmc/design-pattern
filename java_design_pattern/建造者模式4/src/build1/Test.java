package build1;

public class Test {
    public static void main(String[] args) {

        Builder mb = new MobikeBuilder();
        Director director = new Director(mb);
        Bike mbike = director.construct();
        mbike.run();
        mbike.getFrame().support();

        Builder ob = new OfoBuilder();
        Director director1 = new Director(ob);
        Bike obike = director1.construct();
        obike.run();
        obike.getFrame().support();
    }
}
