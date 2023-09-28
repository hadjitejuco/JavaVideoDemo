public class Student {
    private String name;
    private int[] grades;

    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades.clone();
    }

    public String getName() {
        return name;
    }

    public int[] getGrades() {
        return grades.clone();
    }

    public static void main(String[] args) {
        int[] studentGrades = {90, 85, 88};
        Student student = new Student("John", studentGrades);
        
        for(int grade : student.getGrades()) {
            System.out.print(grade + " ");
        }
    }
}

