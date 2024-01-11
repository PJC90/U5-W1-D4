package pierpaolo.u5w1d1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import pierpaolo.u5w1d1.entities.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5w1d1Application.class);
        try{
            Menu m = (Menu) ctx.getBean("menu");
            m.printMenu();

            Tavolo tavolo1 = (Tavolo) ctx.getBean("tavolo_1");

            List<Prodotto> prodottiOrdinati = new ArrayList<>();
            prodottiOrdinati.add(ctx.getBean("vikinga", Pizza.class));
            prodottiOrdinati.add(ctx.getBean("coca", Bevanda.class));

            Ordine ordine1 = new Ordine(4, prodottiOrdinati, tavolo1);
            System.out.println(ordine1);
            System.err.println("Conto: " + ordine1.getTotale());
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        } finally {
            ctx.close();
        }


    }
}
