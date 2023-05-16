package berlin.htw.webtech;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String exerciseName;
    private int weight;
    private int repetitions;
    private LocalTime exerciseTime;
    private LocalDate exerciseDate;
    private FitnessCategory myFitnessCategory;
    enum FitnessCategory{
        MACHINE_WORKOUT,
        FREE_WEIGHT,
        BODY_WEIGHT,
        GENERAL_FITNESS
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public LocalDate getExerciseDate() {
        return exerciseDate;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public LocalTime getExerciseTime() {
        return exerciseTime;
    }

    public void setExerciseTime(LocalTime exerciseTime) {
        this.exerciseTime = exerciseTime;
    }

    public void setExerciseDate(LocalDate benchPressDate) {
        this.exerciseDate = benchPressDate;

    }

    public FitnessCategory getMyFitnessCategory() {
        return myFitnessCategory;
    }

    public void setMyFitnessCategory(FitnessCategory myFitnessCategory) {
        this.myFitnessCategory = myFitnessCategory;
    }
}
