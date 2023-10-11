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
        System.out.println("Всего несовершеннолетних = " + minor);
        List<String> recruits =  getListOfRecruits(persons);
        for (int i = 0; i < 15; i++) {
            System.out.println(recruits.get(i));
        }


    }

    public static long getNumOfMinor ( Collection <Person> p){
        Stream <Person> stream = p.stream();
        return stream.filter(person -> person.getAge() < 18).count();
    }

    public static List<String> getListOfRecruits (Collection <Person> p){
        Stream <Person> stream = p.stream();
        return  stream.filter(person -> person.getAge() >= 18)
                .filter(person -> person.getAge() < 27)
                .map(person -> person.getFamily()).collect(Collectors.toList());
    }

    public static List<String> getListOfEmployable (Collection <Person> p){
             Stream <Person> stream = p.stream();
        return  stream.filter(person -> person.getAge() >= 18)
                .filter(person -> person.getAge() < 65)
                .filter(person -> person.getEducation().equals("HIGHER"))
                .filter(person -> person.getSex().equals("WOMAN") && person.getAge() < 60)
                .sorted(Comparator.comparing(person -> person.getFamily()))



        return null;
    }


}