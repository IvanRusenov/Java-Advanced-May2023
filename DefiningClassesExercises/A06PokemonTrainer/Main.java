package DefiningClassesExercises.A06PokemonTrainer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!input.equals("Tournament")){
            //"{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}"

            String[] data = input.split("\\s+");

            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).getPokemons().add(pokemon);

            input = scan.nextLine();

        }

        input = scan.nextLine();
        while (!input.equals("End")){



            for (Trainer trainer : trainers.values()) {
                boolean isMatch = false;
                for (Pokemon pokemon : trainer.getPokemons()) {
                    if (pokemon.getElement().equals(input)){
                        isMatch = true;
                        break;
                    }
                }

                if (isMatch){
                    trainer.setNumberOfBadges(trainer.getNumberOfBadges()+1);
                }else {

                    for (int i = 0; i < trainer.getPokemons().size(); i++) {
                        trainer.getPokemons().get(i).setHealth(trainer.getPokemons().get(i).getHealth() - 10);
                        if (trainer.getPokemons().get(i).getHealth() <= 0){
                            trainer.getPokemons().remove(i);
                            i--;
                        }
                    }


                }

            }


            input = scan.nextLine();
        }


        trainers.values().stream()
                .sorted((f,s) -> Integer.compare(s.getNumberOfBadges(), f.getNumberOfBadges()))
                .forEach(trainer -> System.out.println(trainer.toString()));

    }
}
