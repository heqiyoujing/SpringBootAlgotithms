package spring.boot.com.数据结构.双链表;


/**
 * @author: yiqq
 * @date: 2019/7/20
 * @description:
 */
public class DoubleLinkTest {
    public static void main(String[] args) {
        testInteger();
        testString();
        testStudent();
    }

    //操作int
    private static void testInteger() {
        int[] arr = {10, 20, 30, 40};
        DoubleLink<Integer> link = new DoubleLink<Integer>();
        link.insert(0, 20);
        link.appendLast(10);
        link.insertFirst(30);
        for(int i=0;i<link.size();i++) {
            System.out.println(link.get(i));
        }
    }
    //操作字符串
    private static void testString() {
        String[] sarr = {"ten", "twenty", "thirty", "forty"};
        DoubleLink<String> link = new DoubleLink<String>();
        link.insert(0,  sarr[1]);
        link.appendLast( sarr[0]);
        link.insertFirst( sarr[2]);
        for(int i=0;i<link.size();i++) {
            System.out.println(link.get(i));
        }
    }

    //操作对象
    private static void testStudent() {
        String[] sarr = {"ten", "twenty", "thirty", "forty"};
        DoubleLink<Student> link = new DoubleLink<Student>();
        link.insert(0,  Student.students[1]);
        link.appendLast( Student.students[0]);
        link.insertFirst( Student.students[2]);
        for(int i=0;i<link.size();i++) {
            System.out.println(link.get(i));
        }
    }


    private static class Student{
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
        private static Student[] students = new Student[]{
                new Student(10, "sky"),
                new Student(10, "jody"),
                new Student(10, "vic"),
                new Student(10, "dan")
        };
    }
}
