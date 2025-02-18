// 1. Interfaccia PaymentStrategy con il metodo pay()
interface PaymentStrategy {
    void pay(double amount);
    }

    // 2. Implementazioni dell'interfaccia per diversi metodi di pagamento

    // Pagamento con carta di credito
    class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;

            public CreditCardPayment(String cardNumber) {
                    this.cardNumber = cardNumber;
                        }

                            @Override
                                public void pay(double amount) {
                                        System.out.println("Pagato " + amount + "€ con carta di credito: " + cardNumber);
                                            }
                                            }

                                            // Pagamento con PayPal
                                            class PayPalPayment implements PaymentStrategy {
                                                private String email;

                                                    public PayPalPayment(String email) {
                                                            this.email = email;
                                                                }

                                                                    @Override
                                                                        public void pay(double amount) {
                                                                                System.out.println("Pagato " + amount + "€ con PayPal: " + email);
                                                                                    }
                                                                                    }

                                                                                    // Pagamento con bonifico bancario
                                                                                    class BankTransferPayment implements PaymentStrategy {
                                                                                        private String iban;

                                                                                            public BankTransferPayment(String iban) {
                                                                                                    this.iban = iban;
                                                                                                        }

                                                                                                            @Override
                                                                                                                public void pay(double amount) {
                                                                                                                        System.out.println("Pagato " + amount + "€ con bonifico bancario IBAN: " + iban);
                                                                                                                            }
                                                                                                                            }

                                                                                                                            // 3. Classe ShoppingCart che usa PaymentStrategy per eseguire il pagamento
                                                                                                                            class ShoppingCart {
                                                                                                                                private PaymentStrategy paymentStrategy;

                                                                                                                                    // Metodo per impostare la strategia di pagamento
                                                                                                                                        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
                                                                                                                                                this.paymentStrategy = paymentStrategy;
                                                                                                                                                    }

                                                                                                                                                        // Metodo per effettuare il pagamento
                                                                                                                                                            public void checkout(double amount) {
                                                                                                                                                                    if (paymentStrategy == null) {
                                                                                                                                                                                System.out.println("Nessun metodo di pagamento selezionato!");
                                                                                                                                                                                        } else {
                                                                                                                                                                                                    paymentStrategy.pay(amount);
                                                                                                                                                                                                            }
                                                                                                                                                                                                                }
                                                                                                                                                                                                                }

                                                                                                                                                                                                                // 4. Classe principale per testare il codice
                                                                                                                                                                                                                public class PaymentApp {
                                                                                                                                                                                                                    public static void main(String[] args) {
                                                                                                                                                                                                                            ShoppingCart cart = new ShoppingCart();

                                                                                                                                                                                                                                    // Scelta del metodo di pagamento
                                                                                                                                                                                                                                            PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9876-5432");
                                                                                                                                                                                                                                                    PaymentStrategy paypal = new PayPalPayment("utente@email.com");
                                                                                                                                                                                                                                                            PaymentStrategy bankTransfer = new BankTransferPayment("IT60X0542811101000000123456");

                                                                                                                                                                                                                                                                    // Eseguiamo pagamenti con metodi diversi
                                                                                                                                                                                                                                                                            cart.setPaymentStrategy(creditCard);
                                                                                                                                                                                                                                                                                    cart.checkout(100.50);

                                                                                                                                                                                                                                                                                            cart.setPaymentStrategy(paypal);
                                                                                                                                                                                                                                                                                                    cart.checkout(200.00);

                                                                                                                                                                                                                                                                                                            cart.setPaymentStrategy(bankTransfer);
                                                                                                                                                                                                                                                                                                                    cart.checkout(350.75);
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                        }
