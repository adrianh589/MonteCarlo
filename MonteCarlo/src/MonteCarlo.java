import java.sql.Array;
import java.util.Arrays;

/**
 * @author Adrian Hoyos
 */
public class MonteCarlo {
    //Puntos fijos del plano cartesiano [Cuadrante, Posicion X, Posicion Y]
    public static double[][] puntosFijos = {
            {4.0, 0.0060592945709, 0.9873992593112},// Punto 1
            {432.0, 0.1000694083257, 0.9468039829171},// Punto 2
            {4321.0, 0.2, 0.9},// Punto 3
            {4321.0, 0.2987726033076, 0.8698866171177},// Punto 4
            {4321.0, 0.3991924975457, 0.881637881337},// Punto 5
            {432.0, 0.4974757982894, 0.9275746414672},// Punto 6
            {432.0, 0.5775980543305, 0.9019355195341},// Punto 7
            {4321.0, 0.6, 0.8},// Punto 8
            {4321.0, 0.6, 0.7},// Punto 9
            {4321.0, 0.6662666843493, 0.7010957310578},// Punto 10
            {4321.0, 0.6993838835129, 0.7203250725077},// Punto 11
            {4321.0, 0.7634816883458, 0.8025839220432},// Punto 12
            {4321.0, 0.8008720744983, 0.8399743081957},// Punto 13
            {432.0, 0.9012919687364, 0.8559987594039},// Punto 14
            {432.0, 0.9621848833276, 0.8410426049429},// Punto 15
            {432.0, 0.9814142247775, 0.801515625296},// Punto 16
            {32.0, 0.9974386759857, 0.7374178204631},// Punto 17
            {321.0, 0.99, 0.7},// Punto 18
            {321.0, 0.99, 0.6},// Punto 19
            {321.0, 0.9792776312831, 0.5365780319868},// Punto 20
            {321.0, 0.9536385093499, 0.5002559425816},// Punto 21
            {321.0, 0.9247944971751, 0.4714119304068},// Punto 22
            {321.0, 0.899155375242, 0.4532508857041},// Punto 23
            {321.0, 0.8703113630672, 0.4286800605182},// Punto 24
            {321.0, 0.8553552086062, 0.4030409385851},// Punto 25
            {321.0, 0.8350575704091, 0.3517626947188},// Punto 26
            {321.0, 0.8222380094426, 0.3015527475997},// Punto 27
            {321.0, 0.8019403712455, 0.2492062069862},// Punto 28
            {321.0, 0.7709597655763, 0.2011328533616},// Punto 29
            {321.0, 0.6983155867657, 0.1252837843094},// Punto 30
            {321.0, 0.6406275624161, 0.1007129591234},// Punto 31
            {321.0, 0.5989639892748, 0.0857568046624},// Punto 32
            {321.0, 0.4996123917839, 0.0408883412794},// Punto 33
            {21.0, 0.4600854121369, 0.0109760323574},// Punto 34
            {4321.0, 0.4675634893674, 0.0975080688818},// Punto 35
            {4321.0, 0.4686317861147, 0.1979279631199},// Punto 36
            {421.0, 0.4365828836982, 0.3015527475997},// Punto 37
            {421.0, 0.4013290910402, 0.3474895077299},// Punto 38
            {421.0, 0.3500508471739, 0.3998360483434},// Punto 39
            {421.0, 0.2998409000548, 0.4852997881206},// Punto 40
            {421.0, 0.2603139204079, 0.5440561092173},// Punto 41
            {421.0, 0.2143771602777, 0.5996075400725},// Punto 42
            {421.0, 0.1481427619504, 0.6914810603329},// Punto 43
            {421.0, 0.101137705073, 0.7758765033628},// Punto 44
            {421.0, 0.0552009449427, 0.8656134301288}// Punto 45
    };

    public static int puntosDentro = 0;

    public static void estaDentro(double[][] puntosAleatorios) {

        boolean bandera = false;

        for (int i = 0; i < puntosAleatorios.length; i++) {

            for (int j = 0; j < puntosFijos.length; j++) {

//                System.out.println(Arrays.toString(puntosAleatorios[j]));

                switch (Double.toString(puntosFijos[j][0])) {
                    case "43.0" -> {
                        bandera = cuadrante4(puntosAleatorios[i], puntosFijos[j]) || cuadrante3(puntosAleatorios[i], puntosFijos[j]);
                    }
                    case "3.0" -> {
                        bandera = cuadrante3(puntosAleatorios[i], puntosFijos[j]);
                    }
                    case "432.0" -> {
                        bandera = cuadrante4(puntosAleatorios[i], puntosFijos[j]) || cuadrante3(puntosAleatorios[i], puntosFijos[j]) || cuadrante2(puntosAleatorios[i], puntosFijos[j]);
                    }
                    case "4.0" -> {
                        bandera = cuadrante4(puntosAleatorios[i], puntosFijos[j]);
                    }
                    case "32.0" -> {
                        bandera = cuadrante3(puntosAleatorios[i], puntosFijos[j]) || cuadrante2(puntosAleatorios[i], puntosFijos[j]);
                    }
                    case "321.0" -> {
                        bandera = cuadrante3(puntosAleatorios[i], puntosFijos[j]) || cuadrante2(puntosAleatorios[i], puntosFijos[j]) || cuadrante1(puntosAleatorios[i], puntosFijos[j]);
                    }
                    case "21.0" -> {
                        bandera = cuadrante2(puntosAleatorios[i], puntosFijos[j]) || cuadrante1(puntosAleatorios[i], puntosFijos[j]);
                    }
                    case "421.0" -> {
                        bandera = cuadrante2(puntosAleatorios[i], puntosFijos[j]) || cuadrante1(puntosAleatorios[i], puntosFijos[j]) || cuadrante4(puntosAleatorios[i], puntosFijos[j]);
                    }
                    case "4321.0" -> {
                        bandera = cuadrante4(puntosAleatorios[i], puntosFijos[j]) || cuadrante3(puntosAleatorios[i], puntosFijos[j]) || cuadrante2(puntosAleatorios[i], puntosFijos[j]) || cuadrante1(puntosAleatorios[i], puntosFijos[j]);
                    }
                    default -> System.out.println("Este punto no cumple ninguna condicion");
                }
//                System.out.println( "Punto "+ (j+1) + " punto fijo: " + Arrays.toString(puntosFijos[j]) + " punto aleatorio: " + Arrays.toString(puntosAleatorios[i]) + ": " + bandera );
                if (!bandera) {// Si es falso es porque algun punto no esta dentro del cuadrante
                    break;
                }
            }
            if(bandera){// Suma 1 en caso de que el punto este dentro de todos los cuadrantes
                puntosDentro+=1;
            }
        }
        System.out.println("Puntos dentro de la figura: " + puntosDentro);
    }

    /**
     * Funcion para saber si un punto esta dentro del cuadrante 1
     *
     * @param puntoAleatorio 2 Posiciones [x, y]
     * @param puntoFijo      3 Posiciones [cuadrante, x, y]
     * @return Retorna TRUE si esta dentro del cuadrante 1, en otro caso FALSO
     */
    private static boolean cuadrante1(double[] puntoAleatorio, double[] puntoFijo) {
        return puntoAleatorio[0] >= puntoFijo[1] && puntoAleatorio[1] >= puntoFijo[2];
    }

    /**
     * Funcion para saber si un punto esta dentro del cuadrante 2
     *
     * @param puntoAleatorio 2 Posiciones [x, y]
     * @param puntoFijo      3 Posiciones [cuadrante, x, y]
     * @return Retorna TRUE si esta dentro del cuadrante 2, en otro caso FALSO
     */
    private static boolean cuadrante2(double[] puntoAleatorio, double[] puntoFijo) {
        return puntoAleatorio[0] <= puntoFijo[1] && puntoAleatorio[1] >= puntoFijo[2];
    }

    /**
     * Funcion para saber si un punto esta dentro del cuadrante 3
     *
     * @param puntoAleatorio 2 Posiciones [x, y]
     * @param puntoFijo      3 Posiciones [cuadrante, x, y]
     * @return Retorna TRUE si esta dentro del cuadrante 3, en otro caso FALSO
     */
    private static boolean cuadrante3(double[] puntoAleatorio, double[] puntoFijo) {
        return puntoAleatorio[0] <= puntoFijo[1] && puntoAleatorio[1] <= puntoFijo[2];
    }

    /**
     * Funcion para saber si un punto esta dentro del cuadrante 4
     *
     * @param puntoAleatorio 2 Posiciones [x, y]
     * @param puntoFijo      3 Posiciones [cuadrante, x, y]
     * @return Retorna TRUE si esta dentro del cuadrante 4, en otro caso FALSO
     */
    private static boolean cuadrante4(double[] puntoAleatorio, double[] puntoFijo) {
        return puntoAleatorio[0] >= puntoFijo[1] && puntoAleatorio[1] <= puntoFijo[2];
    }

    /**
     * Funcion para crear los puntos aleatorios
     *
     * @param cantidad Recibe el numero de puntos aleatorios a generar
     * @return Retornar las coordenadas de los puntos aleatiorias
     */
    public static double[][] puntosAleatorios(int cantidad) {
        double[][] puntosAleatorios = new double[cantidad][2];
        for (int i = 0; i < cantidad; i++) {
            puntosAleatorios[i] = new double[]{Math.random(), Math.random()};
        }
        return puntosAleatorios;
    }

    /**
     * Funcion para imprimir los numeros
     */
    public static void imprimirNumerosAleatorios(double[][] numerosAleatorios) {
        for (int i = 0; i < numerosAleatorios.length; i++) {
            System.out.println(Arrays.toString(numerosAleatorios[i]));
        }
    }
}
