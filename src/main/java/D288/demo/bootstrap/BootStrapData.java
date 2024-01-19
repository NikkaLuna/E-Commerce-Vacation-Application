
package D288.demo.bootstrap;

import D288.demo.dao.CustomerRepository;
import D288.demo.dao.DivisionRepository;
import D288.demo.entities.Customer;

import D288.demo.entities.Division;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;

    private boolean sampleCustomersCreated = false;
    private final DivisionRepository divisionRepository;
    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override

    public void run(String... args) throws Exception {
        List<Customer> customersToSave = new ArrayList<>();

        List<Customer> customers = customerRepository.findAll();
        if(customers.size() < 6) {
            Division division = divisionRepository.findById(2L).get();
            Customer customer1 = new Customer("Jack", "Black", "123 Meadow St", "12333", "555-222-4567", division);
            Customer customer2 = new Customer("Mia", "James", "129 Lark Ln", "99877", "545-222-4447", division);
            Customer customer3 = new Customer("Micky", "Lewis", "89 Jamison Ln", "36787", "676-222-7847", division);
            Customer customer4 = new Customer("Kelly", "Walker", "900 Hermosa Dr", "11447", "580-222-2227", division);
            Customer customer5 = new Customer("Jimmy", "Booker", "177 Mariposa Dr", "55557", "737-232-9847", division);

            customersToSave.add(customer1);
            customersToSave.add(customer2);
            customersToSave.add(customer3);
            customersToSave.add(customer4);
            customersToSave.add(customer5);

            customerRepository.saveAll(customersToSave);
        }

    }

}


