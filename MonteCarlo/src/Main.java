import java.util.Arrays;

/**
 * @author Adrian Hoyos
 */
public class Main {
    public static void main(String[] args) {
        int cantidadPuntos = 700;
        double[][] numerosAletorios = MonteCarlo.puntosAleatorios(cantidadPuntos);
//        double[][] numerosAletorios = {
//                {0.6949971794346332, 0.35764794542946154},
//                {0.13950749955853758, 0.24330309042713283}
//        };
        MonteCarlo.imprimirNumerosAleatorios(numerosAletorios);
        MonteCarlo.estaDentro(numerosAletorios);
        //Formula para el area
        double total = MonteCarlo.puntosDentro/ (double) cantidadPuntos;
        total = total * 76.54;
        System.out.println("El area de la figura  es: " + total);

    }
}
