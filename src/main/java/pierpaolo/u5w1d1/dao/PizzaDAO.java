package pierpaolo.u5w1d1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pierpaolo.u5w1d1.entities.Pizza;

@Repository
public interface PizzaDAO extends JpaRepository<Pizza, Long> {
}
