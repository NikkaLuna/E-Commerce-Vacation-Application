package D288.demo.controllers;

import D288.demo.services.CheckoutService;
import D288.demo.services.PurchaseData;
import D288.demo.services.PurchaseResponseData;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponseData placeOrder(@RequestBody PurchaseData purchaseData) {

        PurchaseResponseData purchaseResponseData = checkoutService.placeOrder(purchaseData);

        return purchaseResponseData;
    }

}