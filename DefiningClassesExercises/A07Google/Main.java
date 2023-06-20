package DefiningClassesExercises.A07Google;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, Person> persons = new HashMap<>();

        String input = scan.nextLine();

        while (!input.equals("End")) {


            String[] personData = input.split("\\s+");

            String name = personData[0];

            if (!persons.containsKey(name)) {

                Person person = new Person(name);
                persons.put(name, person);

            }

            String info = personData[1];

            if (info.equals("company")) {

                //GeorgeJohnson company JeleInc Jelior 777.77
                //{companyName} {companyDepartment} {salary}

                String companyName = personData[2];
                String companyDepartment = personData[3];
                double salary = Double.parseDouble(personData[4]);
                Company company = new Company(companyName, companyDepartment, salary);
                persons.get(name).setCompany(company);

            } else if (info.equals("car")) {

                //GeorgeJohnson car AudiA4 180
                //•	"{Name} car {carModel} {carSpeed}"

                String model = personData[2];
                String carSpeed = personData[3];
                Car car = new Car(model, carSpeed);
                persons.get(name).setCar(car);

            } else if (info.equals("pokemon")) {

                //GeorgeJohnson pokemon Onyx Rock
                //AlexAlexson pokemon Moltres Fire
                //SmithSmithon pokemon Blastoise Water
                //GeorgeJohnson pokemon Charizard Fire
                //•	"{Name} pokemon {pokemonName} {pokemonType}"

                String pokemonName = personData[2];
                String pokemonType = personData[3];

                Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                persons.get(name).getPokemons().add(pokemon);

            } else if (info.equals("parents")) {

                //GeorgeJohnson parents SaraJohnson 13/03/1933
                //•	"{Name} parents {parentName} {parentBirthday}"

                String parentName = personData[2];
                String parentBirthday = personData[3];
                Parent parent = new Parent(parentName, parentBirthday);
                persons.get(name).getParents().add(parent);

            } else if (info.equals("children")) {

                //GeorgeJohnson children SamJohnson 01/01/2001
                //•	"{Name} children {childName} {childBirthday}"

                String childName = personData[2];
                String childBirthday = personData[3];
                Child child = new Child(childName, childBirthday);
                persons.get(name).getChildren().add(child);

            }

            input = scan.nextLine();

        }

        String searchName = scan.nextLine();

        if (persons.containsKey(searchName)) {
            System.out.println(persons.get(searchName).toString());
        }

    }
}
