import java.util.Random;
import java.util.Scanner;
//
public class App {

    static Scanner scanner = new Scanner(System.in);

    static String[] planetas = {" Marte ", " Jupiter ", " Saturno "};
    static double[] distancias = {54.0, 590.0, 1426.0};
    static String[] detallesPlanetas = {"Tambien conocido como el planeta rojo debido al hierro oxido de su suelo, tien una temperatura media de -65° Celsius, es de la mitad del tamaño de la tierra ", 
                                        "Es el planeta mas grande, es similar a una estrella, esta cubierta de numes arremolinadas, tiene grandes tormentas como la gran mancha roja, tieme anillos demasiado densos que no se logran ver muy bien ",
                                         "Es reconocido por sus anillos que estan formados por trozos de hielo y roca, su composicion principalemtne es de hidrógeno y helio"};
    
    static String[] naves = {"Infinity ", "Enterprise ", "Pelican "};
    static double[] velocidades = {35000.0, 46000.0, 59000.0};
    static double[] consumoCombustible = {231, 321, 443};

    static int naveSeleccionada = -1;
    static int planetaseleccionado = -1;
 
    public static void main(String[] args) throws Exception {
        
        int opcion;
        do{
            menuPrincipal();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                  seleccionarPlaneta();                    
                    break;
                case 2:
                  seleccionarNave();
                    break;
                case 3:
                   calcularRecursos();
                    break;
                case 4:
                  simulatuViaje();
                    break;
                case 5:
                   System.out.println("Hemos finalizado, Muchas Gracias");  
                    break;                     
                    
            
                default:
                    break;
            }
             

        }while(opcion!=4);
        
    }
    public static void menuPrincipal() {
        System.out.println("Menu Principal");
        System.out.println("1.Seleccionar Planeta");
        System.out.println("2.Seleccionar Nave");
        System.out.println("3.Calcular recursos");
        System.out.println("4.Simula tu Viaje");
        System.out.println("5.salir");
        System.out.println("seleciona una opcion y comencemos esta gran aventura: "); 
        
    }

    public static void seleccionarPlaneta() {
        System.out.println(" Seleccione un planeta : ");
        for(int i = 0; i < planetas.length; i++){
            System.out.println("Planeta " + (i+1) + ". " + planetas[i] + "Distancia: " + distancias[i] + " Millones de Km " + detallesPlanetas[i] );
                                   
        }
        System.out.println("---seleccione un Destino: " + (-1 + planetas.length + "." ));
        if (scanner.hasNextInt()){

        }

        int seleccion = scanner.nextInt();
        if(seleccion > 0 && seleccion <= planetas.length){
            System.out.println("Has selecionado el planeta " + planetas[seleccion - 1]);
            planetaseleccionado = seleccion -1;

            
        }
        else{
            System.out.println("Seleccione invalida. Intente nuevamente");
            scanner.nextLine();
        }
    }

    public static void seleccionarNave() {
        System.out.println("Seleccione una Nave");
        for(int i = 0; i < naves.length; i++){
            System.out.println("Nave: "  + (i+1) + ". " + naves[i] + "velocidad: " + velocidades[i] ); 
            
        }

        System.out.println("---seleccione una Nave: " + (-1 + naves.length + "."));
        if (scanner.hasNextInt()){

        }
        int seleccion = scanner.nextInt();
        if(seleccion > 0 && seleccion <= naves.length){
            System.out.println("Has selecionado la nave " + naves[seleccion - 1]);
            naveSeleccionada = seleccion - 1;
        }
        else{
            System.out.println("seleccion invalida. Intente nuevamente");
            scanner.nextLine();
        }                      
        
    } 

    public static void simulatuViaje() {
        
        
        System.out.println("---Iniciar Viaje---");
        Random random = new Random();
        for(int progreso = 0; progreso <= 100; progreso+=10){
            System.out.println("Progreso: " + progreso + "%");
            if (progreso == 50){
                System.out.println("mitad del camimo alcanzado");
            }            
            if (random.nextInt(10) < 3){
                System.out.println("Evento inesperado! Realizando ajustes...");                
            }
           try{
            Thread.sleep(500);
           }catch(InterruptedException e){
            System.out.println("Error en la simulación");

           
        }      
    }

    System.out.println("LLegada exitosa al destino");
}

    public static void calcularRecursos(){
            if (planetaseleccionado == -1 || naveSeleccionada == -1){
                System.out.println("Antes de iniciar la somulacion, selecione un planeta y una nave: ");
                return;
            }
        
        double distancia = distancias[planetaseleccionado];
        double combustible = distancia * consumoCombustible[naveSeleccionada];
        double oxigeno = distancias[planetaseleccionado] * 100;
        System.out.println("El combustible nesesario es: " + combustible + "Litros");
        System.out.println("la cantidad de unidades de oxigeno necesario es:" + oxigeno + "Unidades");
         
    }
        
} 