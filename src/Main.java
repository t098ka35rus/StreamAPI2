import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long minor = getNumOfMinor(persons);
        System.out.println("Всего несовершеннолетних = " + minor);


    }

    public static long getNumOfMinor ( Collection <Person> p){
        Stream <Person> stream = p.stream();
        return stream.filter(person -> person.getAge() < 18).count();
    }

    public static List<String> getListOfRecruits (Person p){
        return null;
    }

    public static List<String> getListOfEmployable (Person p){
        return null;
    }


}