import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1)Yago
        char[][] matriz= new char[10][10];
        //2)Sergio
        int vidas=10;
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

        Scanner lector = new Scanner(System.in);

        System.out.println("Dime una letra: ");
        char desplazamiento = lector.next().charAt(0);
        System.out.println("La letra elegida es "+ desplazamiento);

        int filaYoda=0;
        int columnaYoda=0;

        matriz[filaYoda][columnaYoda] = YODA;
        if (desplazamiento == 'D'){
            columnaYoda++;
            matriz[filaYoda][columnaYoda] = YODA;
        }

        for (int fila = 0; fila < matriz.length ; fila++) {
            for (int columna = 0; columna < matriz.length ; columna++) {
                System.out.print(matriz[fila][columna] + " ");
            }
            System.out.println(" ");
        }
    }
}