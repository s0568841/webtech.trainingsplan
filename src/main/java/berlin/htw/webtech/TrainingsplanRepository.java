package berlin.htw.webtech;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingsplanRepository extends CrudRepository<Trainingsplan, Long> {

}
