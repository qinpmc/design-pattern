package abstract_factory3;

import factory1.Animal;

public interface AnimalFactory {
    Animal createDog();
    Animal createCat();
}
