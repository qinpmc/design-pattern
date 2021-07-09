package proxy1;

// 租房的实现类
public class RentHouse implements IRentHouse {
    @Override
    public void rentHouse() {
        System.out.println("付钱租了一间房子。。。");
    }
}