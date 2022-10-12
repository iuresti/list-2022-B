import java.util.Objects;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.arraylist.ArrayList;
import uaslp.objetos.list.linkedlist.LinkedList;


class Alumno {

    private String nombre;
    private String clave;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(clave, alumno.clave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, clave);
    }
}


public class Main {


    public static void main(String[] args) {
        // Crear cultura proporcionando nombre y descripción



        List datos = new ArrayList();

        datos.getIterator();

        datos.addAtTail("uno");
        datos.addAtTail("dos");
        datos.addAtTail("tres");

        datos.addAtFront("3");
        datos.addAtFront("2");
        datos.addAtFront("1");

        Iterator iterator = datos.getIterator();

        while (iterator.hasNext()) {
            String value = iterator.next();

            System.out.println(value);
        }
        System.out.println("---------------------");

        datos.addAtFront("3");
        datos.addAtFront("2");
        datos.addAtFront("1");

        datos.removeAll();

        iterator = datos.getIterator();

        while (iterator.hasNext()) {
            String value = iterator.next();

            System.out.println(value);
        }

    }


}
