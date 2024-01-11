package pierpaolo.u5w1d1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_prodotto", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor
public abstract class Prodotto {
    @Id
    @GeneratedValue
    private long id;
    double prezzo;
    int calorie;

    @ManyToMany(mappedBy = "prodottiOrdinati")
    private List<Ordine> ordini;

    public Prodotto(double prezzo, int calorie) {
        this.prezzo = prezzo;
        this.calorie = calorie;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "prezzo=" + prezzo +
                ", calorie=" + calorie +
                '}';
    }
}
