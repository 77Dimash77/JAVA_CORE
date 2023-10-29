package dz5;

import java.util.*;
import java.util.stream.Collectors;

public class Final {
    public static void main(String[] args) {
        Students students = new Students();
        //Computer Science(Информатика) топ учеников c использование Stream API
        students.findTopStudents();
        //Инфо по группе
       students.showStudentsInfo();
        //Инфо по студенту
       students.GetInfoStud(0,students);
    }
}
class Student {
    private String name;
    private List<Double> grades;
    private String specialty;
    public double getAverageGrade() {
        return grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
    public Student(String name, List<Double> grades, String specialty){
        this.name = name;
        this.grades = grades;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public String getSpecialty() {
        return specialty;
    }
}
class Grades{
    List<Double> grades = new ArrayList<>();
    Random random = new Random();
    List<Double> filing() {
        grades = random.ints(10, 0, 9)
                .mapToDouble(Double::valueOf)
                .boxed()
                .collect(Collectors.toList());
        return grades;
    }
}
class Speciality{
    private String spesilaty;
    Speciality(){
        Map<Integer, String> specializations = new HashMap<>();
        specializations.put(1, "Computer Science");
        specializations.put(2, "Medicine");
        specializations.put(3, "Engineering");
        specializations.put(4, "Finance");
        specializations.put(5, "Environmental Science");
    Random random = new Random();
    int numSpec = random.nextInt(5) + 1;
    spesilaty = specializations.get(numSpec);
    }
    public String getSpesilaty() {
         new Speciality();
        return spesilaty;
    }
}
class Students{
   private   List<Student> group = new ArrayList<>();
    Students(){{
        Student a = new Student("Dima", new Grades().filing(), new Speciality().getSpesilaty());
        Student b = new Student("Vova", new Grades().filing(), new Speciality().getSpesilaty());
        Student c = new Student("Ivan", new Grades().filing(), new Speciality().getSpesilaty());
        Student d = new Student("Max", new Grades().filing(), new Speciality().getSpesilaty());
        group.add(a);
        group.add(b);
        group.add(c);
        group.add(d);
    }
    }
    public List<Student> getGroup() {
        return group;
    }
    public void showStudentsInfo() {
        for (Student student : group) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Specialty: " + student.getSpecialty());
            System.out.println("Grades: " + student.getGrades());
            System.out.println();
        }
    }
    public void GetInfoStud(int index,Students students ){
        Student student = students.getGroup().get(index);
        System.out.println("Info about the first student:");
        System.out.println("Name: " + student.getName());
        System.out.println("Specialty: " + student.getSpecialty());
        System.out.println("Grades: " + student.getGrades());
        System.out.println("Average Grade: " + student.getAverageGrade());

    }
    public void findTopStudents() {
        List<Student> topStudents = group.stream()
                .filter(student -> student.getSpecialty().equals("Computer Science"))
                .filter(student -> student.getAverageGrade() > 4.5)
                .sorted(Comparator.comparingDouble(Student::getAverageGrade).reversed())
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("Top Students in Computer Science:");
        for (Student student : topStudents) {
            System.out.println("Name: " + student.getName());
            System.out.println("Specialty: " + student.getSpecialty());
            System.out.println("Grades: " + student.getGrades());
            System.out.println("Average Grade: " + student.getAverageGrade());
            System.out.println();
        }
    }

}
