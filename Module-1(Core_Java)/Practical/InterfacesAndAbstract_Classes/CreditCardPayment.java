// PaymentGateway interface
interface PaymentGateway {
    void processPayment(double amount);
    void generateReceipt();
}

// Implementation of PaymentGateway for a credit card payment
class CreditCardPayment implements PaymentGateway {
    private String cardNumber;

    CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount + " for card number " + cardNumber);
    }

    @Override
    public void generateReceipt() {
        System.out.println("Generating receipt for credit card payment.");
    }

    public static void main(String[] args) {
        PaymentGateway payment = new CreditCardPayment("1234-5678-9876-5432");
        payment.processPayment(250.75);
        payment.generateReceipt();
    }
}
