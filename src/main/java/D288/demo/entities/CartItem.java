package D288.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "cart_items")
public class CartItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_item_id", nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    private Vacation vacation;



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "excursion_cartitem",
            joinColumns = @JoinColumn(name = "cart_item_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id"))//primary key
    private Set<Excursion> excursions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    //Establishing a ManyToOne mapping between CartItem and Vacation.
    //@OneToMany(mappedBy = "cart_items", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private Set<Vacation> vacations;

    public CartItem() {

    }
}
