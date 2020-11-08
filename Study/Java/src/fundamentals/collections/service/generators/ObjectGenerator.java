package fundamentals.collections.service.generators;

import fundamentals.collections.service.generators.core.IGenerator;

import java.util.Collection;

public class ObjectGenerator {

    public static <T> void generate(Collection<T> collection, IGenerator<T> iGenerator, int size){

        while (collection.size() < size) {
            collection.add(iGenerator.generate());
        }

    }

}
