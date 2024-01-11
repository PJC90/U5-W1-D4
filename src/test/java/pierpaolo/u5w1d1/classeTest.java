package pierpaolo.u5w1d1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pierpaolo.u5w1d1.entities.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class classeTest {
    private static AnnotationConfigApplicationContext ctx ;
    @BeforeAll
    public static void beforeAll() {
        System.out.println("BEFORE ALL");
        ctx = new AnnotationConfigApplicationContext(U5w1d1Application.class);
    }
    @Test
    public void testSum() {
        System.out.println("TEST 1 sum");
        int result = 4;
        assertEquals(4, result);
    }
    @Test
    void margheritaTest(){
        System.out.println("TEST 2 margherita");
        Pizza marg = ctx.getBean("margherita",Pizza.class);
        assertEquals(8.97, marg.getPrezzo());
    }

    @Test
    void margheritaTest2(){
        System.out.println("TEST 3 margherita");
        Prodotto marg = (Prodotto) ctx.getBean("margherita");
        assertEquals(8.97, marg.getPrezzo());
    }
    @Test
    void pomodorotest(){
        System.out.println("TEST 4 pomodoro");
        Topping t = ctx.getBean("pomodoro", Topping.class);
        assertEquals(0.99,t.getPrezzo());
    }
    @Test
    void margheritaIsNotXl(){
        System.out.println("TEST 5 is not xl");
        Pizza m = ctx.getBean("margherita", Pizza.class);
        assertFalse(m.isXl());
    }
    @Test
    void margheritaIsXl(){
        System.out.println("TEST 6 is xl");
        Pizza m = ctx.getBean("margheritaXl", Pizza.class);
        assertTrue(m.isXl());
    }
    @Test
    void costoCopertoAppProperties(){
        System.out.println("TEST 7 application properties");
        Tavolo t = ctx.getBean("tavolo_1", Tavolo.class);
        assertEquals(2.00,t.getCostoCoperto());
    }
@Test
public void testPizzaList(){
    System.out.println("TEST 7b dimensione lista Pizza");
        Menu m = ctx.getBean("menu", Menu.class);
        assertEquals(3, m.getPizzaList().size());
}
    @Test
    void ordineTest(){
        System.out.println("TEST 8 total ordine");

        Tavolo tavolo1 = (Tavolo) ctx.getBean("tavolo_1");

        List<Prodotto> prodottiOrdinati = new ArrayList<>();
        prodottiOrdinati.add(ctx.getBean("vikinga", Pizza.class));
        prodottiOrdinati.add(ctx.getBean("coca", Bevanda.class));

        Ordine o = new Ordine(4, prodottiOrdinati, tavolo1);

        assertEquals(27.939999999999998, o.getTotale());
    }
    @ParameterizedTest
    @CsvSource({"pomodoro,100","mozzarella,699","funghi, 258","salame,451"})
    void testToppingCalorie(String topping, int calorie){
        System.out.println("TEST 9 Topping calorie");
        Topping  t = ctx.getBean(topping, Topping.class);
        assertEquals(calorie, t.getCalorie());
}
@ParameterizedTest
    @CsvSource({"margherita,1799","margheritaXl,1888", "vikinga,2508"})
    void testPizzaCalorie(String pizza, int calorie){
    System.out.println("TEST 10 Pizza calorie");
    Pizza p = ctx.getBean(pizza, Pizza.class);
    assertEquals(calorie, p.getCalorie());
}
@ParameterizedTest
    @CsvSource({"pizzaList, 3", "toppingList,4", "bevandaList,1"})
    void testSizeListeMenu(String list, int size){
    System.out.println("TEST 11 size liste del menu");
        Menu m = ctx.getBean("menu", Menu.class);
        switch (list){
            case "pizzaList":
                assertEquals(size, m.getPizzaList().size());
                break;
            case "toppingList":
                assertEquals(size, m.getToppingList().size());
                break;
            case "bevandaList":
                assertEquals(size, m.getBevandaList().size());
                break;
            default:
                throw new IllegalArgumentException(list + " non è una stringa valida!");
        }
}
}
