public class main {
    public static void main(String[] args) {
        Human person1 = new Human("Peter", "male", 36);
        Human person2 = new Human("Alisha", "female", 34);

        System.out.println(person1.name + ", " + person1.sex + ", " + person1.age+" years old");
        System.out.println(person2.name + ", " + person2.sex + ", " + person2.age+" years old");

    }
}
