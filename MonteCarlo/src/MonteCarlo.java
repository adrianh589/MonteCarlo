import java.util.Arrays;

/**
 * @author Adrian Hoyos
 */
public class MonteCarlo {
    //Puntos fijos de la figura externa [Cuadrante, Posicion X, Posicion Y]
    public static double[][] puntosFijosFiguraExterna = {
            {   4.0    , 0.0060592945709   , 0.9873992593112    },// Punto 1
            {   432.0  , 0.1000694083257   , 0.9468039829171    },// Punto 2
            {   4321.0 , 0.2               , 0.9                },// Punto 3
            {   4321.0 , 0.2987726033076   , 0.8698866171177    },// Punto 4
            {   4321.0 , 0.3991924975457   , 0.881637881337     },// Punto 5
            {   432.0  , 0.4974757982894   , 0.9275746414672    },// Punto 6
            {   432.0  , 0.5775980543305   , 0.9019355195341    },// Punto 7
            {   4321.0 , 0.6               , 0.8                },// Punto 8
            {   4321.0 , 0.6               , 0.7                },// Punto 9
            {   4321.0 , 0.6662666843493   , 0.7010957310578    },// Punto 10
            {   4321.0 , 0.6993838835129   , 0.7203250725077    },// Punto 11
            {   4321.0 , 0.7634816883458   , 0.8025839220432    },// Punto 12
            {   4321.0 , 0.8008720744983   , 0.8399743081957    },// Punto 13
            {   432.0  , 0.9012919687364   , 0.8559987594039    },// Punto 14
            {   432.0  , 0.9621848833276   , 0.8410426049429    },// Punto 15
            {   432.0  , 0.9814142247775   , 0.801515625296     },// Punto 16
            {   32.0   , 0.9974386759857   , 0.7374178204631    },// Punto 17
            {   321.0  , 0.99              , 0.7                },// Punto 18
            {   321.0  , 0.99              , 0.6                },// Punto 19
            {   321.0  , 0.9792776312831   , 0.5365780319868    },// Punto 20
            {   321.0  , 0.9536385093499   , 0.5002559425816    },// Punto 21
            {   321.0  , 0.9247944971751   , 0.4714119304068    },// Punto 22
            {   321.0  , 0.899155375242    , 0.4532508857041    },// Punto 23
            {   321.0  , 0.8703113630672   , 0.4286800605182    },// Punto 24
            {   321.0  , 0.8553552086062   , 0.4030409385851    },// Punto 25
            {   321.0  , 0.8350575704091   , 0.3517626947188    },// Punto 26
            {   321.0  , 0.8222380094426   , 0.3015527475997    },// Punto 27
            {   321.0  , 0.8019403712455   , 0.2492062069862    },// Punto 28
            {   321.0  , 0.7709597655763   , 0.2011328533616    },// Punto 29
            {   321.0  , 0.6983155867657   , 0.1252837843094    },// Punto 30
            {   321.0  , 0.6406275624161   , 0.1007129591234    },// Punto 31
            {   321.0  , 0.5989639892748   , 0.0857568046624    },// Punto 32
            {   321.0  , 0.4996123917839   , 0.0408883412794    },// Punto 33
            {   21.0   , 0.4600854121369   , 0.0109760323574    },// Punto 34
            {   4321.0 , 0.4675634893674   , 0.0975080688818    },// Punto 35
            {   4321.0 , 0.4686317861147   , 0.1979279631199    },// Punto 36
            {   421.0  , 0.4365828836982   , 0.3015527475997    },// Punto 37
            {   421.0  , 0.4013290910402   , 0.3474895077299    },// Punto 38
            {   421.0  , 0.3500508471739   , 0.3998360483434    },// Punto 39
            {   421.0  , 0.2998409000548   , 0.4852997881206    },// Punto 40
            {   421.0  , 0.2603139204079   , 0.5440561092173    },// Punto 41
            {   421.0  , 0.2143771602777   , 0.5996075400725    },// Punto 42
            {   421.0  , 0.1481427619504   , 0.6914810603329    },// Punto 43
            {   421.0  , 0.101137705073    , 0.7758765033628    },// Punto 44
            {   421.0  , 0.0552009449427   , 0.8656134301288    }// Punto 45
    };

    //Puntos fijos de la figura interna [Cuadrante, Posicion X, Posicion Y]
    public static double[][] puntosFijosFiguraInterna = {
            /*Punto 1*/ {   431.0   , 0.2199320770348    , 0.7890473353582    },
            /*Punto 2*/ {   431.0   , 0.2909658652824    , 0.817409161901     },
            /*Punto 3*/ {   4321.0   , 0.3767890794833    , 0.8112338523211    },
            /*Punto 4*/ {   43.0    , 0.4720703403752    , 0.8558510088334    },
            /*Punto 5*/ {   432.0   , 0.5304161224462    , 0.8019890126401    },
            /*Punto 6*/ {   4321.0  , 0.5529013014119    , 0.7444899659889    },
            /*Punto 7*/ {   4321.0  , 0.5696086098857    , 0.6797221145946    },
            /*Punto 8*/ {   4321.0  , 0.5772937207438    , 0.6341803387588    },
            /*Punto 9*/ {   4321.0  , 0.6360484528268    , 0.6234813864816    },
            /*Punto 10*/{   4321.0  , 0.699380724771     , 0.6802001852025    },
            /*Punto 11*/{   4321.0  , 0.7660425646487    , 0.7344495984937    },
            /*Punto 12*/{   432.0  , 0.8418736002549    , 0.7750476419063    },
            /*Punto 13*/{   432.0   , 0.8940353405512    , 0.7701384254119    },
            /*Punto 14*/{   32.0    , 0.9250456268316    , 0.7081500676853    },
            /*Punto 15*/{   32.0    , 0.92668            , 0.6416106770081    },
            /*Punto 16*/{   32.0   , 0.9232371656502    , 0.573645834304     },
            /*Punto 17*/{   321.0   , 0.8905291923162    , 0.5069354836156    },
            /*Punto 18*/{   321.0   , 0.8607365388883    , 0.463942117235     },
            /*Punto 19*/{   321.0   , 0.8213774799891    , 0.4135175121609    },
            /*Punto 20*/{   321.0   , 0.7870593127253    , 0.3589262293047    },
            /*Punto 21*/{   21.0    , 0.7159740513602    , 0.2961849338821    },
            /*Punto 22*/{   21.0   , 0.6488367865974    , 0.3008834544504    },
            /*Punto 23*/{   421.0   , 0.5701028509279    , 0.31284            },
            /*Punto 24*/{   421.0   , 0.4910209615479    , 0.3330211723547    },
            /*Punto 25*/{   421.0   , 0.4161548276253    , 0.3923192281601    },
            /*Punto 26*/{   421.0   , 0.3714502708802    , 0.4553960695064    },
            /*Punto 27*/{   421.0   , 0.3176583056061    , 0.5283791458158    },
            /*Punto 28*/{   421.0   , 0.2707483013091    , 0.5931466949727    },
            /*Punto 29*/{   421.0   , 0.2226424534002    , 0.6682562043247    },
            /*Punto 30*/{   41.0    , 0.21083            , 0.7397973371642    }
    };

    /**
     *  Función para detectar la cantidad de puntos dentro de la figura de montecarlo
     * @param puntosFijos Recibe los puntos fijos de la figura a encontrar su area
     * @param puntosAleatorios Recibe las coordenadas aleatorias que llenan la grafica
     * @return Retorna la cantidad de puntos que se encuentran dentro de la figura a hallar su area
     */
    public static int estaDentro(double[][] puntosFijos, double[][] puntosAleatorios) throws Exception {

        int puntosDentro = 0;
        boolean bandera = false;

        for (int i = 0; i < puntosAleatorios.length; i++) {
            for (int j = 0; j < puntosFijos.length; j++) {
//                System.out.println(Arrays.toString(puntosAleatorios[j]));
                switch (Double.toString(puntosFijos[j][0])) {
                    case "4321.0" -> bandera = true;
                    case "432.0" -> bandera = cuadrante4(puntosAleatorios[i], puntosFijos[j]) || cuadrante3(puntosAleatorios[i], puntosFijos[j]) || cuadrante2(puntosAleatorios[i], puntosFijos[j]);
                    case "431.0" -> bandera = cuadrante4(puntosAleatorios[i], puntosFijos[j]) || cuadrante3(puntosAleatorios[i], puntosFijos[j]) || cuadrante1(puntosAleatorios[i], puntosFijos[j]);
                    case "43.0" -> bandera = cuadrante4(puntosAleatorios[i], puntosFijos[j]) || cuadrante3(puntosAleatorios[i], puntosFijos[j]);
                    case "421.0" -> bandera = cuadrante4(puntosAleatorios[i], puntosFijos[j]) || cuadrante2(puntosAleatorios[i], puntosFijos[j]) || cuadrante1(puntosAleatorios[i], puntosFijos[j]);
                    case "41.0" -> bandera = cuadrante4(puntosAleatorios[i], puntosFijos[j]) || cuadrante1(puntosAleatorios[i], puntosFijos[j]);
                    case "4.0" -> bandera = cuadrante4(puntosAleatorios[i], puntosFijos[j]);
                    case "321.0" -> bandera = cuadrante3(puntosAleatorios[i], puntosFijos[j]) || cuadrante2(puntosAleatorios[i], puntosFijos[j]) || cuadrante1(puntosAleatorios[i], puntosFijos[j]);
                    case "32.0" -> bandera = cuadrante3(puntosAleatorios[i], puntosFijos[j]) || cuadrante2(puntosAleatorios[i], puntosFijos[j]);
                    case "3.0" -> bandera = cuadrante3(puntosAleatorios[i], puntosFijos[j]);
                    case "21.0" -> bandera = cuadrante2(puntosAleatorios[i], puntosFijos[j]) || cuadrante1(puntosAleatorios[i], puntosFijos[j]);
                    default -> throw new Exception("Este punto no cumple ninguna condicion -> " + Arrays.toString(puntosFijos[j]));
                }
//                System.out.println( "Punto "+ (j+1) + " punto fijo: " + Arrays.toString(puntosFijos[j]) + " punto aleatorio: " + Arrays.toString(puntosAleatorios[i]) + ": " + bandera );
                if (!bandera) {// Si es falso es porque algun punto no esta dentro del cuadrante
                    break;
                }
            }
            if(bandera){// Suma 1 en caso de que el punto este dentro de todos los cuadrantes de cada uno de los puntos
                puntosDentro+=1;
            }
        }
        System.out.println("Puntos dentro de la figura: " + puntosDentro);
        return puntosDentro;
    }

    /**
     * Funcion para saber si un punto esta dentro del cuadrante 1
     * @param puntoAleatorio 2 Posiciones [x, y]
     * @param puntoFijo      3 Posiciones [cuadrante, x, y]
     * @return Retorna TRUE si esta dentro del cuadrante 1, en otro caso FALSO
     */
    private static boolean cuadrante1(double[] puntoAleatorio, double[] puntoFijo) {
        return puntoAleatorio[0] >= puntoFijo[1] && puntoAleatorio[1] >= puntoFijo[2];
    }

    /**
     * Funcion para saber si un punto esta dentro del cuadrante 2
     * @param puntoAleatorio 2 Posiciones [x, y]
     * @param puntoFijo      3 Posiciones [cuadrante, x, y]
     * @return Retorna TRUE si esta dentro del cuadrante 2, en otro caso FALSO
     */
    private static boolean cuadrante2(double[] puntoAleatorio, double[] puntoFijo) {
        return puntoAleatorio[0] <= puntoFijo[1] && puntoAleatorio[1] >= puntoFijo[2];
    }

    /**
     * Funcion para saber si un punto esta dentro del cuadrante 3
     * @param puntoAleatorio 2 Posiciones [x, y]
     * @param puntoFijo      3 Posiciones [cuadrante, x, y]
     * @return Retorna TRUE si esta dentro del cuadrante 3, en otro caso FALSO
     */
    private static boolean cuadrante3(double[] puntoAleatorio, double[] puntoFijo) {
        return puntoAleatorio[0] <= puntoFijo[1] && puntoAleatorio[1] <= puntoFijo[2];
    }

    /**
     * Funcion para saber si un punto esta dentro del cuadrante 4
     * @param puntoAleatorio 2 Posiciones [x, y]
     * @param puntoFijo      3 Posiciones [cuadrante, x, y]
     * @return Retorna TRUE si esta dentro del cuadrante 4, en otro caso FALSO
     */
    private static boolean cuadrante4(double[] puntoAleatorio, double[] puntoFijo) {
        return puntoAleatorio[0] >= puntoFijo[1] && puntoAleatorio[1] <= puntoFijo[2];
    }

    /**
     * Funcion para crear los puntos aleatorios
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
     * Funcion para hallar el area de un rectangulo
     * @param base Recibe la base del rectangulo
     * @param altura Recibe la altura del rectangulo
     * @return Regresa el area del rectangulo
     */
    public static double areaRectangulo(double base, double altura){
        return base * altura;
    }

    //Base 8.9, altura 8.6
    public static double hallarAreaIrregular(int puntosDentroFigura, int cantidadPuntos, double baseRectangulo, double alturaRectangulo, String nombre){
        //Formula para el area
        double porcentajePuntosDentroFigura = puntosDentroFigura/ (double) cantidadPuntos;
//        System.out.println("Porcentaje de puntos: "+porcentajePuntosDentroFigura);
        //Area rectangulo
        double areaRectangulo = areaRectangulo(baseRectangulo, alturaRectangulo);
        double areaFigura = porcentajePuntosDentroFigura * areaRectangulo;
        System.out.println("El area de la figura " + nombre + " es: " + areaFigura + " Km2");
        return areaFigura;
    }

    /**
     * Funcion para imprimir los numeros
     */
    public static void imprimirNumerosAleatorios(double[][] numerosAleatorios) {
        for (double[] numerosAleatorio : numerosAleatorios) {
            System.out.println(Arrays.toString(numerosAleatorio));
        }
    }
}
