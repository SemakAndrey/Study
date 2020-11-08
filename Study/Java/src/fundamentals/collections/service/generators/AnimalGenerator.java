package fundamentals.collections.service.generators;

import fundamentals.collections.entity.Animal;
import fundamentals.collections.service.generators.core.IGenerator;
import fundamentals.collections.utils.RandomUtils;

public class AnimalGenerator implements IGenerator<Animal>{

    @Override
    public Animal generate() {

        return new Animal(RandomUtils.getRandomString(0, 25), RandomUtils.getRandomInt(1, 15));

    }

}
