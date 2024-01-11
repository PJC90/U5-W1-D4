package pierpaolo.u5w1d1.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Getter
public class Pizza extends Prodotto{
    private String nome;
    private List<Topping> toppings;
    private boolean isXl = false;

    public Pizza(String nome, List<Topping> toppings, boolean isXl) {
        super(4.99,1032);
        this.nome = nome;
        this.toppings = toppings;
        this.calorie = setCalorie(toppings, isXl);
        this.prezzo = setPrezzo(toppings, isXl);
        this.isXl = isXl;
    }
    public int setCalorie(List<Topping> toppings, boolean isXl){
        int tot = 1000;
        if(toppings != null){
            for(int i = 0; i< toppings.size(); i++){
                tot += toppings.get(i).getCalorie();
            }
        }
        if (isXl) return (tot += (tot * 5) / 100);
        return tot;
    }
    public double setPrezzo(List<Topping> toppings, boolean isXl){
        double tot = 4.99;
        if(toppings != null){
            for(int i = 0; i<toppings.size(); i++){
                tot += toppings.get(i).getPrezzo();
            }
        }
        if (isXl) return tot += (tot * 10) / 100;
        return tot;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "nome='" + nome + '\'' +
                ", Calorie=" + calorie +
                ", Prezzo=" + prezzo +
                "," + toppings +
                ", isXl=" + isXl +
                "} " ;
    }
}
