package 强制代理2;

public class Test {
    public static void main(String[] args) {
        //定义一个游戏的角色
        IGamePlayer player = new GamePlayer("张三");
        //获得指定的代理
        IGamePlayer proxy = player.getProxy();
        //开始打游戏，记下时间戳
        System.out.println("开始时间是：2009-8-25 10:45");
        proxy.login("zhangSan", "password");
        //开始杀怪
        proxy.killBoss();
        //升级
        proxy.upgrade();
        //记录结束游戏时间
        System.out.println("结束时间是：2009-8-26 03:40");

        System.out.println("***************");
        test1();
    }


    // 不使用代理 -- 失败
    public static void test1(){
        //定义一个游戏的角色
        IGamePlayer player = new GamePlayer("张三");
        //开始打游戏，记下时间戳
        System.out.println("开始时间是：2009-8-25 10:45");
        player.login("zhangSan", "password");
        //开始杀怪
        player.killBoss();
        //升级
        player.upgrade();
        //记录结束游戏时间
        System.out.println("结束时间是：2009-8-26 03:40");
    }



}
