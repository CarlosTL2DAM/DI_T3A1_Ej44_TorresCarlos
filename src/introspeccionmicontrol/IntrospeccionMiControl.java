/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introspeccionmicontrol;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import miscontroles.MiControl;

/**
 *
 * @author usuario
 */
public class IntrospeccionMiControl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MiControl miControl = new MiControl();
        System.out.println("La clase a la que pertenece mi control es: " + miControl.getClass() + "\n");

        Class clase1 = miControl.getClass();

        //Muesra los campos de la clase "MiControl"
        muestraLosCampos(clase1);
        //Método que muestra los Constructrores de la clase "MiControl"
        muestraLosContructores(clase1);
        //Muestra los métodos de la clase "MiControl"
        muestraLosMetodos(clase1);

    }

    private static void muestraLosContructores(Class clase1) {

        //Get Declared Constructors --> Obtiene los constructores declarados en la clase MiControl
        //Si ponemos getConstructors() --> Obtiene los constructores declardos + los constructores heredados
        Constructor[] constructores = clase1.getDeclaredConstructors();
        System.out.println("Los constructores de la clase son: ");
        for (Constructor c : constructores) {
            //Obtiene el nombre del constructor, (por convenio sería miControl, el mismo nombre de la clase)
            String nombre = c.getName();
            //Los modificadores son, public, private, protected, etc.
            System.out.print("  " + Modifier.toString(c.getModifiers()));
            System.out.print("  " + nombre + "(");
            //Obtiene los parametros de dicho constructor
            Class[] tipoParams = c.getParameterTypes();
            for (int i = 0; i < tipoParams.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(tipoParams[i].getName() + "");

            }
            System.out.println(")");
        }
        System.out.println("");
    }

    private static void muestraLosCampos(Class clase1) {
        int i = 0;
        Field[] campos = clase1.getDeclaredFields();
        System.out.println("Los campos de la clase son: ");
        for (Field c : campos) {
            //Obtiene el nombre del campos
            String nombre = c.getName();
            System.out.println(" " + nombre);
            
        }
        System.out.println("");


    }

    private static void muestraLosMetodos(Class clase1) {
        int i = 0;
        Method[] metodos = clase1.getDeclaredMethods();
        System.out.println("Los métodos de la clase son: ");
        for (Method m : metodos) {
            //Obtiene el nombre del campos
            String nombre = m.getName();
            System.out.println(" " + nombre);
            
            
            i++;

        }
        System.out.println("");

    }

}
