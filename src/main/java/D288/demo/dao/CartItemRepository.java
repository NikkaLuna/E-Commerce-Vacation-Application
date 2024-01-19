package D288.demo.dao;


import D288.demo.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "cartItems", path = "cartItems")
public interface CartItemRepository extends JpaRepository<CartItem, Long> {


}
