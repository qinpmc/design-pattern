package build1;

public class Bike implements IBike {

    // 构架
    private IFrame frame;
    // 座位
    private ISeat seat;
    // 轮胎
    private ITire tire;

    public IFrame getFrame() {
        return frame;
    }
    public void setFrame(IFrame frame) {
        this.frame = frame;
    }
    public ISeat getSeat() {
        return seat;
    }
    public void setSeat(ISeat seat) {
        this.seat = seat;
    }
    public ITire getTire() {
        return tire;
    }
    public void setTire(ITire tire) {
        this.tire = tire;
    }

    @Override
    public void run() {
        System.out.println("Bike can run");
    }
}
