package berlin.htw.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrainingsplanController {

    @Autowired
    TrainingsplanService service;

    @PostMapping("/trainingsplan")
    public Trainingsplan createTrainingsplan (@RequestBody Trainingsplan trainingsplan){
        return service.save(trainingsplan);
    }

    @GetMapping("/trainingsplan/{id}")
    public Trainingsplan getTrainingsplan (@PathVariable String id){
        Long trainingsplanId = Long.parseLong(id);
        return service.get(trainingsplanId);
    }

    @PutMapping("/trainingsplan/{id}")
    public Trainingsplan updateTrainingsplan (@PathVariable String id, @RequestBody Trainingsplan trainingsplan){
        Trainingsplan updateTrainingsplan = service.get(Long.parseLong(id));

        updateTrainingsplan.setExercise(trainingsplan.getExercise());
        updateTrainingsplan.setRepetitions(trainingsplan.getRepetitions());
        updateTrainingsplan.setWeight(trainingsplan.getWeight());

        service.save(updateTrainingsplan);
        return updateTrainingsplan;
    }

/*testkommentar*/
}
