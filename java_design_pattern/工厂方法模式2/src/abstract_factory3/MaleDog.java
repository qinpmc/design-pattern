package abstract_factory3;

import factory1.Animal;

public class MaleDog extends Animal {

    @Override
    public void eat() {
        System.out.println("male dog eat");
    }
}
