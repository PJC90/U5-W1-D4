package pierpaolo.u5w1d1.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pierpaolo.u5w1d1.entities.Bevanda;

import java.util.List;

@Service
@Slf4j
public class BevandaService {
    @Autowired
    private BevandaDAO bevandaDao;
    public void saveBevanda(Bevanda bevanda){
        bevandaDao.save(bevanda);
        log.info("Bevanda salvata correttamente!");
    }
//    public List<Bevanda> filterBySurname(String surname) {
//
//        return BevandaDAO.findBySurname(surname);
//    }
}
