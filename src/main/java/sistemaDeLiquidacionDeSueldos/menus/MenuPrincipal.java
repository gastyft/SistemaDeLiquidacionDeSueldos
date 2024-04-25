package sistemaDeLiquidacionDeSueldos.menus;

import sistemaDeLiquidacionDeSueldos.GestorPersonal;

import java.util.Scanner;

public class MenuPrincipal {

    GestorPersonal gestorPersonal = new GestorPersonal();


    public void iniciar() {
        String menu = """
                Elija una opcion
                1- Buscar un empleado
                2- Editar
                3-Borrar
                4- Calcular sueldo de un empleado
                5- Calcular sueldo de todos los empleados
                6- Mostrar todos los empleados
                               
                """;
        String o = "ESC";
        int choice;
        Scanner scanner = new Scanner(System.in);
        gestorPersonal.crearPersonal();
        do {
            System.out.println(menu);
            System.out.println("Ingrese opcion o escriba ESC para salir");
            o = scanner.nextLine().toUpperCase();
            // if(o.equalsIgnoreCase("ESC")) break;


            switch (o) {
                case "1" -> gestorPersonal.buscar();
                case "2" -> gestorPersonal.editar();
                case "3" -> gestorPersonal.eliminar();
                case "4" -> gestorPersonal.calcularsueldoAUnEmpleado();
                case "5" -> gestorPersonal.calcularSueldosATodos();
                case "6" -> gestorPersonal.mostrar();
                case "ESC"-> System.out.println("Escribio Escape\n");
                default -> System.out.println("Ingreso opcion que no es del menu");
            }

        } while (!o.equalsIgnoreCase("ESC"));
        System.out.println("Gracias. Programa finalizado");

    }
}
