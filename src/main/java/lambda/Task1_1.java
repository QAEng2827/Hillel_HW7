package lambda;
/*) Create:
a.	a Person class with name and age fields;
b.	an array of Persons;
c.	two instances of Comparator<Person> interface using lambda expressions: first one for comparing by name,
second one – by age;
d.	Then sort them using these comparators;
e.	Use forEach method for printing information about all the persons. Use the method reference;

*/

import java.util.*;

public class Task1_1 extends MyAnonimusClass implements ImpFunctionalInterfaces {


    public static void main(String[] args) {
        printTitle.startNewTack();


        Person[] arrayPersons = new Person[5];
        arrayPersons[0] = new Person("Dean", 41);
        arrayPersons[1] = new Person("Sam", 37);
        arrayPersons[2] = new Person("John", 66);
        arrayPersons[3] = new Person("Mary", 64);
        arrayPersons[4] = new Person("Bobby", 66);
        System.out.println("Array before sort:");

        ArrayList<Person> persons = new ArrayList<>(Arrays.asList(arrayPersons));
        persons.stream()
                .forEach(person -> System.out.println("Name: " + person.personName + "  Age: " + person.personAge));
        System.out.println();

//        List<Person> persons = new ArrayList<Person>();
//        persons.add(new Person("Dean", 41));
//        persons.add(new Person("Sam", 37));
//        persons.add(new Person("John", 66));
//        persons.add(new Person("Mary", 64));
//        persons.add(new Person("Bobby", 66));


        Comparator<Person> comparatorName = Comparator.comparing(person -> person.getPersonName());
        Comparator<Person> comparatorAge = Comparator.comparing(person -> person.getPersonAge());

        // Comparator<Person> comparator = Comparator.comparing(person ->person.getPersonAge());
        // Arrays.sort()
        // Collections.sort();

        System.out.println("Sorted array: ");
        Arrays.sort(arrayPersons, comparatorName);
        Arrays.sort(arrayPersons, comparatorAge);
        Arrays.stream(arrayPersons)
                .forEach(person -> System.out.println("Name: " + person.personName + "  Age: " + person.personAge));
        System.out.println();
//      Collections.sort(persons,comparatorName);
//      Collections.sort(persons,comparatorAge);
//      persons.stream()
//              .forEach(person -> System.out.println("Name: "+ person.personName+ "  Age: " + person.personAge));

/*// Implement each of main Java Standard Library functional interfaces (supplier, predicate etc.)
     using lambda expressions.*/
        printEnd.startNewTack();

        System.out.println("-----------------Predicate<T>--------------------");
        Predicate<Integer> isPositive = age -> age < 50;
        persons.stream()
                .forEach(person -> System.out.println("Yang generation : " + isPositive.test(person.personAge) +
                        "Name: " + person.personName + "  Age: " + person.personAge));
        System.out.println();

        System.out.println("-----------------BinaryOperator<T>--------------------");
        BinaryOperator<Integer> sumAge = (age1, age2) -> age1 + age2;
        System.out.printf("The sum of %s and %s ages is %s", arrayPersons[0].getPersonName(),
                arrayPersons[1].getPersonName(),
                sumAge.applyB(arrayPersons[0].getPersonAge(), arrayPersons[1].getPersonAge()));
        System.out.println();

        System.out.println("----------------- UnaryOperator<T>--------------------");
        UnaryOperator<Integer> realAge = (age) -> age + 40;
        System.out.printf("Real ages %s are %s", arrayPersons[1].getPersonName(), realAge.applyU(arrayPersons[1].getPersonAge()));
        System.out.println();


        System.out.println("----------------Function<T>--------------------");
        Function<Integer, String> convert = age -> String.valueOf(age) + " years old";
        persons.stream()
                .forEach(person -> System.out.println(person.personName + " is " + convert.apply(person.personAge)));
        System.out.println();

        System.out.println("---------------- Consumer<T>--------------------");
        Consumer<String> job= name -> System.out.printf(" Hunter %s \n",  name);

        persons.stream()
                .forEach(person ->  job.accept(person.personName));
        System.out.println();


        System.out.println("---------------- Supplier<T>--------------------");
        Supplier<String> lastName=() -> "Winchester";

        persons.stream()
                .forEach(person ->  System.out.println(person.personName +" "+ lastName.get()+ " is " + person.personAge+ " age" ));
        System.out.println();

        /*Create your own functional interface and add several its implementations using both lambda expressions
         and inner anonymous classes.*/
        print.startNewTack();
    }
}
