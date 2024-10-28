public class ClassesChallenge {

    public static void main(String[] args) {


       // Account bobsAccount = new Account("12345", 1000.00, "Bob Brown", "myemail@bob.com", "(087) 123-4567");

        Account bobsAccount = new Account();

        //bobsAccount.setNumber("12345");
        //bobsAccount.setBalance(1000.00);
        //bobsAccount.setCustomerName("Bob Brown");
        //bobsAccount.setCustomerEmail("myemail@bob.com");
        //bobsAccount.setCustomerPhone("(123) 456-789");

        bobsAccount.withdrawFunds(100);
        bobsAccount.depositFunds(250);
        bobsAccount.withdrawFunds(100);

        bobsAccount.withdrawFunds(200);

        bobsAccount.depositFunds(100);
        bobsAccount.withdrawFunds(45.55);
        bobsAccount.withdrawFunds(54.46);

        bobsAccount.withdrawFunds(54.45);

        Account jonAccount = new Account("Jon", "jon@email.com", "12345");
        System.out.println("Account no:" + jonAccount.getNumber() + " name: " + jonAccount.getCustomerName());
    }
}
