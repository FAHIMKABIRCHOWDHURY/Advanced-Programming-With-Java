import java.time.LocalDate;

public class Persons {
   public String Name;
   public String Email;
   public LocalDate dob;

  public  void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }
    public String getName() {
        return Name;
    }
    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return Email;
    }

public void Show()
    {

    }
}
