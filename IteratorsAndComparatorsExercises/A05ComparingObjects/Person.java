package IteratorsAndComparatorsExercises.A05ComparingObjects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }


    @Override
    public int compareTo(Person person) {

        if (this.name.compareTo(person.name) == 0) {

            if (this.age == person.age) {

                return this.town.compareTo(person.town);

            }

            return Integer.compare(this.age, person.age);

        }

        return this.name.compareTo(person.name);

    }
}
