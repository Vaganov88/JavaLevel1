public class Employee {
    public String name;
    public String post;
    public String email;
    public long phone;
    public int salary;
    public int age;

    public Employee(String name, String post, String email, long phone, int salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public void info() {
        System.out.println( "name: " + name + "; post: " + post + "; email:" + email + "; phone:" + phone +
                "; salary:" + salary + "; Возраст: " + age);
}
}//Main Task
