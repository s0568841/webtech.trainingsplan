package berlin.htw.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingsplanService {

    @Autowired
    TrainingsplanRepository repo;

    public Exercise save(Exercise Exercise){
    return repo.save(Exercise);
    }

    public Exercise get(Long id){
    return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }


    public Exercise delete(Exercise Exercise){
    repo.delete(Exercise);
    return Exercise;
    }
}
