package gastonFtacla.menus;

import gastonFtacla.GestorPersonal;
import gastonFtacla.personal.Empleado;

import java.util.Scanner;

public class MenuPrincipal { /// NO SE CALCULAN LOS SUELDOS HASTA QUE SE DE LA OPCION CALCULAR SUELDO A UN EMPLEADO
    //O PARA TODOS.

    GestorPersonal gestorPersonal = new GestorPersonal();
    MenuSupervisores menuSupervisores = new MenuSupervisores();
    public void iniciar() { //Inicio de programa
        String menu = """
                ---------------------------------------
                Elija una opcion
                1- Buscar un empleado
                2- Editar un Empleado
                3- Borrar un Empleado 
                4- Calcular sueldo de un empleado
                5- Calcular sueldo de todos los empleados
                6- Mostrar todos los empleados
                7- Menu Supervisores
                ESC - Salir
                """;
        String o = "ESC";

        Scanner scanner = new Scanner(System.in);
        gestorPersonal.crearPersonal();
        do {
            System.out.println(menu);
            System.out.println("Ingrese opcion o escriba ESC para salir");
            o = scanner.nextLine().toUpperCase();
            // if(o.equalsIgnoreCase("ESC")) break;


            switch (o) {
                //Utilizo String en vez de int en opcion para evitar excepciones a la hora de que el usuario elija la opcion y
                // tipee un valor que no sea int. Al ser string salta directamente al default.

                case "1" -> {
                    gestorPersonal.mostrar(); //MUestro Empleados y luego llamo al metodo buscar que devuelve un empledo.
                    Empleado empleadoBuscado= gestorPersonal.buscar();
                    if(empleadoBuscado!=null){
                        System.out.println(empleadoBuscado.toString());
                    }
                    else System.out.println("NO SE ENCONTRO EL EMPLEADO O TIPEO MAL EL NOMBRE");
                }
                case "2" -> gestorPersonal.editar(); //Edita empleados Dependiendo la instancia son los datos que solicita
                case "3" -> gestorPersonal.eliminar(); //Elimina empleados
                case "4" -> gestorPersonal.calcularsueldoAUnEmpleado(); //calcula el sueldo a un empleado
                case "5" -> gestorPersonal.calcularSueldosATodos(); //calcula el sueldo a todos los empleados
                case "6" -> gestorPersonal.mostrar(); //muestra todos los empleados
                case "7" -> menuSupervisores.menu(this.gestorPersonal); //Accede al menu de supervisores
                case "ESC" -> System.out.println("Escribio Escape\n");
                default -> System.out.println("Ingreso opcion que no es del menu");
            }

        } while (!o.equalsIgnoreCase("ESC"));
        System.out.println("Gracias. Programa finalizado");

    }
}
