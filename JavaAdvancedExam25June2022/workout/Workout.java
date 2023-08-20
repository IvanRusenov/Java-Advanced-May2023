package workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {

    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise){
        if (exercises.size() < exerciseCount){
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle){
        for (Exercise exercise : exercises) {
            if(exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)){
                exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle){
        for (Exercise exercise : exercises) {
            if(exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)){
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise(){
        return exercises.stream().min((f, s) -> Integer.compare(s.getBurnedCalories(), f.getBurnedCalories())).orElse(null);
    }

    public int getExerciseCount(){
        return exercises.size();
    }

    public String getStatistics(){

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Workout type: %s", type))
                .append(System.lineSeparator());
                exercises.forEach(e-> sb.append(e.toString()).append(System.lineSeparator()));


                return sb.toString();

    }
}
