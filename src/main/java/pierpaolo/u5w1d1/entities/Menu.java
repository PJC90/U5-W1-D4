package pierpaolo.u5w1d1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private List<Pizza> pizzaList;
    @NonNull
    private List<Bevanda> bevandaList;
    @NonNull
    private List<Topping> toppingList;
    public void printMenu(){
        System.out.println("Menu   ");
        if(this.pizzaList.size() == 1) {
            System.out.println("Pizza:   ");
        } else if (this.pizzaList.size() > 1) {
            System.out.println("Pizze:  ");
        }
        this.pizzaList.forEach(System.out::println);

        System.out.println("Topping:   ");
        this.toppingList.forEach(System.out::println);

        System.out.println("Drink:   ");
        this.bevandaList.forEach(System.out::println);

    }
}
