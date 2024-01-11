package pierpaolo.u5w1d1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany(mappedBy = "menu")
    private List<Pizza> pizzaList;
    @OneToMany(mappedBy = "menu")
    private List<Bevanda> bevandaList;
    @OneToMany(mappedBy = "menu")
    private List<Topping> toppingList;

    public Menu(List<Pizza> pizzaList, List<Bevanda> bevandaList, List<Topping> toppingList) {
        this.pizzaList = pizzaList;
        this.bevandaList = bevandaList;
        this.toppingList = toppingList;
    }

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
