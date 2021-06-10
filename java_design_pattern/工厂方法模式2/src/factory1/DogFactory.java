package factory1;

public class DogFactory implements AnimalFactory {

    public Animal createAnimal() {
        return new Dog();
    }
}
