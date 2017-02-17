package reflection;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Olga on 17.02.2017.
 */
public class Main {

    public static void main(String[] args) {
        final Serializator serializator = new Serializator();
        final List<People> peoples = new ArrayList<>();
        peoples.add(new People("Peter", 23, 190000));
        peoples.add(new People("Frank", 21, 178763));
        peoples.add(new People("John", 32, 100000));
        String fileName = String.format("%s/temp/people.xml", System.getProperties().get("user.dir"));
        serializator.serialize(fileName, peoples);

        final Deserializator deserializator = new Deserializator();
        List list = deserializator.deserialize(fileName);

        System.out.println(list);
    }
}
