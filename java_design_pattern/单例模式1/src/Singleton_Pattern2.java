package 单例模式1;

public class Singleton_Pattern2 {
    public static void main(String[] args) {
        //获取唯一可用的对象
        Singleton object = Singleton.getInstance();

        //显示消息
        object.showMessage();
    }
}
// 懒汉式，线程安全
 class Singleton {
    private static Singleton instance;
    private Singleton (){}
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
     public void showMessage(){
         System.out.println("Hello World2!");
     }
}