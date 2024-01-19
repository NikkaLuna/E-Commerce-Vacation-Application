package D288.demo.services;

import D288.demo.dao.CartRepository;
import D288.demo.dao.CustomerRepository;
import D288.demo.entities.Cart;
import D288.demo.entities.CartItem;
import D288.demo.entities.Customer;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import D288.demo.entities.StatusType;


import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    private CartRepository cartRepository;

    // allows these repositories to be injected into the service
    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }


    @Transactional
    public PurchaseResponseData placeOrder(PurchaseData purchaseData) {

        // retrieve the order info from dto
        Cart cart = purchaseData.getCart();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // populate cart with cartItems
        Set<CartItem> cartItems = purchaseData.getCartItems();
        // check if the cart is empty
        if (cartItems.isEmpty()) {
            return new PurchaseResponseData("Cart Empty");
        }

        //cartItems.forEach(item -> cart.add(item));
        cartItems.forEach(cart::add);

        // Set the status based on your logic
        StatusType statusType = determineStatusType();
        cart.setStatus(statusType);


        // populate customer with order
        Customer customer = purchaseData.getCustomer();
        cart.setCustomer(customer);
        //customer.add(cart);

        // save to the database
        cartRepository.save(cart);

        // return a response
        return new PurchaseResponseData(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }

    private StatusType determineStatusType() {

        return StatusType.ordered;
    }

}

