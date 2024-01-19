package D288.demo.services;
import D288.demo.services.PurchaseResponseData;
import D288.demo.services.PurchaseData;

public interface CheckoutService {

    PurchaseResponseData placeOrder(PurchaseData purchaseData);
}
