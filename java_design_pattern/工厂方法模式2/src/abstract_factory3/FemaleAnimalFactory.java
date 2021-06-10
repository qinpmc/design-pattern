package abstract_factory3;

import factory1.Animal;

public class FemaleAnimalFactory implements AnimalFactory {
    @Override
    public Animal createDog() {
        return new FemaleDog();
    }

    @Override
    public Animal createCat() {
        return new FemaleCat();
    }
}
