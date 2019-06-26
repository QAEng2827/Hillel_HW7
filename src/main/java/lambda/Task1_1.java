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

public class Task1_1 {


    // static Person[] arrayPersons = new Person[7];

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Dean", 41));
        persons.add(new Person("Sam", 37));
        persons.add(new Person("John", 66));
        persons.add(new Person("Mary", 64));
        persons.add(new Person("Bobby", 66));

        Comparator<Person> comparatorName = Comparator.comparing(person -> person.getPersonName());
        Comparator<Person> comparatorAge = Comparator.comparing(person -> person.getPersonAge());

        // Comparator<Person> comparator = Comparator.comparing(person ->person.getPersonAge());
        // Arrays.sort()
        // Collections.sort();


      Collections.sort(persons,comparatorName);
      Collections.sort(persons,comparatorAge);
      persons.stream()
              .forEach(person -> System.out.println("Name: "+ person.personName+ "  Age: " + person.personAge));

    }
}
