import uaslp.objetos.list.List;
import uaslp.objetos.list.arraylist.ArrayList;


public class Main {

    public static void main(String[] args) {
        try {
            metodo();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println("No se cerró mal");
    }

    public static void metodo(){
        metodo2();

    }

    private static void metodo2() {
        List<String> lista = new ArrayList<>();

        lista.setAt(10, null);
    }

}
