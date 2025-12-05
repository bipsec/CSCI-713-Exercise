import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class StudentTest {

    @Test
    void testConstructor() {
        Student student = new Student("Alice", 20, 3.5);
        assertEquals("Alice", student.name);
        assertEquals(20, student.age);
        assertEquals(3.5, student.gpa, 0.001);
    }

    @Test
    void testConstructorDifferentValues() {
        Student student = new Student("Bob", 22, 3.9);
        assertEquals("Bob", student.name);
        assertEquals(22, student.age);
        assertEquals(3.9, student.gpa, 0.001);
    }

    @Test
    void testConstructorZeroGpa() {
        Student student = new Student("Charlie", 21, 0.0);
        assertEquals("Charlie", student.name);
        assertEquals(21, student.age);
        assertEquals(0.0, student.gpa, 0.001);
    }

    @Test
    void testConstructorNegativeGpa() {
        Student student = new Student("David", 23, -1.0);
        assertEquals("David", student.name);
        assertEquals(23, student.age);
        assertEquals(-1.0, student.gpa, 0.001);
    }

    @Test
    void testGetName() {
        Student student = new Student("Alice", 20, 3.5);
        assertEquals("Alice", student.getName());
    }

    @Test
    void testGetNameEmpty() {
        Student student = new Student("", 20, 3.5);
        assertEquals("", student.getName());
    }

    @Test
    void testGetNameNull() {
        Student student = new Student(null, 20, 3.5);
        assertNull(student.getName());
    }

    @Test
    void testGetGpa() {
        Student student = new Student("Alice", 20, 3.5);
        assertEquals(3.5, student.getGpa(), 0.001);
    }

    @Test
    void testGetGpaZero() {
        Student student = new Student("Alice", 20, 0.0);
        assertEquals(0.0, student.getGpa(), 0.001);
    }

    @Test
    void testGetGpaNegative() {
        Student student = new Student("Alice", 20, -1.0);
        assertEquals(-1.0, student.getGpa(), 0.001);
    }

    @Test
    void testSetAgePositive() {
        Student student = new Student("Alice", 20, 3.5);
        student.setAge(25);
        assertEquals(25, student.age);
    }

    @Test
    void testSetAgeZero() {
        Student student = new Student("Alice", 20, 3.5);
        student.setAge(0);
        assertEquals(0, student.age);
    }

    @Test
    void testSetAgeNegative() {
        Student student = new Student("Alice", 20, 3.5);
        student.setAge(-5);
        assertEquals(0, student.age);
    }

    @Test
    void testSetAgeVeryLarge() {
        Student student = new Student("Alice", 20, 3.5);
        student.setAge(200);
        assertEquals(200, student.age);
    }

    @Test
    void testSetAgeBoundaryZero() {
        Student student = new Student("Alice", 20, 3.5);
        student.setAge(0);
        assertEquals(0, student.age);
    }

    @Test
    void testSetAgeBoundaryNegativeOne() {
        Student student = new Student("Alice", 20, 3.5);
        student.setAge(-1);
        assertEquals(0, student.age);
    }

    @Test
    void testSetGpa() {
        Student student = new Student("Alice", 20, 3.5);
        student.setGpa(3.8);
        assertEquals(3.8, student.gpa, 0.001);
    }

    @Test
    void testSetGpaZero() {
        Student student = new Student("Alice", 20, 3.5);
        student.setGpa(0.0);
        assertEquals(0.0, student.gpa, 0.001);
    }

    @Test
    void testSetGpaNegative() {
        Student student = new Student("Alice", 20, 3.5);
        student.setGpa(-0.5);
        assertEquals(-0.5, student.gpa, 0.001);
    }

    @Test
    void testSetGpaPrecision() {
        Student student = new Student("Alice", 20, 3.12345);
        student.setGpa(3.123456789);
        assertEquals(3.123456789, student.gpa, 0.000000001);
    }

    @Test
    void testPrintStudentInfo() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Student student = new Student("Alice", 20, 3.5);
            student.printStudentInfo();
            String output = outputStream.toString().trim();
            assertTrue(output.contains("Alice 20 3.5"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testPrintStudentInfoWithZero() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Student student = new Student("Bob", 0, 0.0);
            student.printStudentInfo();
            String output = outputStream.toString().trim();
            assertTrue(output.contains("Bob 0 0.0"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testPrintStudentInfoWithNegative() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Student student = new Student("Charlie", -5, -1.0);
            student.printStudentInfo();
            String output = outputStream.toString().trim();
            assertTrue(output.contains("Charlie"));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testDirectFieldName() {
        Student student = new Student("Alice", 20, 3.5);
        assertEquals("Alice", student.name);
    }

    @Test
    void testDirectFieldAge() {
        Student student = new Student("Alice", 20, 3.5);
        assertEquals(20, student.age);
    }

    @Test
    void testDirectFieldGpa() {
        Student student = new Student("Alice", 20, 3.5);
        assertEquals(3.5, student.gpa, 0.001);
    }

    @Test
    void testMultipleSetAgeCalls() {
        Student student = new Student("Alice", 20, 3.5);
        student.setAge(25);
        student.setAge(30);
        assertEquals(30, student.age);
    }

    @Test
    void testMultipleSetGpaCalls() {
        Student student = new Student("Alice", 20, 3.5);
        student.setGpa(3.6);
        student.setGpa(3.7);
        assertEquals(3.7, student.gpa, 0.001);
    }

    @Test
    void testSetAgeThenGetAge() {
        Student student = new Student("Alice", 20, 3.5);
        student.setAge(30);
        assertEquals(30, student.age);
    }

    @Test
    void testSetGpaThenGetGpa() {
        Student student = new Student("Alice", 20, 3.5);
        student.setGpa(4.0);
        assertEquals(4.0, student.getGpa(), 0.001);
    }
}

