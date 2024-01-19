package D288.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="carts")

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    private Long id;

    @Column(name="order_tracking_number")
    private String orderTrackingNumber;

    @Column(name="package_price")
    private BigDecimal package_price;

    @Column(name="party_size")
    private int party_size;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private StatusType status;

    @Column(name="create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CartItem> cartItems = new HashSet<>();


    public Cart() {
    }
    //adding a cart item (CartItem) to the list of things in the cart (cartItems) and associates it with a specific cart
    public void add(CartItem cartItem) {
        cartItems.add(cartItem);
        cartItem.setCart(this);
    }

    //returns the set of cart items if not null, otherwise, returns an empty set.
    //public Set<CartItem> getCartItems() {
    //    return cartItem != null ? cartItem : Collections.emptySet();
    //}

}
