package pierpaolo.u5w1d1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pierpaolo.u5w1d1.entities.Bevanda;

import java.util.List;

@Repository
public interface BevandaDAO extends JpaRepository<Bevanda, Long> {


//    List<Bevanda> findBySurname(String surname); // equivalente a fare SELECT u FROM User u WHERE u.surname=:surname
}
