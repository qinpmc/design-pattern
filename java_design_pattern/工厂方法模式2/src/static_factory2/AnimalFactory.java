package static_factory2;

import factory1.Animal;
import factory1.Cat;
import factory1.Dog;

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
    // 外界想要猫要狗，这里创建就好了
    public static <T extends Animal> T createAnimal2(Class<T> clazz) {
        try {
            Animal a =(Animal) Class.forName(clazz.getName()).newInstance();
            return  (T)a;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
