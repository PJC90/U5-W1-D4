package pierpaolo.u5w1d1;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import pierpaolo.u5w1d1.entities.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class BeansConfig {
    @Bean
    public Topping pomodoro(){return new Topping(0.99, 100,"Pomodoro");}
    @Bean
    public Topping mozzarella(){return new Topping(2.99, 699,"Mozzarella");}
    @Bean
    public Topping funghi(){return new Topping(5.99,258, "Funghi");}
    @Bean
    public Topping salame(){return new Topping(1.99,451, "Salame");}
    @Bean
    public Pizza margherita(){
        List<Topping> tList = new ArrayList<>();
        tList.add(pomodoro());
        tList.add(mozzarella());
        return new Pizza("Margherita", tList, false);
    }
    @Bean
//    @Bean(name="MARG_XL")
    public Pizza margheritaXl(){
        List<Topping> tList = new ArrayList<>();
        tList.add(pomodoro());
        tList.add(mozzarella());
        return new Pizza("Margherita XL", tList, true);
    }
    @Bean
    public Pizza vikinga(){
        List<Topping> tList = new ArrayList<>();
        tList.add(pomodoro());
        tList.add(mozzarella());
        tList.add(funghi());
        tList.add(salame());
        return new Pizza("Vikinga", tList, false);
    }
    @Bean
    public Bevanda coca(){return new Bevanda("Coca cola",2.99,456);}
    @Bean
    public Menu menu(){
        List<Pizza> pizzaList = new ArrayList<>();
        List<Topping> toppingList = new ArrayList<>();
        List<Bevanda> bevandaList = new ArrayList<>();

        pizzaList.add(margherita());
        pizzaList.add(margheritaXl());
        pizzaList.add(vikinga());

        bevandaList.add(coca());

        toppingList.add(pomodoro());
        toppingList.add(mozzarella());
        toppingList.add(funghi());
        toppingList.add(salame());

        return new Menu(pizzaList, bevandaList, toppingList);
    }
    @Bean("tavolo_1")
    public Tavolo getTavolo1(@Value("${costo.coperto}") double costoCoperto){return new Tavolo(1,5,TavoloStato.LIBERO, costoCoperto);}
    //Quando usi @Value non dimenticarti  ------->  @PropertySource("application.properties")
    @Bean("tavolo_2")
    public Tavolo getTavolo2(@Value("${costo.coperto}")double costoCoperto){return new Tavolo(2,4,TavoloStato.LIBERO, costoCoperto);}
}
