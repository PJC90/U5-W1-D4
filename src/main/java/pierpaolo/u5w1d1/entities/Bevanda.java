package pierpaolo.u5w1d1.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Bevanda extends Prodotto{
    String nome;


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
