package berlin.htw.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TrainingsplanController {

    @Autowired
    TrainingsplanService service;

    @PostMapping("/bench_press")
    public benchPress createBenchPress (@RequestBody benchPress benchPress){
        return service.save(benchPress);
    }

    @GetMapping("/bench_press/{id}")
    public benchPress getBenchPress (@PathVariable String id){
        Long trainingsplanId = Long.parseLong(id);
        return service.get(trainingsplanId);
    }

    @PutMapping("/bench_press/{id}")
    public benchPress updateBenchPress (@PathVariable String id, @RequestBody benchPress benchPress){
        benchPress updateBenchPress = service.get(Long.parseLong(id));

        updateBenchPress.setRepetitions(benchPress.getRepetitions());
        updateBenchPress.setWeight(benchPress.getWeight());
        updateBenchPress.setBenchPressDate(benchPress.getBenchPressDate());

        service.save(updateBenchPress);
        return updateBenchPress;
    }

    @DeleteMapping("/bench_press/{id}")
    public Map<String, Boolean> deleteTrainingsplan(@PathVariable String id){
        benchPress benchPress = service.get(Long.parseLong(id));
        service.delete(benchPress);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

/*testkommentar*/
}
