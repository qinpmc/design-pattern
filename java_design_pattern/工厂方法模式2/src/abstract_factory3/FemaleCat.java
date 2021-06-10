package abstract_factory3;

import factory1.Animal;

public class FemaleCat extends Animal {
    @Override
    public void eat() {
        System.out.println("female cat eat");
    }
}
