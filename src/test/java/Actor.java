public class Actor {
    String firstname;
    String lastname;

    public Actor(String name) {
    }

    public void act(){
        System.out.println("Acting...");
    }

    public void play(){
        System.out.println("Playing...");
    }

    public Actor(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        System.out.println("Constructor called");
    }

}
