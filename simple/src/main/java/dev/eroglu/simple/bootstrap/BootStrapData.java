package dev.eroglu.simple.bootstrap;

import dev.eroglu.simple.domain.Customer;
import dev.eroglu.simple.repositories.CustomerRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRespository customerRespository;

    public BootStrapData(CustomerRespository customerRespository) {
        this.customerRespository = customerRespository;
    }

    @Override
    public void run(String... args) throws Exception {
        Customer c1 = new Customer();
        c1.setName("Ege");
        c1.setSurName("Eroglu");
        customerRespository.save(c1);

        Customer c2 = new Customer();
        c2.setName("Rifat");
        c2.setSurName("Ilgaz");
        customerRespository.save(c2);

        Customer c3 = new Customer();
        c3.setName("Umut");
        c3.setSurName("Bayram");
        customerRespository.save(c3);

        System.out.println("Customers Saved: " + customerRespository.count());
    }
}
