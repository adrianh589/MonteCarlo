/**
 * @author Adrian Hoyos
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //Cantidad de puntos a generar en el gráfico
        int cantidadPuntos = 700;

        //Generar las coordenadas de manera aleatoria
        double[][] puntosAleatorios = MonteCarlo.puntosAleatorios(cantidadPuntos);

        //Operacion Figura Externa
        int puntosDentroFiguraExterna = MonteCarlo.estaDentro(MonteCarlo.puntosFijosFiguraExterna,puntosAleatorios);
        double areaFiguraExterna = MonteCarlo.hallarAreaIrregular(puntosDentroFiguraExterna, cantidadPuntos, 8.9, 8.6, "externa");

        //Operacion Figura Interna
        int puntosDentroFiguraInterna = MonteCarlo.estaDentro(MonteCarlo.puntosFijosFiguraInterna, puntosAleatorios);
        double areaFiguraInterna = MonteCarlo.hallarAreaIrregular(puntosDentroFiguraInterna, cantidadPuntos, 8.9, 8.6, "interna");

        //Total del area de la franja
        double totalAreaFranja = areaFiguraExterna - areaFiguraInterna;
        System.out.println("El total del area de la franja es: "+totalAreaFranja+" Km2");
    }
}
