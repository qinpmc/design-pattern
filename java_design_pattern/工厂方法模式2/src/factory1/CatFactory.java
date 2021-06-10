package factory1;

public class CatFactory implements AnimalFactory {

    public Animal createAnimal() {
        return new Cat();
    }
}
