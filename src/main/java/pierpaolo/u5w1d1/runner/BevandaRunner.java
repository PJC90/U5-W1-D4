package pierpaolo.u5w1d1.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pierpaolo.u5w1d1.dao.BevandaService;
import pierpaolo.u5w1d1.entities.Bevanda;

@Component
public class BevandaRunner implements CommandLineRunner {
    @Autowired
    BevandaService bevandaService;

    @Override
    public void run(String... args) throws Exception {
        Bevanda b = new Bevanda("Acqua",2.5,8);
        bevandaService.saveBevanda(b);
    }
}
