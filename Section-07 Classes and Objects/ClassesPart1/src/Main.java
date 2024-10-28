public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        car.setMake("Tata");
        car.setModel("Nano");
        car.setColor("Yellow");
        car.setDoors(2);
        System.out.println("make =" + car.getMake());
        System.out.println("model =" + car.getModel());
        car.describeCar();

        Car car1 = new Car();
        car1.setMake("Porsche");
        car1.setModel("Targa");
        car1.setColor("Blue");
        car1.setDoors(4);
        System.out.println("make =" + car1.getMake());
        System.out.println("model =" + car1.getModel());
        car1.describeCar();

    }

}
