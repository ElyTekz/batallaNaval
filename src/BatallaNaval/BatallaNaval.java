
package BatallaNaval;

import java.util.Scanner;

public class BatallaNaval {
   Scanner dato = new Scanner(System.in);
    
    String[][] tabla = new String[8][8]; //matriz que se muestra al usuario
    int[][] juego = new int[8][8]; //Matriz que tiene los barcos y el agua
    
    int iBarco = 1; // iterador que va a tener el numero de barco;
    
    //Metodo para cargar los 2 barcos de 2 posiciones
    public void cargarBarcoMed(){
        
        for(int x=0; x<2; x++){     //En este for controlamos que se repita 2 veces, para crear 2 barcos
        
            int i=0;    //Este i es el que va a ser el iterador en el while
            
            int n1 = (int) (Math.random() * 8); //Me da el random que usare para la FILA
            int n2 = (int) (Math.random() * 8); //Me da el random que usare para la COLUMNA
        
        //Muestro el punto x & y donde se ubica el centro de mi barco   
        /*System.out.println("Fila: "+n1);
        System.out.println("Columna: "+n2);*/
            
            if(juego[n1][n2] == 0){ //Si juego(matriz) en esa posicion es 0 significa que le puedo poner un 1
                juego[n1][n2] = iBarco;//En caso de que no sea 0 tengo que volver a ciclar el for par que me de 2 numeros
                                    //aleatorios nuevamente y comprobar si son 0 para proseguir a la sig instruccion
                                    //si no es 0 el else tira un x-- asi el for hace como que nunca avanzo
            while(i<1){
                int n3 = (int) (Math.random() * 8) + 1;//Este random va a elegir la pos en donde ira el otro punto
            
            //System.out.println(n3); //imprimo el punto para controlar|
            
                switch(n3){

                    case 1: if((n1 != 0) && (n2 != 0) && (juego[n1-1][n2-1] == 0)){
                                juego[n1-1][n2-1] = iBarco;
                                i++; iBarco++;
                            }
                            break;

                    case 2: if((n1 != 0) && (juego[n1-1][n2] == 0)){
                                juego[n1-1][n2] = iBarco;
                                i++; iBarco++;
                            }
                            break;

                    case 3: if((n1 != 0) && (n2 != 7) && (juego[n1-1][n2+1] == 0)){
                                juego[n1-1][n2+1] = iBarco;
                                i++; iBarco++;
                            } 
                            break;

                    case 4: if((n2 != 0) && (juego[n1][n2-1] == 0)){
                                juego[n1][n2-1] = iBarco;
                                i++; iBarco++;
                            }
                            break;

                    case 5: if((n2 != 7) && (juego[n1][n2+1] == 0)){
                                juego[n1][n2+1] = iBarco;
                                i++; iBarco++;
                            }
                            break;

                    case 6: if((n1 != 7) && (n2 != 0) && (juego[n1+1][n2-1] == 0)){
                                juego[n1+1][n2-1] = iBarco;
                                i++; iBarco++;
                            }
                                break;

                    case 7: if((n1 != 7) && (juego[n1+1][n2] == 0)){
                                juego[n1+1][n2] = iBarco;
                                i++; iBarco++;
                            } 
                            break;

                    case 8: if((n1 != 7) && (n2 != 7) && (juego[n1+1][n2+1] == 0)){
                                juego[n1+1][n2+1] = iBarco;
                                i++; iBarco++;
                            } 
                            break;
                }
            
            }    
             
            }
            else{
                x--;
            }
            
        }
    }    
    
    public void cargarBarcoGran() {
    for (int x = 0; x < 2; x++) {
        int i = 0;
        int n1 = (int) (Math.random() * 8); // Obtengo la posición central del barco
        int n2 = (int) (Math.random() * 8);
        /*System.out.println("Fila: " + n1);
        System.out.println("Columna: " + n2);*/

        if ((juego[n1][n2] == 0) && !(n1 == 7 && n2 == 7) && !(n1 == 0 && n2 == 0) && !(n1 == 0 && n2 == 7) && !(n1 == 7 && n2 == 0)
                && posicionAdyacente(n1 - 1, n2) && posicionAdyacente(n1 + 1, n2) && posicionAdyacente(n1, n2 - 1) && posicionAdyacente(n1, n2 + 1)
                && (juego[n1 - 1][n2] == 0) && (juego[n1 + 1][n2] == 0) && (juego[n1][n2 - 1] == 0) && (juego[n1][n2 + 1] == 0)) {
            juego[n1][n2] = iBarco;

            while (i < 1) {
                    
                    int n3 = (int) (Math.random() * 4) + 1;
                    //System.out.println("Random: "+n3);
                    
                    switch(n3){
                        case 1: if((n1 != 0) && (n2 != 0) && (n1 != 7) && (n2 != 7) && (juego[n1-1][n2-1] == 0) && (juego[n1+1][n2+1] == 0)){
                                    juego[n1-1][n2-1] = iBarco;
                                    juego[n1+1][n2+1] = iBarco;
                                    i++; iBarco++;
                                }
                                break;
                                
                        case 2: if((n1 != 0) && (n1 != 7) && (juego[n1-1][n2] == 0) && (juego[n1+1][n2] == 0)){
                                    juego[n1-1][n2] = iBarco;
                                    juego[n1+1][n2] = iBarco;
                                    i++; iBarco++;
                                }
                                break;
                                
                        case 3: if((n1!=0) && (n2!=7) && (n1!=7) && (n2!=0) && (juego[n1-1][n2+1] == 0) && (juego[n1+1][n2-1] == 0)){
                                    juego[n1-1][n2+1] = iBarco;
                                    juego[n1+1][n2-1] = iBarco;
                                    i++; iBarco++;
                                }
                                break;
                                
                        case 4: if((n2!=0) && (n2!=7) && (juego[n1][n2-1] == 0) && (juego[n1][n2+1] == 0)){
                                    juego[n1][n2-1] = iBarco;
                                    juego[n1][n2+1] = iBarco;
                                    i++; iBarco++;
                                }
                                break;
                    }
                }
            }
            else{
                x--;
            }
          
        }
        
    }
    
    private boolean posicionAdyacente(int fila, int columna) {
    //tabla.lenght  me retonar cantidad de filas, si le agrego tabla en posicion 0 me retorna cantidad de columnas
    //en esa fila que seria la misma para todas
    if (fila >= 0 && fila < juego.length && columna >= 0 && columna < juego[0].length) {
        //si fila y columna estan dentro de los parametros de la matriz se entra al if
        //aca verificamos si tabla en fila y columna es null, en caso positivo retornamos true 
        if(juego[fila][columna] == 0){
          return true;   
        }
    }
    return false; //si no retorna el true retorna el false, debido a que no puede retornar 2 cosas
    }
    
    
    public void cargarMar(){
        for(int i=0; i<8; i++){
            for(int x=0; x<8; x++){
                if(tabla[i][x] == null){
                    tabla[i][x] = "0";
                }
            }
        }
    }
    
    public void mostrarTabla(){
        int x=0;
        
        System.out.println("\n1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 |_");
        for(int i=0; i<8; i++){
            for( x=0; x<8; x++){
                System.out.print(tabla[i][x]+" | ");
            }
            System.out.println(""+(i+1));
        }
        
        /* para mostrar la ubicacion de los barcos(prueba)
        System.out.println("\n\n1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 |_");
        for(int i=0; i<8; i++){
            for( x=0; x<8; x++){
                System.out.print(juego[i][x]+" | ");
            }
            System.out.println(""+(i+1));
        }
        */
    }
    
    public void jugadas(){
        int barco1 = 0, barco2= 0, barco3= 0, barco4 = 0; //Variable de los barcos
        int horizontal, vertical;
        int contadorJugadas=0;
        
        do{
        
        System.out.print("\nDigite un valor en el eje horizontal(FILA): ");
        vertical = dato.nextInt();
        vertical--;
        System.out.print("Digite un valor en el eje vertical(COLUMNA): ");
        horizontal  = dato.nextInt();
        horizontal--;
            
            //Verifico si la posicion esta dentro de los limites de la matriz
            if (vertical >= 0 && vertical < juego.length && horizontal >= 0 && horizontal < juego[0].length) {
            
                if ((!tabla[vertical][horizontal].equals("X")) && (!tabla[vertical][horizontal].equals("@"))) {
                    System.out.println("");

                    switch(juego[vertical][horizontal]){

                        case 1: System.out.println("Le diste a un barco MEDIANO");
                                tabla[vertical][horizontal] = "@";
                                barco1++;
                                if(barco1==2){
                                    System.out.println("Haz destrudio un BARCO MEDIANO");
                                }
                                break;

                        case 2: System.out.println("Le diste a un barco MEDIANO");
                                tabla[vertical][horizontal] = "@";
                                barco2++;
                                if(barco2==2){
                                    System.out.println("Haz destrudio un BARCO MEDIANO");
                                }
                                break;

                        case 3: System.out.println("Le diste a un barco GRANDE");
                                tabla[vertical][horizontal] = "@";
                                barco3++;
                                if(barco3==3){
                                    System.out.println("Haz destrudio un BARCO GRANDE");
                                }
                                break;

                        case 4: System.out.println("Le diste a un barco GRANDE");
                                tabla[vertical][horizontal] = "@";
                                barco4++;
                                if(barco4==3){
                                    System.out.println("Haz destrudio un BARCO GRANDE");
                                }
                                break;

                        default: System.out.println("Tiro al AGUA. Segui intentando! ");   
                                tabla[vertical][horizontal] = "X";
                                break;
                                }

                    //Muestro la tabla actualizada cuando termine esto voy a llamar al metodo mostrar tabla para menos codigo pai
                    /*System.out.println("1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 |_");
                    for(int i=0; i<8; i++){
                        for(int x=0; x<8; x++){
                            System.out.print(tabla[i][x]+" | ");
                        }
                    System.out.println(""+(i+1));
                    }*/
                    mostrarTabla();
                    contadorJugadas++; //Cuento las jugadas que ha realizado el usuario
                }
                else{
                    System.out.println("\nEsa posicion ya fue jugada. Intente Nuevamente");
                }
            } 
            else{
                System.out.println("\nPosición inválida(Fuera de la matriz). Intente Nuevamente");
            }    
            
        }while(barco1!=2 || barco2!=2 || barco3!=3 || barco4!=3); //Esto se repetira siempre y cuando almenos una
                                                            //de las variables no haya alcanzado su valor respectivo
        
        if(contadorJugadas < 16){
            System.out.println("Excelente. Eres una LEYENDA estas entre los mejores jugadores");
        }
        else{
            if(contadorJugadas < 31){
                System.out.println("Casi Perfecto. Eres un MAESTRO en la batalla naval");
            }
            else{
                if(contadorJugadas < 47){
                    System.out.println("No te rindas. Eres un NOVATO pero vas por buen camino");
                }
                else{
                    System.out.println("Aun te falta mucho por aprender PRINCIPIANTE");
                }
            }
        }
    }
    
    public static void main(String[] args){
        BatallaNaval b1 = new BatallaNaval();
        
        //System.out.println("\nBarco Mediano");
        b1.cargarBarcoMed();
        //System.out.println("\nBarco grande");
        b1.cargarBarcoGran();
        
        b1.cargarMar();
        b1.mostrarTabla();
        b1.jugadas();
        
    } 
}
