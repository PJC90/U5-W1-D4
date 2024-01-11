package pierpaolo.u5w1d1.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bevanda extends Prodotto{
    @Id
    @GeneratedValue
    private long id;
    String nome;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public Bevanda(String nome, double prezzo, int calorie) {
        super(prezzo, calorie);
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Bevanda{" +
                "nome='" + nome + '\'' +", "+
                "calorie= " + calorie + ", "+
        "prezzo= " + prezzo
                ;
    }
}
