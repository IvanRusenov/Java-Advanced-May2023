package DefiningClassesExercises.A06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString(){

        return String.format("%s %s %d"
                , this.getName(), this.getNumberOfBadges(), this.getPokemons().size());
    }
}
