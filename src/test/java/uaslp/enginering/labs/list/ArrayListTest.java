package uaslp.enginering.labs.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.enginering.labs.model.Student;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    public void givenNewList_whenSize_thenZeroIsReturned() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        // When:
        int size = arrayList.size();

        // Then:
        assertEquals(0, size);
    }

    @Test
    public void givenNewList_whenAdd_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student student = new Student("Ivan");

        // When:
        arrayList.add(student);

        // Then:
        assertEquals(1, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
    }

    @Test
    public void givenAListWithNoMoreCapacity_whenAdd_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>(2);

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));


        // When:
        arrayList.add(new Student("Francisco"));

        // Then:
        assertEquals(3, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Francisco");
    }

    @Test
    public void givenAListWithNoMoreCapacity_whenAdd_thenElementIsInserted_getAt_Out_Of_Range() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>(2);

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));


        // When:
        arrayList.add(new Student("Francisco"));

        // Then:
        assertEquals(3, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->{
            assertEquals(arrayList.getAt(4).getName(), "Francisco");
        });

    }

    @Test
    public void givenAListWith3Elements_whenDeleteReferenceStudentFist_thenElementsDeleted(){
        // Given:
        ArrayList <Student> arrayList = new ArrayList<>();
        Student reference = new Student("Ivan");
        arrayList.add(reference);
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.delete(reference);

        //Then:
        assertEquals(2, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Israel");
        assertEquals(arrayList.getAt(1).getName(), "Francisco");
    }
    @Test
    public void givenAListWith3Elements_whenDeleteWrongReferences(){
        // Given:
        ArrayList <Student> arrayList = new ArrayList<>();
        Student reference = new Student("Ivan");
        arrayList.add(new Student("Edilberto"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:

        //Then:
        assertEquals(3, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Edilberto");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Francisco");
        Assertions.assertThrows(NoSuchElementException.class, ()->{
            arrayList.delete(reference);
        });
    }

    @Test
    public void givenAListWith3Elements_whenDeleteReferenceStudentMiddle_thenElementsDeleted(){
        // Given:
        ArrayList <Student> arrayList = new ArrayList<>();
        Student reference =new Student("Israel") ;
        arrayList.add(new Student("Ivan"));
        arrayList.add(reference);
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.delete(reference);

        //Then:
        assertEquals(2, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteReferenceStudentEnd_thenElementsDeleted(){
        // Given:
        ArrayList <Student> arrayList = new ArrayList<>();
        Student reference = new Student("Francisco");
        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(reference);

        // When:
        arrayList.delete(reference);

        //Then:
        assertEquals(2, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteFirst_thenElementIsDeleted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.delete(0);

        // Then:
        assertEquals(2, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Israel");
        assertEquals(arrayList.getAt(1).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteLast_thenElementIsDeleted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.delete(2);

        // Then:
        assertEquals(2, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteMiddle_thenElementIsDeleted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.delete(1);

        // Then:
        assertEquals(2, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteNegative_thenDoesNothing() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        //arrayList.delete(-1);

        // Then:
        assertEquals(3, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Francisco");
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->{
            arrayList.delete(-1);});

    }

    @Test
    public void givenAListWith3Elements_whenDeleteOutOfSize_thenDoesNothing() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        //arrayList.delete(4);

        // Then:
        assertEquals(3, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Francisco");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->{
            arrayList.delete(4);
        });
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtBeginningBefore_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Ivan");

        arrayList.add(reference);
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.BEFORE);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Lupita");
        assertEquals(arrayList.getAt(1).getName(), "Ivan");
        assertEquals(arrayList.getAt(2).getName(), "Israel");
        assertEquals(arrayList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenTwoElementsIncreaseArray() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Ivan");

        arrayList.add(reference);
        arrayList.add(new Student("Israel"));

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.BEFORE);

        // Then:
        assertEquals(3, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Lupita");
        assertEquals(arrayList.getAt(1).getName(), "Ivan");
        assertEquals(arrayList.getAt(2).getName(), "Israel");

    }

    @Test
    public void givenAListWith3Elements_whenInsertAtEndBefore_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Francisco");

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(reference);

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.BEFORE);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Lupita");
        assertEquals(arrayList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtEndBefore_thenElementIsInsertedIncorrectReference() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Francisco");

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("reference"));

        // When:

        // Then:
        assertEquals(3, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "reference");
        Assertions.assertThrows(NoSuchElementException.class, ()->{
            arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.BEFORE);

        });
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtMiddleBefore_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Israel");

        arrayList.add(new Student("Ivan"));
        arrayList.add(reference);
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.BEFORE);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Lupita");
        assertEquals(arrayList.getAt(2).getName(), "Israel");
        assertEquals(arrayList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtBeginningAfter_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Ivan");

        arrayList.add(reference);
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.AFTER);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Lupita");
        assertEquals(arrayList.getAt(2).getName(), "Israel");
        assertEquals(arrayList.getAt(3).getName(), "Francisco");
    }
    @Test
    public void givenListWithOneElement_whenGetIterator_thenIteratorHasOneNext(){
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));

        // When:
        ArrayList<Student>.Iterator iterator = arrayList.getIterator();

        // Then:
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        Student student = iterator.next();
        assertNotNull(student);
        assertEquals("Ivan", student.getName());
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtEndAfter_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Francisco");

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(reference);

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.AFTER);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Francisco");
        assertEquals(arrayList.getAt(3).getName(), "Lupita");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtMiddleAfter_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Israel");

        arrayList.add(new Student("Ivan"));
        arrayList.add(reference);
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.AFTER);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Lupita");
        assertEquals(arrayList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenEmptyList_whenGetIterator_thenIteratorIsEmpty(){
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        // When:
        ArrayList<Student>.Iterator iterator = arrayList.getIterator();

        // Then:
        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }

    
}
