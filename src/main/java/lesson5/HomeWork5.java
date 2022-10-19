package lesson5;

public class HomeWork5 {
    public static void main(String[] args){
      Employee[] empArray = new Employee[5]; // объявили массив объектов
      empArray[0] = new Employee("Ivanov Ivan", "Engineer", "iviv@mail.ru", "89039291364", 30000, 43);
      empArray[1] = new Employee("Petrov Petr", "QA", "petrov@mail.ru", "89059291612", 27000, 30);
      empArray[2] = new Employee("Sidorov Sasha", "Designer", "sidorov@mail.ru", "89132641254", 33000, 32);
      empArray[3] = new Employee("Timofeeva Masha", "Art", "timofeeva@mail.ru", "89234587896", 33000, 25);
      empArray[4] = new Employee("Saharova Rita", "PM", "sahar@mail.ru", "899295486325", 35000, 45);

      for (Employee employee : empArray)
          if (employee.getAge() > 40) {
              System.out.println(employee);
              //employee.printInfo();
          }
    }
}
