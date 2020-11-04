package homework;

class Person {
    private String phone;
    private String email;
    private String stuff;
    private long salary;
    private int age;

    public Person(String phone, String email, String stuff, long salary, int age) {
        this.phone = phone;
        this.email = email;
        this.stuff = stuff;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Email: "+email+
                " Phone: "+phone+
                " Stuff: "+stuff+
                " Salary: "+ salary+
                " Age: "+ age;
    }

    public void info(){
        System.out.printf("Email: %s Phone: %s Stuff: %s Salary: %d Age: %d\n", email, phone, stuff, salary, age);
    }
}
