package uaslp.objetos.list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;


// Stack (pila) trace

public class ArrayListTest {


    // TDD -> Test Driven Development

    // Alto nivel -> Alto nivel de abstracción

    // Bajo nivel -> Bajo nivel de abstracción C

    // Ensamblador
    // mnemónicos ADD, MOVE 1, 2


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
    public void givenANewList_whenAddAtTail_thenSizeIsOne() throws NullNotAllowedException, WrongIndexException {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        // When:
        lista.addAtTail("Uno");

        // Then:
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals("Uno", lista.getAt(0));
    }

    @Test
    public void givenANewList_whenAddAtTailNullValue_thenExceptionIsThrown() throws NullNotAllowedException, WrongIndexException {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        // When:
        Assertions.assertThrows(NullNotAllowedException.class, ()->lista.addAtTail(null));

        // Then:
        Assertions.assertEquals(0, lista.getSize());
    }

    @Test
    public void givenANewList_whenAddAtFrontNullValue_thenExceptionIsThrown() throws NullNotAllowedException, WrongIndexException {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        // When:
        Assertions.assertThrows(NullNotAllowedException.class, ()->lista.addAtFront(null));

        // Then:
        Assertions.assertEquals(0, lista.getSize());
    }

    @Test
    public void givenANonEmptyList_whenAddAtTail_thenSizeIsIncreased() throws NullNotAllowedException, WrongIndexException {
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
    public void givenANewList_whenAddAtFront_thenSizeIsOne() throws NullNotAllowedException, WrongIndexException {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        // When:
        lista.addAtFront("Uno");

        // Then:
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals("Uno", lista.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenAddAtFront_thenSizeIsIncreased() throws NullNotAllowedException, WrongIndexException {
        // Given: Preparación del test
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtFront("Uno");

        // When:
        lista.addAtFront("Dos"); //-> Ejecución del método a probar

        // Then:  // Validación de la prueba
        Assertions.assertEquals(2, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
    }

    @Test
    public void givenAList_whenRemoveLessThanZero_thenReturnFalse() throws NullNotAllowedException, WrongIndexException {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtFront("Uno");

        // When:
        try {
            lista.remove(-1);
            Assertions.fail("Exception expected due to wrong index");
        } catch (NullNotAllowedException | WrongIndexException ex) {
            System.out.println("Exception thrown");
        }

        // Then:
    }

    @Test
    public void givenAList_whenRemoveGreaterThanSize_thenReturnFalse() throws NullNotAllowedException, WrongIndexException {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtFront("Uno");

        // When:
        Assertions.assertThrows(WrongIndexException.class, () -> lista.remove(1));

        // Then:

    }

    // checked vs unchecked exceptions

    @Test
    public void givenAListWithOneElement_whenRemove0_thenReturnTrue() throws NullNotAllowedException, WrongIndexException {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtFront("Uno");

        // When:
        lista.remove(0);

        // Then:
        Assertions.assertEquals(0, lista.getSize());
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveHead_thenReturnTrue() throws NullNotAllowedException, WrongIndexException {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtFront("Uno");
        lista.addAtFront("Dos");

        // When:
        lista.remove(0);

        // Then:
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Uno");
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveTail_thenReturnTrue() throws NullNotAllowedException, WrongIndexException {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtTail("Uno");
        lista.addAtTail("Dos");

        // When:
        lista.remove(1);

        // Then:
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Uno");
    }

    @Test
    public void givenAListWith3Elements_whenRemoveMiddle_thenReturnTrue() throws NullNotAllowedException, WrongIndexException {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");


        // When:
        lista.remove(1);

        // Then:
        Assertions.assertEquals(2, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Dos");
        Assertions.assertEquals(lista.getAt(1), "Tres");
    }

    @Test
    public void givenAListWith3Elements_whenRemoveAll_thenSizeIsZero() throws NullNotAllowedException {
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
    public void givenAListWith3Elements_whenSetAt1_thenElementIsModified() throws NullNotAllowedException, WrongIndexException {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");

        // When:
        lista.setAt(1, "Cuatro");

        // Then:
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Cuatro", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAListWith3Elements_whenSetAt1NullValue_thenExceptionIsThrown() throws NullNotAllowedException, WrongIndexException {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");

        // When:
        Assertions.assertThrows(NullNotAllowedException.class, () -> lista.setAt(1, null));

        // Then:
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAListWith3Elements_whenSetAtLessThanZero_thenReturnNull() throws NullNotAllowedException, WrongIndexException {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");

        // When:
        Assertions.assertThrows(WrongIndexException.class, () -> lista.setAt(-1, "Cuatro"));

        // Then:
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAListWith3Elements_whenSetAtIndex3_thenReturnNull() throws NullNotAllowedException, WrongIndexException {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");

        // When:
        Assertions.assertThrows(WrongIndexException.class, () -> lista.setAt(3, "Cuatro"));

        // Then:
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
    }

    @Test
    public void givenAListWith2Elements_whenAddAtFront_thenArrayIsIncreasedSuccessfully() throws NullNotAllowedException, WrongIndexException {
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
    public void givenAnArray_whenGetAtNegative_thenNullIsReturned() throws NullNotAllowedException, WrongIndexException {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtFront("Algo");

        // When:
        Assertions.assertThrows(WrongIndexException.class, () -> lista.getAt(-1));
    }

    @Test
    public void givenAnArray_whenGetAtIndexGreaterThanSize_thenNullIsReturned() throws NullNotAllowedException, WrongIndexException {
        // Given:
        ArrayList<String> lista = new ArrayList<>();

        lista.addAtFront("Algo");

        // When:
        Assertions.assertThrows(WrongIndexException.class, () -> lista.getAt(1));
    }

    @Test
    public void givenAnArray_whenRemoveAllWithValue_thenValuesAreRemoved() throws NullNotAllowedException, WrongIndexException {
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
    public void givenAnArrayWithNoCoincidences_whenRemoveAllWithValue_thenValuesAreRemoved() throws NullNotAllowedException, WrongIndexException {
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
    public void givenANonEmptyList_whenIterate_thenIterationIsSuccessful() throws NullNotAllowedException {
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
