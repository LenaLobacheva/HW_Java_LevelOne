package lesson5;

 public class Employee {
    private String fullName;
    private String jobTitle;
    private String email;
    private String numberPhone;
    private int salary;
    private int age;

     public Employee(String fullName, String jobTitle, String email, String numberPhone, int salary, int age) {
         this.fullName = fullName;
         this.jobTitle = jobTitle;
         this.email = email;
         this.numberPhone = numberPhone;
         this.salary = salary;
         this.age = age;
     }

     public int getAge() {
         return age;
     }

     public void printInfo() {
        System.out.println(String.format("Данные сотрудника: ", fullName, jobTitle, email, numberPhone, salary, age));
    }

 }


