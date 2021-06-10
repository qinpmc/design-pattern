package factory1;

public class Test {
    public static void main(String[] args) {
        CatFactory cf = new CatFactory();
        Animal  cat = cf.createAnimal();
        cat.eat();

        DogFactory df = new DogFactory();
        Animal dog = df.createAnimal();
        dog.eat();

    }
}
