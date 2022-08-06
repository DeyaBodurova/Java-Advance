package Exam.workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Workout {
    public List<Exercise> exercises;
    public String type;
    public int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < this.exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return exercises.removeIf(exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle));
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (name.equals(exercise.getName()) && muscle.equals(exercise.getMuscle())) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        if (!exercises.isEmpty()) {
            return Collections.max(exercises, Comparator.comparing(Exercise::getBurnedCalories));
        } else {
            return null;
        }
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s\n", this.type));
        for (Exercise exercise : exercises) {
            sb.append(String.format("%s%n", exercise.toString()));
        }
        return sb.toString();
    }

    public int getExerciseCount() {
        return exercises.size();
    }

}


