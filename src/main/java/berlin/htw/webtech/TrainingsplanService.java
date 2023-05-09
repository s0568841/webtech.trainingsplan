package berlin.htw.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingsplanService {

    @Autowired
    TrainingsplanRepository repo;

    public Trainingsplan save(Trainingsplan trainingsplan){
    return repo.save(trainingsplan);
    }

    public Trainingsplan get(Long id){
    return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
