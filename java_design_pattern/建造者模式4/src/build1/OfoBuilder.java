package build1;

public class OfoBuilder extends Builder {
    private Bike oBike = new Bike();
    @Override
    void buildFrame() {
        oBike.setFrame(new CarbonFrame()); //碳纤维支撑
    }

    @Override
    void buildSeat() {
        oBike.setSeat(new RubberSeat());//橡胶座位
    }

    @Override
    void buildTire() {
        oBike.setTire(new InflateTire()); // 充气轮胎
    }

    @Override
    Bike build() {
        return oBike;
    }
}
