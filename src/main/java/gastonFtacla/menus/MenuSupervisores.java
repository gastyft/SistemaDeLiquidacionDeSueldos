package gastonFtacla.menus;

import gastonFtacla.GestorPersonal;

import java.util.Scanner;

public class MenuSupervisores {

   private GestorPersonal gestorPersonal;


    public void menu(GestorPersonal gestorPersonal) {
        String menu = """
                ---------------------------------------
                Elija una opcion
                1- mostrar Supervisores
                2- Asignar empleados a supervisor
                3- Finalizar una supervision
                4- Editar empleado de la lista de un supervisor
                ESC- Volver atras
                               
                """;
        String o = "ESC";

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(menu);
            System.out.println("Ingrese opcion o escriba ESC para salir");
            o = scanner.nextLine().toUpperCase();
            // if(o.equalsIgnoreCase("ESC")) break;


            switch (o) {
                //Utilizo String en vez de int en opcion para evitar excepciones a la hora de que el usuario elija la opcion y
                // tipee un valor que no sea int. Al ser string salta directamente al default.

                case "1" -> gestorPersonal.mostrarSupervisores();
                case "2"-> gestorPersonal.asignarEmpleadosASupervisor();
                case "3"-> gestorPersonal.finalizarSupervision();
                case "ESC" -> System.out.println("Volvio atras\n");
                default -> System.out.println("Ingreso opcion que no es del menu");
            }

        }while (!o.equalsIgnoreCase("Esc"));


    }
}
