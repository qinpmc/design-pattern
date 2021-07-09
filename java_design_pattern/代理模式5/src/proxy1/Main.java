package proxy1;

public class Main {
    public static void main(String[] args) {
        IRentHouse rentHouse = new RentHouse();
        IRentHouse proxy = new IntermediaryProxy(rentHouse);
        proxy.rentHouse();

/*        中介带领看房子
        付钱租了一间房子。。。
        交中介费*/

    }
}
