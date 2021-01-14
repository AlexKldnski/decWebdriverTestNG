public class Cars{
    public String name;
    public int year, speed, price;

    public Cars(String name, int year, int speed, int price) {
        this.name = name;
        this.year = year;
        this.speed = speed;
        this.price = price;
    }

    public String toString(){
        String record = "Car model: " + this.name + "; " + "year: " + this.year + "; " + "top speed: "
                + this.speed + "; " + "price: " + this.price;
        return record;
    }
}
