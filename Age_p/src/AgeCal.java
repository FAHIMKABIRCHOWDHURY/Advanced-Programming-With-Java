import java.time.LocalDate;
import java.time.Period;

public class AgeCal <P extends Persons >{
    public P persons;
    public AgeCal(P person){
        this.persons=person;
    }
 public String CalAge() {
     LocalDate today = LocalDate.now();
     Period p= Period.between(persons.getDob(),today);
     return "You are "+p.getYears()+"Years "+p.getMonths()+"Months and "+p.getDays()+"Days Old";
 }

}
