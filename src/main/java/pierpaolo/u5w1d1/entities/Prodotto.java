package pierpaolo.u5w1d1.entities;

import lombok.*;

@Getter
public abstract class Prodotto {

    double prezzo;
    int calorie;

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
