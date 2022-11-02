public class Students extends Persons {
    public String Id;

    public void setId(String id) {
        Id = id;
    }

    public String getId() {
        return Id;
    }

    @Override
    public void Show(){
        System.out.println("Name : "+this.getName());
        System.out.println("Id: "+this.getId());
        System.out.println("Email: "+this.getEmail());
        System.out.println("Date Of Birth: "+this.getDob());

    }
}
