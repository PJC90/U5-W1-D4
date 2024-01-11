package pierpaolo.u5w1d1.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Topping extends Prodotto{
    @Id
    @GeneratedValue
    private long id;

    private String nome;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

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
