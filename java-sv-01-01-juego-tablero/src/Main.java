import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1)Yago
        char[][] matriz= new char[10][10];
        //2)Sergio
        int vidas=1;
        // 3)Dani

        for (int fila = 0; fila < matriz.length ; fila++) {
            for (int columna = 0; columna < matriz.length ; columna++) {
                matriz[fila][columna]='*';
            }
        }

        char YODA='Y';
        matriz[0][0]= YODA;

        char CASILLA_FINAL='F';
        matriz[9][9]= CASILLA_FINAL;

        Random aleatorio =new Random();
        int n1= aleatorio.nextInt(10);
        int n2= aleatorio.nextInt(10);
        matriz[n1][n2]='M';

        for (int i = 0; i < 5; i++) {
            do{
                n1= aleatorio.nextInt(10);
                n2= aleatorio.nextInt(10);
            } while (matriz[n1][n2]!='*');
            matriz[n1][n2]='P';
        }

        System.out.println("Tu jugador de encuentra en la casilla 0,0");
        System.out.println("Te puedes desplazar con las letras W A S D");

        Scanner teclado = new Scanner(System.in);

        int filaYoda=0;
        int columnaYoda=0;
        boolean printTablero;
        matriz[filaYoda][columnaYoda] = YODA;
        do{
            System.out.println("Dime una letra: ");
            char desplazamiento = teclado.next().charAt(0);
            printTablero = true;

            if(desplazamiento == 'D'){ //columna = 9
                columnaYoda++;            // columna=10
            }else if(desplazamiento == 'S') {
                filaYoda++;
            }else if(desplazamiento == 'W') {
                filaYoda--;
            }else if(desplazamiento == 'A') {
                columnaYoda--;
            }
            if(filaYoda < 0 || filaYoda > 9 || columnaYoda < 0 || columnaYoda > 9){
                System.out.println("Fuera de límites !!!");
                printTablero = false;
            }else{
                if(matriz[filaYoda][columnaYoda] == 'M'){
                    vidas--;
                    break;
                }
                if(desplazamiento == 'D'){
                    matriz[filaYoda][columnaYoda - 1] = '*';
                    matriz[filaYoda][columnaYoda] = YODA;
                }else if(desplazamiento == 'S') {
                    matriz[filaYoda - 1][columnaYoda] = '*';
                    matriz[filaYoda][columnaYoda] = YODA;
                }else if(desplazamiento == 'W') {
                    matriz[filaYoda + 1][columnaYoda] = '*';
                    matriz[filaYoda][columnaYoda] = YODA;
                }else if(desplazamiento == 'A') {
                    matriz[filaYoda][columnaYoda + 1] = '*';
                    matriz[filaYoda][columnaYoda] = YODA;
                }
            }

            if(columnaYoda > 9){
                columnaYoda--;
            }else if(columnaYoda < 0){
                columnaYoda++;
            } else if (filaYoda > 9) {
                filaYoda--;
            } else if (filaYoda < 0) {
                filaYoda++;
            }

            if(printTablero){
                for (int fila = 0; fila < matriz.length; fila++) {
                    for (int columna = 0; columna < matriz.length; columna++) {
                        System.out.print(matriz[fila][columna] + "  ");
                    }
                    System.out.println(" ");
                }
            }
        }while (true);
        System.out.println("GAME OVER");
    }
}