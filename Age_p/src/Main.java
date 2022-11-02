import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Persons[] persons=new Persons[5];
        Employees p1= new Employees();
        p1.setName("Fahim Kabir");
        p1.setEmail("fahim.kabir@gmail.com");
        p1.setSalary(20000);
        p1.setDob(LocalDate.of(2000,1,1));
        persons[0]=p1;

        Students p2= new Students();
        p2.setName("Fahim Kabir");
        p2.setEmail("fahim.kabir@gmail.com");
        p2.setId("20-42595-1");
        p2.setDob(LocalDate.of(2001,2,2));
        persons[1]=p2;
for(Persons i:persons)
{
    i.Show();
    AgeCal age = new AgeCal<>(i);
    System.out.println(age.CalAge());
}


    }
}