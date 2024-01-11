package pierpaolo.u5w1d1.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Tavolo {
    private int numTavolo;
    private int maxCoperti;
    private TavoloStato stato;
    private double costoCoperto;
}
