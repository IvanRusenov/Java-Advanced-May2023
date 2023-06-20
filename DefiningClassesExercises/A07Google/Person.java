package DefiningClassesExercises.A07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person(String name) {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(this.getName()).append(System.lineSeparator());
        sb.append("Company:").append(System.lineSeparator());
        if (this.getCompany() != null) {
            sb.append(String.format("%s %s %.2f"
                    , this.getCompany().getCompanyName()
                    , this.getCompany().getCompanyDepartment()
                    , this.getCompany().getSalary())
            ).append(System.lineSeparator());
        }


        sb.append("Car:").append(System.lineSeparator());
        if (this.getCar() != null) {
            sb.append(String.format("%s %s", this.getCar().getModel(), this.getCar().getCarSpeed()))
                    .append(System.lineSeparator());

        }

       sb.append("Pokemon:").append(System.lineSeparator());
        if (this.getPokemons() != null) {
            this.getPokemons().forEach(pokemon -> sb.append(String.format("%s %s"
                            , pokemon.getName(), pokemon.getType()))
                    .append(System.lineSeparator()));

        }

        sb.append("Parents:").append(System.lineSeparator());
        if (this.getParents() != null) {
            this.getParents()
                    .forEach(parent -> sb.append(String.format("%s %s"
                                    , parent.getParentName(), parent.getParentBirthday()))
                    .append(System.lineSeparator()));
        }

        sb.append("Children:").append(System.lineSeparator());
        if (this.getChildren() != null) {
            this.getChildren().forEach(parent -> sb.append(String.format("%s %s"
                    , parent.getChildName(), parent.getChildBirthday()))
                    .append(System.lineSeparator()));
        }

        return  sb.toString();
    }

}
