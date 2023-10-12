import java.util.*;
import java.util.stream.Collectors;
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
        List<String> recruits = getListOfRecruits(persons);
        List<String> workers = getListOfEmployable(persons);
        System.out.println("MINOR = " + minor);
        System.out.println("RECRUITS = " + recruits.size());
        System.out.println("WORKERS = " + workers.size());


    }

    public static long getNumOfMinor(Collection<Person> p) {
        Stream<Person> stream = p.stream();
        return stream.filter(person -> person.getAge() < 18).count();
    }

    public static List<String> getListOfRecruits(Collection<Person> p) {
        Stream<Person> stream = p.stream();
        return stream.filter(person -> person.getAge() >= 18)
                .filter(person -> person.getAge() < 27)
                .map(Person::getFamily).collect(Collectors.toList());
    }

    public static List<String> getListOfEmployable(Collection<Person> p) {
        List<String> list = new ArrayList<>();
        Stream<Person> stream = p.stream();
        stream.filter(person -> person.getAge() >= 18)
                .filter(person -> person.getAge() < 60)
                .filter(person -> person.getEducation().toString().equals("HIGHER"))
                .filter(person -> person.getSex().toString().equals("WOMAN"))
                .forEach(person -> list.add(person.getFamily()));
        Stream<Person> stream1 = p.stream();
        stream1.filter(person -> person.getAge() >= 18)
                .filter(person -> person.getAge() < 65)
                .filter(person -> person.getEducation().toString().equals("HIGHER"))
                .filter(person -> person.getSex().toString().equals("MAN"))
                .forEach(person -> list.add(person.getFamily()));

        return list;

    }


}