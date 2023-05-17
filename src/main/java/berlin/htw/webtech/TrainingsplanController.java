package berlin.htw.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TrainingsplanController {

    @Autowired
    TrainingsplanService service;

    @PostMapping("/Exercise")
    public Exercise createExercise (@RequestBody Exercise Exercise){
        return service.save(Exercise);
    }

    @GetMapping("/Exercise/{id}")
    public Exercise getExercise (@PathVariable String id){
        Long trainingsplanId = Long.parseLong(id);
        return service.get(trainingsplanId);
    }

    @PutMapping("/Exercise/{id}")
    public Exercise updateExercise (@PathVariable String id, @RequestBody Exercise Exercise){
        Exercise updateExercise = service.get(Long.parseLong(id));

        updateExercise.setExerciseName(Exercise.getExerciseName());
        updateExercise.setRepetitions(Exercise.getRepetitions());
        updateExercise.setWeight(Exercise.getWeight());
        updateExercise.setExerciseTime(Exercise.getExerciseTime());
        updateExercise.setExerciseDate(Exercise.getExerciseDate());
        updateExercise.setMyFitnessCategory(Exercise.getMyFitnessCategory());

        service.save(updateExercise);
        return updateExercise;
    }

    @PatchMapping("/Exercise/{id}")
    public Exercise updateExercisePartially (@PathVariable String id, @PathVariable String exerciseName,
                                             @PathVariable int weight, @PathVariable int repititions, @PathVariable Exercise.FitnessCategory myFitnessCat){
        Exercise updateExercisePartially = service.get(Long.parseLong(id));

        updateExercisePartially.setExerciseName(exerciseName);
        updateExercisePartially.setWeight(weight);
        updateExercisePartially.setRepetitions(repititions);
        updateExercisePartially.setMyFitnessCategory(myFitnessCat);

        service.save(updateExercisePartially);
        return updateExercisePartially;
    }

    @DeleteMapping("/Exercise/{id}")
    public Map<String, Boolean> deleteTrainingsplan(@PathVariable String id){
        Exercise Exercise = service.get(Long.parseLong(id));
        service.delete(Exercise);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

/*testkommentar*/
}
