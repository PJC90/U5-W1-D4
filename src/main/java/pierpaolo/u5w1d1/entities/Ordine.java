package pierpaolo.u5w1d1.entities;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;

@Getter
@ToString
public class Ordine {
    private int numOrdine;
    private OrdineStato stato;
    private int  numCoperti;
    private LocalTime ora;
    private List<Prodotto> prodottiOrdinati;
    private Tavolo tavolo;
//    @Value("${costo.coperto}")
//    private double costoCoperto;

    public Ordine(int numCoperti, List<Prodotto> prodottiOrdinati, Tavolo tavolo) {
        this.numCoperti = numCoperti;
        this.prodottiOrdinati = prodottiOrdinati;
        this.tavolo = tavolo;
        this.stato = OrdineStato.IN_CORSO;
        this.ora = LocalTime.now();
        Random rm = new Random();
        this.numOrdine = rm.nextInt();
    }
    public double getTotale(){
        return this.prodottiOrdinati.stream().mapToDouble(Prodotto::getPrezzo).sum()+ this.numCoperti * this.tavolo.getCostoCoperto();
    }
//    public double getCostoCoperto(){
//        return this.numCoperti * this.costoCoperto;
//    }
}
