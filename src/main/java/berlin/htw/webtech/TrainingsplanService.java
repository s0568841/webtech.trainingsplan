package berlin.htw.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingsplanService {

    @Autowired
    TrainingsplanRepository repo;

    public benchPress save(benchPress benchPress){
    return repo.save(benchPress);
    }

    public benchPress get(Long id){
    return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }


    public benchPress delete(benchPress benchPress){
    repo.delete(benchPress);
    return benchPress;
    }
}
