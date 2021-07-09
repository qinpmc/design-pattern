package proxy1;

// 静态代理
public class IntermediaryProxy implements IRentHouse {

    private IRentHouse rentHouse;

    public IntermediaryProxy(IRentHouse irentHouse){
        rentHouse = irentHouse;
    }

    @Override
    public void rentHouse() {
        System.out.println("中介带领看房子");
        rentHouse.rentHouse();
        System.out.println("交中介费");
    }
}
