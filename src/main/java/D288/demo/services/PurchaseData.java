package D288.demo.services;
import D288.demo.entities.Cart;
import D288.demo.entities.CartItem;
import D288.demo.entities.Customer;
import jakarta.persistence.criteria.Order;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseData {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

    public Order getOrder() {
        return null;
    }
}
