package fundamentals.collections.service.generators;

import fundamentals.collections.entity.Person;
import fundamentals.collections.service.generators.core.IGenerator;
import fundamentals.collections.utils.RandomUtils;

public class PersonGenerator implements IGenerator<Person> {

    @Override
    public Person generate() {

        return new Person(RandomUtils.getRandomString(0, 20), RandomUtils.getRandomString(5, 10));

    }

}
