package pierpaolo.u5w1d1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pierpaolo.u5w1d1.entities.Bevanda;

@Repository
public interface BevandaDAO extends JpaRepository<Bevanda, Long> {
}
