package pierpaolo.u5w1d1.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pierpaolo.u5w1d1.dao.PizzaService;
import pierpaolo.u5w1d1.entities.Pizza;

@Component
public class PizzaRunner implements CommandLineRunner {
    @Autowired
    PizzaService pizzaService;
    @Override
    public void run(String... args) throws Exception {
        Pizza p = new Pizza();
        pizzaService.savePizza(p);
    }
}
