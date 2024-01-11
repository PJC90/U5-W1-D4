package pierpaolo.u5w1d1.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pierpaolo.u5w1d1.entities.Pizza;

@Service
@Slf4j
public class PizzaService {
    @Autowired
    private PizzaDAO pizzaDao;
    public void savePizza(Pizza pizza){
        pizzaDao.save(pizza);
        log.info("Pizza salvata correttamente!");
    }
}
