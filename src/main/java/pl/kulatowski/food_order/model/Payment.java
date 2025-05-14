package pl.kulatowski.food_order.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

@Data
public class Payment {

    @CreditCardNumber(message = "To nie jest prawidłowy numer karty kredytowej")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])(/)([1-9][0-9])$", message = "Wartość musi być w formacie MM/RR.")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Nieprawidłowy kod CVV.")
    private String ccCVV;
}
