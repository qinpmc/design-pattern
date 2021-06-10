package abstract_factory3;

import factory1.Animal;

public class Test {
    public static void main(String[] args) {
        FemaleAnimalFactory faf = new FemaleAnimalFactory();
        Animal fc = faf.createCat();
        Animal fd = faf.createDog();
        fc.eat();
        fd.eat();

        MaleAnimalFactory mf = new MaleAnimalFactory();
        Animal mc = mf.createCat();
        Animal md = mf.createDog();
        mc.eat();
        md.eat();
    }
}
