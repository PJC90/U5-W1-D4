package pierpaolo.u5w1d1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Tavolo {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private int numTavolo;
    @NonNull
    private int maxCoperti;
    @NonNull
    private TavoloStato stato;
    @NonNull
    private double costoCoperto;

    @OneToMany(mappedBy = "tavolo")
    private List<Ordine> ordini;
}
