public class Dog {

    private String name;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    private String breed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public Dog(String n, String b, int a) {
        this.name = n;
        this.breed = b;
        this.age = a;
    }

    public static void display() {

    }
}
