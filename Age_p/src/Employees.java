

public class Employees extends Persons {
    public int Salary;

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public int getSalary() {
        return Salary;
    }

    @Override
    public void Show(){
        System.out.println("Name : "+this.getName());
        System.out.println("Salary: "+this.getSalary()+"BDT");
        System.out.println("Email: "+this.getEmail());
        System.out.println("Date Of Birth: "+this.getDob());

    }


}
