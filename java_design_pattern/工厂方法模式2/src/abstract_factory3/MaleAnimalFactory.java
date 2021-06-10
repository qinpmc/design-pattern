package abstract_factory3;

import factory1.Animal;

public class MaleAnimalFactory implements AnimalFactory {
    @Override
    public Animal createDog() {
        return new MaleDog();
    }

    @Override
    public Animal createCat() {
        return new MaleCat();
    }
}
