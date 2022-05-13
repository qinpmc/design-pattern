# 建造者模式

 
- 设计模式之禅
- https://juejin.cn/post/6844904169602564110 ！
- https://zhuanlan.zhihu.com/p/143101326 ！
- https://zhuanlan.zhihu.com/p/266392844
- https://zhuanlan.zhihu.com/p/58093669（评论）
- https://www.jianshu.com/p/3d1c9ffb0a28
- https://blog.csdn.net/ljcitworld/article/details/80387378


## 建造者模式定义

建造者模式（Builder Pattern）也叫做生成器模式，其定义如下：
Separate the construction of a complex object from its representation so that the same
construction process can create different representations.
将一个**复杂对象**的**构建与它的表示分离**，使得同样的构建过程可以创建不同的表示。

## 建造者模式类图

![build类图](build类图.png)

- 指挥者（Director）直接和客户（Client）进行需求沟通；
- 沟通后指挥者将客户创建产品的需求划分为各个部件的建造请求（Builder）；
- 将各个部件的建造请求委派到具体的建造者（ConcreteBuilder）；
- 各个具体建造者负责进行产品部件的构建,最终构建成具体产品（Product）。
 
Client => 使用  Director => 调用 ConcreteBuilder的方法  


## 建造者模式的使用场景：
- 相同的方法，不同的执行顺序，产生不同的事件结果时，可以采用建造者模式。
- 多个部件或零件，都可以装配到一个对象中，但是产生的运行结果又不相同时，则可以使用该模式。
- 产品类非常复杂，或者产品类中的调用顺序不同产生了不同的效能，这个时候使用建造者模式非常合适。
- 在对象创建过程中会使用到系统中的一些其他对象，这些对象在产品对象的创建过程中不易得到时，也可以采用建造者模式封装该对象的创建过程。
该种场景只能是一个补偿方法，因为一个对象不容易获得，而在设计阶段竟然没有发觉，而要通过创建者模式柔化创建过程，本身已经违反设计的最初目标。
- 初始化一个对象特别复杂，参数多，而且很多参数都具有默认值。


## 建造者模式和工厂模式区别
建造者模式优点类似于工厂模式，都是用来创建一个对象，但是他们还是有很大的区别，主要区别如下：

- 1、建造者模式更加注重方法的**调用顺序**，工厂模式注重于创建完整对象
- 2、建造者模式根据不同的产品零件和顺序可以创造出不同的产品，而工厂模式创建出来的产品都是一样的
- 3、建造者模式使用者需要知道这个产品有哪些零件组成，而工厂模式的使用者不需要知道，直接创建就行


 
## 示例
用 builder 模式创建共享单车为例子：build1

产品类：
```
public class Bike { 

    private IFrame frame; 
    private ISeat seat; 
    private ITire tire; 
    
    ...get set
}

```

Builder 类：
```
// 抽象 builder 类 
public abstract class Builder { 
    abstract void buildFrame(); 
    abstract void buildSeat(); 
    abstract void buildTire(); 
    abstract Bike build(); 
} 
```

ConcreteBuilder 类 :

```
// 具体 builder 类 
public class MobikeBuilder extends Builder{ 
    private Bike mBike = new Bike(); 
    @Override 
    void buildFrame() { 
        mBike.setFrame(new AlloyFrame()); 
    } 
    @Override 
    void buildSeat() { 
        mBike.setSeat(new DermisSeat()); 
    } 
    @Override 
    void buildTire() { 
        mBike.setTire(new SolidTire()); 
    } 
    @Override 
    Bike build() { 
        return mBike; 
    } 
} 

public class OfoBuilder extends Builder{ 
    private Bike mBike = new Bike(); 
    @Override 
    void buildFrame() { 
        mBike.setFrame(new CarbonFrame()); 
    } 
    @Override 
    void buildSeat() { 
        mBike.setSeat(new RubberSeat()); 
    } 
    @Override 
    void buildTire() { 
        mBike.setTire(new InflateTire()); 
    } 
    @Override 
    Bike build() { 
        return mBike; 
    } 
} 

```

指挥者类：

```
public class Director { 
    private Builder mBuilder = null; 
    public Director(Builder builder) { 
        mBuilder = builder; 
    } 
    public Bike construct() { 
        mBuilder.buildFrame(); 
        mBuilder.buildSeat(); 
        mBuilder.buildTire(); 
        return mBuilder.build(); 
    } 
}
```

客户端使用：

```
public class Click { 
    public static void main(String[] args) { 
        showBike(new OfoBuilder()); 
        showBike(new MobikeBuilder()); 
    } 
    private void showBike(Builder builder) {
        Director director = new Director(builder); 
        Bike bike = director.construct(); 
        bike.getFrame().frame(); 
        bike.getSeat().seat(); 
        bike.getTire().tire(); 
    } 
} 
```

！以上可以**简化**(director 合并到 Builder)：

```
public abstract class NewBuilder { 
    abstract void buildFrame(); 
    abstract void buildSeat(); 
    abstract void buildTire(); 
    abstract Bike build(); 
    /** 
    * 把导演类中的construct()方法合并到抽象建造者类中 
    * 
    * @return 具体产品对象 
    */ 
    public Bike construct() { 
        this.buildFrame(); 
        this.buildSeat(); 
        this.buildTire(); 
        return this.build(); 
    } 
} 
```

## 建造者模式在源码中体现

1、jdk源码中，StringBuilder类,append方法就是给我们提供了一种链式创建对象的方法：

![stringbuilder图](stringbuilder.jpg)

然后toString方法返回了一个完整的对象：
![toString 图](toString.jpg)
 
2、MyBatis中SqlSessionFactoryBuiler中就用到了建造者模式。
![SqlSessionFactoryBuiler 图](SqlSessionFactoryBuiler.jpg)


3、Android的AlertDialog ：链式调用，代码简洁易懂，且可以自由组合

```
  AlertDialog dialog = new AlertDialog.Builder(getContext())
              .setTitle("标题")
              .setMessage("内容")
              .setPositiveButton("确定", null)
              .setPositiveButton("取消", null)
              .create();
  dialog.show();
```

 



建造者模式和工厂模式区别
建造者模式优点类似于工厂模式，都是用来创建一个对象，但是他们还是有很大的区别，主要区别如下：

1、建造者模式更加注重方法的调用顺序，工厂模式注重于创建完整对象
2、建造者模式根据不同的产品零件和顺序可以创造出不同的产品，而工厂模式创建出来的产品都是一样的
3、建造者模式使用者需要知道这个产品有哪些零件组成，而工厂模式的使用者不需要知道，直接创建就行

体会：根据示例1 https://juejin.cn/post/6844904169602564110 和 示例2https://zhuanlan.zhihu.com/p/143101326。

建造者设计模式中还可以控制错误的产生，如果直接使用产品类的 setter方法，可能某些情况下，用户会设置错误（如示例1 装修中同时设置地板和地砖，用例2中用户遗漏设置KFC套餐中必选项等）

 



示例2:
装修中所需物料；ceilling(吊顶)、coat(涂料)、floor(地板)、tile(地砖)


1. 物料接口
```
//物料接口
public interface Matter {

    String scene();      // 场景；地板、地砖、涂料、吊顶

    String brand();      // 品牌

    String model();      // 型号

    BigDecimal price();  // 价格

    String desc();       // 描述

}


```


2. 吊顶(ceiling) 

两种吊顶，实现物料接口

```
一级顶
public class LevelOneCeiling implements Matter {

    public String scene() {
        return "吊顶";
    }

    public String brand() {
        return "装修公司自带";
    }

    public String model() {
        return "一级顶";
    }

    public BigDecimal price() {
        return new BigDecimal(260);
    }

    public String desc() {
        return "造型只做低一级，只有一个层次的吊顶，一般离顶120-150mm";
    }

}


// 二级顶
public class LevelTwoCeiling  implements Matter {

    public String scene() {
        return "吊顶";
    }

    public String brand() {
        return "装修公司自带";
    }

    public String model() {
        return "二级顶";
    }

    public BigDecimal price() {
        return new BigDecimal(850);
    }

    public String desc() {
        return "两个层次的吊顶，二级吊顶高度一般就往下吊20cm，要是层高很高，也可增加每级的厚度";
    }
    
}

 

```


 3. 涂料(coat)

两种涂料，实现物料接口

```


// 多乐士涂料
public class DuluxCoat  implements Matter {

    public String scene() {
        return "涂料";
    }

    public String brand() {
        return "多乐士(Dulux)";
    }

    public String model() {
        return "第二代";
    }

    public BigDecimal price() {
        return new BigDecimal(719);
    }

    public String desc() {
        return "多乐士是阿克苏诺贝尔旗下的著名建筑装饰油漆品牌，产品畅销于全球100个国家，每年全球有5000万户家庭使用多乐士油漆。";
    }
    
}
// 立邦涂料
public class LiBangCoat implements Matter {

    public String scene() {
        return "涂料";
    }

    public String brand() {
        return "立邦";
    }

    public String model() {
        return "默认级别";
    }

    public BigDecimal price() {
        return new BigDecimal(650);
    }

    public String desc() {
        return "立邦始终以开发绿色产品、注重高科技、高品质为目标，以技术力量不断推进科研和开发，满足消费者需求。";
    }

}

 


```



4. 地板(floor)

两种地板，实现物料接口

```
// 德尔地板
public class DerFloor implements Matter {

    public String scene() {
        return "地板";
    }

    public String brand() {
        return "德尔(Der)";
    }

    public String model() {
        return "A+";
    }

    public BigDecimal price() {
        return new BigDecimal(119);
    }

    public String desc() {
        return "DER德尔集团是全球领先的专业木地板制造商，北京2008年奥运会家装和公装地板供应商";
    }
    
}
// 圣象地板
public class ShengXiangFloor implements Matter {

    public String scene() {
        return "地板";
    }

    public String brand() {
        return "圣象";
    }

    public String model() {
        return "一级";
    }

    public BigDecimal price() {
        return new BigDecimal(318);
    }

    public String desc() {
        return "圣象地板是中国地板行业著名品牌。圣象地板拥有中国驰名商标、中国名牌、国家免检、中国环境标志认证等多项荣誉。";
    }

}

```






5. 地砖(tile)


两种地砖，实现物料接口

```
// 东鹏地砖
public class DongPengTile implements Matter {

    public String scene() {
        return "地砖";
    }

    public String brand() {
        return "东鹏瓷砖";
    }

    public String model() {
        return "10001";
    }

    public BigDecimal price() {
        return new BigDecimal(102);
    }

    public String desc() {
        return "东鹏瓷砖以品质铸就品牌，科技推动品牌，口碑传播品牌为宗旨，2014年品牌价值132.35亿元，位列建陶行业榜首。";
    }

}

// 马可波罗地砖
public class MarcoPoloTile implements Matter {

    public String scene() {
        return "地砖";
    }

    public String brand() {
        return "马可波罗(MARCO POLO)";
    }

    public String model() {
        return "缺省";
    }

    public BigDecimal price() {
        return new BigDecimal(140);
    }

    public String desc() {
        return "“马可波罗”品牌诞生于1996年，作为国内最早品牌化的建陶品牌，以“文化陶瓷”占领市场，享有“仿古砖至尊”的美誉。";
    }

}

```

豪华欧式,轻奢田园,现代简约 3种级别的装修，吊顶，涂料和 地板/地砖 的组合，

if else实现需求: 

```


public class DecorationPackageController {

    public String getMatterList(BigDecimal area, Integer level) {

        List<Matter> list = new ArrayList<Matter>(); // 装修清单
        BigDecimal price = BigDecimal.ZERO;          // 装修价格

        // 豪华欧式
        if (1 == level) {

            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling(); // 吊顶，二级顶
            DuluxCoat duluxCoat = new DuluxCoat();                   // 涂料，多乐士
            ShengXiangFloor shengXiangFloor = new ShengXiangFloor(); // 地板，圣象

            list.add(levelTwoCeiling);
            list.add(duluxCoat);
            list.add(shengXiangFloor);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(duluxCoat.price()));
            price = price.add(area.multiply(shengXiangFloor.price()));

        }

        // 轻奢田园
        if (2 == level) {

            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling(); // 吊顶，二级顶
            LiBangCoat liBangCoat = new LiBangCoat();                // 涂料，立邦
            MarcoPoloTile marcoPoloTile = new MarcoPoloTile();       // 地砖，马可波罗

            list.add(levelTwoCeiling);
            list.add(liBangCoat);
            list.add(marcoPoloTile);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(liBangCoat.price()));
            price = price.add(area.multiply(marcoPoloTile.price()));

        }

        // 现代简约
        if (3 == level) {

            LevelOneCeiling levelOneCeiling = new LevelOneCeiling();  // 吊顶，二级顶
            LiBangCoat liBangCoat = new LiBangCoat();                 // 涂料，立邦
            DongPengTile dongPengTile = new DongPengTile();           // 地砖，东鹏

            list.add(levelOneCeiling);
            list.add(liBangCoat);
            list.add(dongPengTile);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelOneCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(liBangCoat.price()));
            price = price.add(area.multiply(dongPengTile.price()));
        }

        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "装修清单" + "\r\n" +
                "套餐等级：" + level + "\r\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\r\n" +
                "房屋面积：" + area.doubleValue() + " 平米\r\n" +
                "材料清单：\r\n");

        for (Matter matter: list) {
            detail.append(matter.scene()).append("：").append(matter.brand()).append("、").append(matter.model()).append("、平米价格：").append(matter.price()).append(" 元。\n");
        }

        return detail.toString();

    }

}

 

```

建造者模式实现：


装修包接口
```
public interface IMenu {

    IMenu appendCeiling(Matter matter); // 吊顶

    IMenu appendCoat(Matter matter);    // 涂料

    IMenu appendFloor(Matter matter);   // 地板

    IMenu appendTile(Matter matter);    // 地砖

    String getDetail();                 // 明细 

}
```


装修包实现

```
public class DecorationPackageMenu implements IMenu {

    private List<Matter> list = new ArrayList<Matter>();  // 装修清单
    private BigDecimal price = BigDecimal.ZERO;      // 装修价格

    private BigDecimal area;  // 面积
    private String grade;     // 装修等级；豪华欧式、轻奢田园、现代简约

    private DecorationPackageMenu() {
    }

    public DecorationPackageMenu(Double area, String grade) {
        this.area = new BigDecimal(area);
        this.grade = grade;
    }

    public IMenu appendCeiling(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(new BigDecimal("0.2")).multiply(matter.price()));
        return this;
    }

    public IMenu appendCoat(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(new BigDecimal("1.4")).multiply(matter.price()));
        return this;
    }

    public IMenu appendFloor(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    public IMenu appendTile(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    public String getDetail() {

        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "装修清单" + "\r\n" +
                "套餐等级：" + grade + "\r\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\r\n" +
                "房屋面积：" + area.doubleValue() + " 平米\r\n" +
                "材料清单：\r\n");

        for (Matter matter: list) {
            detail.append(matter.scene()).append("：").append(matter.brand()).append("、").append(matter.model()).append("、平米价格：").append(matter.price()).append(" 元。\n");
        }

        return detail.toString();
    }

}
```


建造者方法

```
public class Builder {

    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                .appendCeiling(new LevelTwoCeiling())    // 吊顶，二级顶
                .appendCoat(new DuluxCoat())             // 涂料，多乐士
                .appendFloor(new ShengXiangFloor());     // 地板，圣象
    }

    public IMenu levelTwo(Double area){
        return new DecorationPackageMenu(area, "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new MarcoPoloTile());       // 地砖，马可波罗
    }

    public IMenu levelThree(Double area){
        return new DecorationPackageMenu(area, "现代简约")
                .appendCeiling(new LevelOneCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new DongPengTile());        // 地砖，东鹏
    }

}
```
 

测试：
 
```

@Test
public void test_Builder(){
    Builder builder = new Builder();
    // 豪华欧式
    System.out.println(builder.levelOne(132.52D).getDetail());
    // 轻奢田园
    System.out.println(builder.levelTwo(98.25D).getDetail());
    // 现代简约
    System.out.println(builder.levelThree(85.43D).getDetail());
}
 

```

 








