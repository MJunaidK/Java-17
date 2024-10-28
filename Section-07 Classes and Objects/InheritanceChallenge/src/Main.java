public class Main {

    public static void main(String[] args) {

        Employee junaid = new Employee("Junaid", "11/11/1900", "01/01/2020");
        System.out.println(junaid);
        System.out.println("Age = " + junaid.getAge());
        System.out.println("Pay = " + junaid.collectPay());


        SalariedEmployee khan = new SalariedEmployee("Khan", "11/11/1990", "02/02/2022", 3000);
        System.out.println(khan);
        System.out.println("Khan's paycheck = $" + khan.collectPay());

        khan.retire();
        System.out.println("Joe's pension check = $" + khan.collectPay());

        HourlyEmployee mjk = new HourlyEmployee("MJK", "11/11/1990", "02/02/2022", 120);        System.out.println(mjk);
        System.out.println("MJK's paycheck = $" + mjk.collectPay());
        System.out.println("MJK's Holiday Pay = $" + mjk.getDoublePay());
    }
}
