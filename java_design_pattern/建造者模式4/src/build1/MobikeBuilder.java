package build1;

public class MobikeBuilder extends Builder {
    private Bike mbike = new Bike();
    @Override
    void buildFrame() {
        mbike.setFrame(new AlloyFrame()); //合金支撑
    }

    @Override
    void buildSeat() {
        mbike.setSeat(new DermisSeat()); //真皮座位
    }

    @Override
    void buildTire() {
        mbike.setTire(new SolidTire());//实心轮胎
    }

    @Override
    Bike build() {
        return mbike;
    }
}
