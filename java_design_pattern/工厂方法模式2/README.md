# 工厂模式

- https://www.zhihu.com/question/27125796/answer/688147580
- https://zhuanlan.zhihu.com/p/31287344
- https://zhuanlan.zhihu.com/p/61098478
- 设计模式之禅

工厂模式分成三种：

1. 简单/静态工厂模式
2. 工厂方法模式
3. 抽象工厂模式


## 引子  为什么要用工厂模式？

如创建BufferedReader对象 ：

``` 
// 创建一个BufferedReader对象
 BufferedReader bf = new BufferedReader(new FileReader(new File("aa.txt")));

```

如果项目中很多地方（比如很多类中）都用到 BufferedReader对象 ，需要重复写，另外，如果需要将BufferedReader改为 LineNumberReader，需要到处修改。

解决办法：

```
// 创建Reader对象的工厂
public class ReaderFactory {
    public static Reader getReader() throws FileNotFoundException {
        File file = new File("aa.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        return reader;
    }
}

/////////////////////////
public class FileOperateA {
    public static void main(String[] args) throws FileNotFoundException {
        //-------原来的方式
        //File file = new File("aa.txt");
        //FileReader fileReader = new FileReader(file);
        //BufferedReader bufferedReader = new BufferedReader(fileReader);
 
		// 用工厂来创建出对象
        Reader reader = ReaderFactory.getReader();
        // 读写文件....
    }
}

```

## 工厂模式

工厂方法模式使用的频率非常高， 其定义为：
Define an interface for creating an object,but let subclasses decide which class to
instantiate.Factory Method lets a class defer instantiation to subclasses.
定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。

在数据库开发中，大家应该能够深刻体会到工厂方法模式的好处：如果使用JDBC连接数据库，数据库从MySQL切换到Oracle，需要改动的地方就是切换一下驱动名称（前提
条件是SQL语句是标准语句），其他的都不需要修改，这是工厂方法模式灵活性的一个直接案例。

例如需要设计一个连接邮件服务器的框架，有三种网络协议可供选择：POP3、IMAP、HTTP，我们就可以把这三种连接方法作为产品类，定义一个接口如IConnectMail，   
然后定义对邮件的操作方法，用不同的方法实现三个具体的产品类（也就是连接方式）再定义一个工厂方法，按照不同的传入条件，选择不同的连接方式。


简单/静态工厂模式是在工厂方法模式上缩减，抽象工厂模式是在工厂方法模式上再增强。

1. 工厂接口及实现类
```
public interface AnimalFactory {

	// 可以获取任何的宠物
	Animal createAnimal();
}



// 继承着宠物工厂
public class CatFactory implements AnimalFactory {
    @Override
    // 创建猫
    public Animal createAnimal() {
        return new Cat();
    }


}狗工厂也是一样的：// 继承着宠物工厂
public class DogFactory implements AnimalFactory {

	// 创建狗
	@Override
	public Animal createAnimal() {
		return new Dog();
	}

}
 

```

2. 动物抽象类及实现类
```
动物实体类：public abstract class Animal {

	// 所有的动物都会吃东西
	public abstract void eat();
}猫实体类：public class Cat extends Animal {
	
	// 猫喜欢吃鱼
	@Override
	public void eat() {
		System.out.println("猫吃鱼");
	}

}狗实体类：public class Dog extends Animal {

	// 狗喜欢吃肉
	@Override
	public void eat() {
		System.out.println("狗吃肉");
	}

}
 
```
使用工厂创建对象：

```
//  创建狗工厂
AnimalFactory df = new DogFactory();
//  创建狗
Animal dog = df.createAnimal();
dog.eat();
 
// 创建猫工厂
AnimalFactory cf = new CatFactory();
// 创建猫
Animal cat = cf.createAnimal();
cat.eat();

```

 

##  简单/静态工厂模式

```
public class AnimalFactory {
    public static Dog createDog() {
        return new Dog();
    }

    public static Cat createCat() {
        return new Cat();
    }


    // 外界想要猫要狗，这里创建就好了
    public static Animal createAnimal(String type) {
        if ("dog".equals(type)) {
            return new Dog();
        } else if ("cat".equals(type)) {
            return new Cat();
        } else {
            return null;
        }
    }
}
```
 
```
// 拿到狗
Animal dog = AnimalFactory.createAnimal("dog");
dog.eat();

// 拿到猫
Animal cat = AnimalFactory.createAnimal("cat");
cat.eat();
 
```
 

## 抽象工厂模式
 
```
public interface AnimalFactory {
	Animal createDog();
	Animal createCat();
}


```

创建母猫和母狗的工厂：

``` 

public class FemaleAnimalFactory implements AnimalFactory {

    // 生产母狗和母猫
    @Override
    public Animal createDog() {
        return  new FemaleDog();
    }

    @Override
    public Animal createCat() {
        return new FemaleCat();
    }

}

```


创建公猫和公狗的工厂：

```
public class MaleAnimalFactory implements AnimalFactory {
    
    // 生产公狗和公猫

    @Override
    public Animal createDog() {
        return new MaleDog();
    }

    @Override
    public Animal createCat() {
        return new MaleCat();
    }

}
```

使用：

```
public static void main(String[] args) {


        // 需要性别为母的就去找母工厂
        AnimalFactory af = new FemaleAnimalFactory();

        // 需要一只母猫
        af.createCat().gender();

        // 需要一只母狗
        af.createDog().gender();

       

        // 需要性别为公的就去找公工厂
        AnimalFactory aff = new MaleAnimalFactory();

        // 需要一只公狗
        aff.createDog().gender();

        // 需要一只公猫
        aff.createCat().gender();

    }

```

简单来说：**工厂方法**模式的工厂是创建出**一种产品**，而**抽象工厂**是创建出**一类产品（产品族）**;



























