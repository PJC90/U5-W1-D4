package pierpaolo.u5w1d1.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Topping extends Prodotto{
    private String nome;

    public Topping(double prezzo, int calorie, String nome) {
        super(prezzo, calorie);
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                ", calorie=" + calorie +
                "} ";
    }
}
