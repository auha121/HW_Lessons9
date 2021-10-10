import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tatyana", Arrays.asList(new Course("Math"), new Course("Language"),
                new Course("Astronomy"))));
        students.add(new Student("Liza", Arrays.asList(new Course("History"), new Course("Math"),
                new Course("Geometry"), new Course("Geography"))));
        students.add(new Student("Vladimir", Arrays.asList(new Course("Language"), new Course("Biology"),
                new Course("Programming"), new Course("Philosophy"), new Course("Testing"))));
        students.add(new Student("Vsevolod", Arrays.asList(new Course("Math"), new Course("History"), new Course("Programming"))));

        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(f -> f.stream())
                .collect(Collectors.toSet()));
        System.out.println();

        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));
        System.out.println();

        Course course = new Course("Math");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                /*.map(s -> s.getCourses())
                .flatMap(w -> w.stream())
                .map(w -> w.getName())
                .distinct()*/
                .collect(Collectors.toList()));
    }
}
