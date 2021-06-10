package abstract_factory3;

import factory1.Animal;

public class MaleCat extends Animal {
    @Override
    public void eat() {
        System.out.println("male cat eat");
    }
}
