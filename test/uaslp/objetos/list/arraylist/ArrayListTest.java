package uaslp.objetos.list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import uaslp.objetos.list.Iterator;


public class ArrayListTest {


    // TDD -> Test Driven Development


    @Test
    public void givenANewList_thenSizeIsZero() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        // When:
        int size = lista.getSize();

        // Then:
        Assertions.assertEquals(0, size);
    }

    @Test
    public void givenANewList_whenAddAtTail_thenSizeIsOne() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        // When:
        lista.addAtTail("Uno");

        // Then:
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals("Uno", lista.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenAddAtTail_thenSizeIsIncreased() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtTail("Uno");

        // When:
        lista.addAtTail("Dos");

        // Then:
        Assertions.assertEquals(2, lista.getSize());
        Assertions.assertEquals("Uno", lista.getAt(0));
        Assertions.assertEquals("Dos", lista.getAt(1));
    }

    @Test
    public void givenANewList_whenAddAtFront_thenSizeIsOne() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        // When:
        lista.addAtFront("Uno");

        // Then:
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals("Uno", lista.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenAddAtFront_thenSizeIsIncreased() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtFront("Uno");

        // When:
        lista.addAtFront("Dos");

        // Then:
        Assertions.assertEquals(2, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
    }

    @Test
    public void givenAList_whenRemoveLessThanZero_thenReturnFalse() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtFront("Uno");

        // When:
        boolean result = lista.remove(-1);

        // Then:
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAList_whenRemoveGreaterThanSize_thenReturnFalse() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtFront("Uno");

        // When:
        boolean result = lista.remove(1);

        // Then:
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAListWithOneElement_whenRemove0_thenReturnTrue() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtFront("Uno");

        // When:
        boolean result = lista.remove(0);

        // Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, lista.getSize());
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveHead_thenReturnTrue() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtFront("Uno");
        lista.addAtFront("Dos");

        // When:
        boolean result = lista.remove(0);

        // Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Uno");
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveTail_thenReturnTrue() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtTail("Uno");
        lista.addAtTail("Dos");

        // When:
        boolean result = lista.remove(1);

        // Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Uno");
    }

    @Test
    public void givenAListWith3Elements_whenRemoveMiddle_thenReturnTrue() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");


        // When:
        boolean result = lista.remove(1);

        // Then:
        Assertions.assertTrue(result);
        Assertions.assertEquals(2, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Dos");
        Assertions.assertEquals(lista.getAt(1), "Tres");
    }

    @Test
    public void givenAListWith3Elements_whenRemoveAll_thenSizeIsZero() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");


        // When:
        lista.removeAll();

        // Then:
        Assertions.assertEquals(0, lista.getSize());
    }

    @Test
    public void givenAListWith3Elements_whenSetAt1_thenElementIsModified() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");

        // When:
        boolean result = lista.setAt(1, "Cuatro");

        // Then:
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Cuatro", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
        Assertions.assertTrue(result);
    }

    @Test
    public void givenAListWith3Elements_whenSetAtLessThanZero_thenReturnNull() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");

        // When:
        boolean result = lista.setAt(-1, "Cuatro");

        // Then:
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAListWith3Elements_whenSetAtIndex3_thenReturnNull() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");

        // When:
        boolean result = lista.setAt(3, "Cuatro");

        // Then:
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAListWith2Elements_whenAddAtFront_thenArrayIsIncreasedSuccessfully() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtTail("Uno");
        lista.addAtFront("Dos");

        // When:
        lista.addAtFront("Tres");

        // Then:
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Tres", lista.getAt(0));
        Assertions.assertEquals("Dos", lista.getAt(1));
        Assertions.assertEquals("Uno", lista.getAt(2));
    }

    //TODO: copiar a LinkedList
    @Test
    public void givenAnArray_whenGetAtNegative_thenNullIsReturned() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtFront("Algo");

        // When:
        String value = lista.getAt(-1);

        // Then:
        Assertions.assertNull(value);
    }

    @Test
    public void givenAnArray_whenGetAtIndexGreaterThanSize_thenNullIsReturned() {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtFront("Algo");

        // When:
        String value = lista.getAt(1);

        // Then:
        Assertions.assertNull(value);
    }

    @Test
    public void givenAnArray_whenRemoveAllWithValue_thenValuesAreRemoved() {
        // Given:
        ArrayList<Integer> lista = new ArrayList<>();

        lista.addAtFront(10);
        lista.addAtFront(20);
        lista.addAtTail(30);
        lista.addAtFront(20);
        lista.addAtTail(40);
        lista.addAtFront(20);
        lista.addAtTail(30);

        // When:
        lista.removeAllWithValue(20);

        // Then:
        Assertions.assertEquals(4, lista.getSize());
        Assertions.assertEquals(10, lista.getAt(0));
        Assertions.assertEquals(30, lista.getAt(1));
        Assertions.assertEquals(40, lista.getAt(2));
        Assertions.assertEquals(30, lista.getAt(3));
    }

    @Test
    public void givenAnArrayWithNoCoincidences_whenRemoveAllWithValue_thenValuesAreRemoved() {
        // Given:
        ArrayList<Integer> lista = new ArrayList<>();

        lista.addAtFront(10);
        lista.addAtTail(30);
        lista.addAtTail(40);
        lista.addAtTail(30);

        // When:
        lista.removeAllWithValue(20);

        // Then:
        Assertions.assertEquals(4, lista.getSize());
        Assertions.assertEquals(10, lista.getAt(0));
        Assertions.assertEquals(30, lista.getAt(1));
        Assertions.assertEquals(40, lista.getAt(2));
        Assertions.assertEquals(30, lista.getAt(3));
    }

    @Test
    public void givenANonEmptyList_whenIterate_thenIterationIsSuccessful() {
        // Given:
        ArrayList<Integer> lista = new ArrayList<>();

        lista.addAtFront(10);
        lista.addAtTail(30);
        lista.addAtTail(40);
        lista.addAtTail(30);

        // When:
        Iterator<Integer> iterator = lista.getIterator();

        // Then:
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(10, iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(30, iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(40, iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(30, iterator.next());

        Assertions.assertFalse(iterator.hasNext());

    }

}
