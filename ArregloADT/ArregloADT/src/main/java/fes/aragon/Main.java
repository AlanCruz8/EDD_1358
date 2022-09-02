package fes.aragon;

public class Main {
    public static void main(String[] args) {
        ArregloADT<Object> prueba=new ArregloADT<>(6);
        
        Integer numeroEntero= 25;
        Float numeroDecimal = 3.14f;
        Double numeroDecimalDoble = 3.141517;
        Boolean booleano = false;
        
        prueba.setElemento(0, numeroEntero);
        prueba.setElemento(1, numeroDecimal);
        prueba.setElemento(2, numeroDecimalDoble);
        prueba.setElemento(3, "Hola mundo");
        prueba.setElemento(4, booleano);
        prueba.setElemento(5, new Perro("Pepe", "Chihuahua", 2));
        
        for (int i = 0; i < prueba.getLongitud(); i++) {
            System.out.println(prueba.getElemento(i));
        }
        
        System.out.println("-------------");
        
        System.out.println("Longitud del arregloADT : " + prueba.getLongitud());
        
        System.out.println("------------------");
        
        for (int i = 0; i < prueba.getLongitud(); i++) {
            System.out.println(prueba.getElemento(i).toString());
        }
        
        System.out.println("----------------");
        
        prueba.limpiar(null);
        
        for (int i = 0; i < prueba.getLongitud(); i++) {
            System.out.println(prueba.getElemento(i));
        }
        
    }
}
