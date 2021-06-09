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
 





























