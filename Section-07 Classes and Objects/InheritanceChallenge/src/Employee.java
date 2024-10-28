public class Employee extends  Worker{

    private long employeeId;

    private String hiredDate;

    private static int employeeNo = 1;

    public Employee(String name, String birthDate, String hiredDate) {
        super(name, birthDate);
        this.employeeId = Employee.employeeNo++;
        this.hiredDate = hiredDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", hiredDate='" + hiredDate + '\'' +
                "} " + super.toString();
    }
}
