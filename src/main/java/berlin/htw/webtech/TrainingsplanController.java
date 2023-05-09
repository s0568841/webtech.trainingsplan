package berlin.htw.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @DeleteMapping("/trainingsplan/{id}")
    public Map<String, Boolean> deleteTrainingsplan(@PathVariable String id){
        Trainingsplan trainingsplan = service.get(Long.parseLong(id));
        service.delete(trainingsplan);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

/*testkommentar*/
}
