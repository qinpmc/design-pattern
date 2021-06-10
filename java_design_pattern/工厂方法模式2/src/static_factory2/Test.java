package static_factory2;

import factory1.Animal;
import factory1.Dog;

public class Test {
    public static void main(String[] args) {
        Animal cat = AnimalFactory.createCat();
        Animal dog = AnimalFactory.createDog();

        Animal dog2 = AnimalFactory.createAnimal2(Dog.class);
        dog2.eat();
        Animal dog3 = AnimalFactory.createAnimal("dog");
        dog3.eat();
    }
}
