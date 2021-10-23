
package proyectoeda1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RadixExterno {
   
    ArrayList<Persona> persLect = new ArrayList<>();         
    ManejoArch mane = new ManejoArch();
    File archivo0= new File("Cola0.txt");   //archivos auxiliares que permiten separar las claves dependiendo del numero evaluado, sustituyen las colas del radix interno
    File archivo1= new File("Cola1.txt");   //se usan 10 archivos pues el rango de numeros de las claves es de [0-9], se usará un archivo11 donde se guardara el archivo ya ordenado 
    File archivo2= new File("Cola2.txt");
    File archivo3= new File("Cola3.txt");
    File archivo4= new File("Cola4.txt");
    File archivo5= new File("Cola5.txt");
    File archivo6= new File("Cola6.txt");
    File archivo7= new File("Cola7.txt");
    File archivo8= new File("Cola8.txt");
    File archivo9= new File("Cola9.txt");
    File archivo11 = new File("Final.txt"); //archivo auxiliar que permite ver los cambios sin modificar el archivo original
    
    
    public void radixExtrn(ArrayList<Persona> list){//list es de personas
        int n=list.size(); //los datos del archivo son guardados en una lista y n es el tamaño de esta misma
        num1(n,list);      /* el metodo num1 es el unico que recibe como parametro la lista original, como en radix sort la siguiente iteracion se hace con la lista ordenada 
        en la iteracion anterior el metodo num 2 recibira la lista ordenada de la iteracion 1*/
        num2(n,mane.LecturaArch("Final.txt"));  //en este caso la lista ya ordenada fue escrita en el documento de texto "final.txt"
        num3(n,mane.LecturaArch("Final.txt"));
        num4(n,mane.LecturaArch("Final.txt"));
        num5(n,mane.LecturaArch("Final.txt"));
        num6(n,mane.LecturaArch("Final.txt"));
    }
    
    public void num1(int n,ArrayList<Persona> list){ // este metodo trabajara con el elemento menos significativo de una clave es decir las unidades
        int aux; //el uso del auxiliar se utilizara para guardar el valor de la unidad y hacer la comparación
        for(int i=0;i<n;i++){ //Unidades
            int var = Integer.parseInt(list.get(i).getClaves());    //Para String - var guardara la clave de la posicion i
            aux=var%10; //el modulo 10 de la variable sera el elemento menos significativo 
            /* El metodo ingresar permitira clasificar la clave para ingresarla posteriormente a una cola, este metodo recibe como parametro la posicion y el auxiliar */
            ingresar1(aux,i,list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0);
            
        }
        extraer(list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0,archivo11); 
       /* Metodo que permite hacer la concatenacion de todas las colas por iteración, por ello esta misma linae esta declarada en todos los metodos num## */ 

    }
    public void num2(int n,ArrayList<Persona> list){ //realiza la misma funcion que la num1, ahora se trabaja con decenas
        int aux;
        for(int i=0;i<n;i++){ //Decenas
            int var = Integer.parseInt(list.get(i).getClaves()); 
            aux=var%100;
            ingresar2(aux,i,list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0);
        }
        extraer(list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0,archivo11);
    }
    public void num3(int n,ArrayList<Persona> list){ //CENTENAS
        int aux;
        for(int i=0;i<n;i++){ //Centenas
            int var = Integer.parseInt(list.get(i).getClaves());    
            aux=var%1000;
            ingresar3(aux,i,list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0);
        }
        extraer(list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0,archivo11);
    }
    public void num4(int n,ArrayList<Persona> list){ //MILLARES
        int aux;
        for(int i=0;i<n;i++){ //Millares
            int var = Integer.parseInt(list.get(i).getClaves());    //Para String
            aux=var%10000;
            ingresar4(aux,i,list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0);
        }
        extraer(list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0,archivo11);
    }
    public void num5(int n,ArrayList<Persona> list){ //DECENAS DE MILLAR 
        int aux;
        for(int i=0;i<n;i++){ //Decena de millar
            int var = Integer.parseInt(list.get(i).getClaves());    //Para String
            aux=var%100000;
            ingresar5(aux,i,list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0);
        }
        extraer(list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0,archivo11);
    }
    public void num6(int n,ArrayList<Persona> list){ //CENTENAS DE MILLAR 
        int aux;
        for(int i=0;i<n;i++){ //Centena de millar
            int var = Integer.parseInt(list.get(i).getClaves());    //Para String
            aux=var%1000000;
            ingresar6(aux,i,list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0);
        }
        extraer(list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0,archivo11);
    }
    
    public void ingresar1(int x, int  iter,ArrayList<Persona> list,File ar1,File ar2,File ar3,File ar4,File ar5,File ar6,File ar7,File ar8,File ar9,File ar0){
        /*Una vez ingresado el valor de x, en este caso la unidad, se validan los if y cuando se cumple una de las condiciones pasa al metodo escribirArch, el cual 
        permite eccribir a todo el objeto sin sobreescribir, funciona para la primera iteracion del algoritmo es decir todas las unidades de 0 a 9*/
        if(x==0){
            escribirArch(list.get(iter),ar0);
        }else if(x==1){
            escribirArch(list.get(iter),ar1);
        }else if(x==2){
           escribirArch(list.get(iter),ar2);
        }else if(x==3){
            escribirArch(list.get(iter),ar3);
        }else if(x==4){
            escribirArch(list.get(iter),ar4);
        }else if(x==5){
            escribirArch(list.get(iter),ar5);
        }else if(x==6){
            escribirArch(list.get(iter),ar6);
        }else if(x==7){
           escribirArch(list.get(iter),ar7);
        }else if(x==8){
            escribirArch(list.get(iter),ar8);
        }else if(x==9){
            escribirArch(list.get(iter),ar9);
        }
    }
    public void ingresar2(int x, int  iter,ArrayList<Persona> list,File ar1,File ar2,File ar3,File ar4,File ar5,File ar6,File ar7,File ar8,File ar9,File ar0){
       /* Tiene la misma funcion de ingresar1, solo que los rangos de los if ahora seran en un rango de [0-99]*/
        if(x>=0 && x<=9){
            escribirArch(list.get(iter),ar0);
        }else if(x>=10 && x<=19){
            escribirArch(list.get(iter),ar1);
        }else if(x>=20 && x<=29){
            escribirArch(list.get(iter),ar2);
        }else if(x>=30 && x<=39){
            escribirArch(list.get(iter),ar3);
        }else if(x>=40 && x<=49){
            escribirArch(list.get(iter),ar4);
        }else if(x>=50 && x<=59){
            escribirArch(list.get(iter),ar5);
        }else if(x>=60 && x<=69){
            escribirArch(list.get(iter),ar6);
        }else if(x>=70 && x<=79){
            escribirArch(list.get(iter),ar7);
        }else if(x>=80 && x<=89){
            escribirArch(list.get(iter),ar8);
        }else if(x>=90 && x<=99){
            escribirArch(list.get(iter),ar9);
        }
    }
    public void ingresar3(int x, int  iter,ArrayList<Persona> list,File ar1,File ar2,File ar3,File ar4,File ar5,File ar6,File ar7,File ar8,File ar9,File ar0){
        if(x>=0 && x<=99){
            escribirArch(list.get(iter),ar0);
        }else if(x>=100 && x<=199){
            escribirArch(list.get(iter),ar1);
        }else if(x>=200 && x<=299){
            escribirArch(list.get(iter),ar2);
        }else if(x>=300 && x<=399){
            escribirArch(list.get(iter),ar3);
        }else if(x>=400 && x<=499){
            escribirArch(list.get(iter),ar4);
        }else if(x>=500 && x<=599){
            escribirArch(list.get(iter),ar5);
        }else if(x>=600 && x<=699){
            escribirArch(list.get(iter),ar6);
        }else if(x>=700 && x<=799){
            escribirArch(list.get(iter),ar7);
        }else if(x>=800 && x<=899){
            escribirArch(list.get(iter),ar8);
        }else if(x>=900 && x<=999){
            escribirArch(list.get(iter),ar9);
        }
    }
    public void ingresar4(int x, int  iter,ArrayList<Persona> list,File ar1,File ar2,File ar3,File ar4,File ar5,File ar6,File ar7,File ar8,File ar9,File ar0){
        if(x>=0 && x<=999){
            escribirArch(list.get(iter),ar0);
        }else if(x>=1000 && x<=1999){
            escribirArch(list.get(iter),ar1);
        }else if(x>=2000 && x<=2999){
            escribirArch(list.get(iter),ar2);
        }else if(x>=3000 && x<=3999){
            escribirArch(list.get(iter),ar3);
        }else if(x>=4000 && x<=4999){
            escribirArch(list.get(iter),ar4);
        }else if(x>=5000 && x<=5999){
            escribirArch(list.get(iter),ar5);
        }else if(x>=6000 && x<=6999){
            escribirArch(list.get(iter),ar6);
        }else if(x>=7000 && x<=7999){
            escribirArch(list.get(iter),ar7);
        }else if(x>=8000 && x<=8999){
            escribirArch(list.get(iter),ar8);
        }else if(x>=9000 && x<=9999){
            escribirArch(list.get(iter),ar9);
        }
    }
    public void ingresar5(int x, int  iter,ArrayList<Persona> list,File ar1,File ar2,File ar3,File ar4,File ar5,File ar6,File ar7,File ar8,File ar9,File ar0){
           if(x>=0 && x<=9999){
            escribirArch(list.get(iter),ar0);
        }else if(x>=10000 && x<=19999){
            escribirArch(list.get(iter),ar1);
        }else if(x>=20000 && x<=29999){
            escribirArch(list.get(iter),ar2);
        }else if(x>=30000 && x<=39999){
            escribirArch(list.get(iter),ar3);
        }else if(x>=40000 && x<=49999){
            escribirArch(list.get(iter),ar4);
        }else if(x>=50000 && x<=59999){
            escribirArch(list.get(iter),ar5);
        }else if(x>=60000 && x<=69999){
            escribirArch(list.get(iter),ar6);
        }else if(x>=70000 && x<=79999){
            escribirArch(list.get(iter),ar7);
        }else if(x>=80000 && x<=89999){
            escribirArch(list.get(iter),ar8);
        }else if(x>=90000 && x<=99999){
            escribirArch(list.get(iter),ar9);
        }
    }
    public void ingresar6(int x, int  iter,ArrayList<Persona> list,File ar1,File ar2,File ar3,File ar4,File ar5,File ar6,File ar7,File ar8,File ar9,File ar0){
        if(x>=0 && x<=99999){
            escribirArch(list.get(iter),ar0);
        }else if(x>=100000 && x<=199999){
            escribirArch(list.get(iter),ar1);
        }else if(x>=200000 && x<=299999){
            escribirArch(list.get(iter),ar2);
        }else if(x>=300000 && x<=399999){
            escribirArch(list.get(iter),ar3);
        }else if(x>=400000 && x<=499999){
            escribirArch(list.get(iter),ar4);
        }else if(x>=500000 && x<=599999){
            escribirArch(list.get(iter),ar5);
        }else if(x>=600000 && x<=699999){
            escribirArch(list.get(iter),ar6);
        }else if(x>=700000 && x<=799999){
            escribirArch(list.get(iter),ar7);
        }else if(x>=800000 && x<=899999){
            escribirArch(list.get(iter),ar8);
        }else if(x>=900000 && x<=999999){
            escribirArch(list.get(iter),ar9);
        }
    }
    
    
      
    public void extraer(ArrayList<Persona> list,File ar1,File ar2,File ar3,File ar4,File ar5,File ar6,File ar7,File ar8,File ar9,File ar0,File archFinal){
       /* Permite la concatenacion de las colas en el archivo final */
        long tamAr1=tamanioArchivo(ar1); // contabiliza el tamaño de la cola por medio de tamanioArchivo
        long tamAr2=tamanioArchivo(ar2);
        long tamAr3=tamanioArchivo(ar3);
        long tamAr4=tamanioArchivo(ar4);
        long tamAr5=tamanioArchivo(ar5);
        long tamAr6=tamanioArchivo(ar6);
        long tamAr7=tamanioArchivo(ar7);
        long tamAr8=tamanioArchivo(ar8);
        long tamAr9=tamanioArchivo(ar9);
        long tamAr0=tamanioArchivo(ar0);
        int inic=0;
        borrar("Final.txt");        //Se debe vaciar para evitar acoplamiento de información
        for(int j=0;j<list.size();j++){
            /* La concatenacion se realiza archivo por archivo, con el fin de devolverlo ordenado, el mismo proceso de la primera comparación se repite en los if-else */
            if(tamAr0>0 ){
                escribirArch(lectura(ar0,inic),archFinal);
                inic+=1;
                tamAr0-=1;// resta 1 al valor del tamaño
                if(tamAr0==0){ //cuando el archivo que almacena estos valores esta vacío se elimina tanto la cola como el archivo
                    borrar("Cola0.txt");
                    persLect.clear();
                    inic=0; // se incicializa de nuevo el contador inic
                }
            }else if(tamAr1>0 ){
                escribirArch(lectura(ar1,inic),archFinal);
                inic+=1;
                tamAr1-=1;
                if(tamAr1==0){
                    borrar("Cola1.txt");
                    persLect.clear();
                    inic=0;
                }
            }else if(tamAr2>0 ){
                escribirArch(lectura(ar2,inic),archFinal);
                inic+=1;
                tamAr2-=1;
                if(tamAr2==0){
                    borrar("Cola2.txt");
                    persLect.clear();
                    inic=0;
                }
            }else if(tamAr3>0 ){
                escribirArch(lectura(ar3,inic),archFinal);
                inic+=1;
                tamAr3-=1;
                if(tamAr3==0){
                    borrar("Cola3.txt");
                    persLect.clear();
                    inic=0;
                }
            }else if(tamAr4>0 ){
                escribirArch(lectura(ar4,inic),archFinal);
                inic+=1;
                tamAr4-=1;
                if(tamAr4==0){
                    borrar("Cola4.txt");
                    persLect.clear();
                    inic=0;
                }
            }else if(tamAr5>0 ){
                escribirArch(lectura(ar5,inic),archFinal);
                inic+=1;
                tamAr5-=1;
                if(tamAr5==0){
                    borrar("Cola5.txt");
                    persLect.clear();
                    inic=0;
                }
            }else if(tamAr6>0 ){
                escribirArch(lectura(ar6,inic),archFinal);
                inic+=1;
                tamAr6-=1;
                if(tamAr6==0){
                    borrar("Cola6.txt");
                    persLect.clear();
                    inic=0;
                }
            }else if(tamAr7>0 ){
                escribirArch(lectura(ar7,inic),archFinal);
                inic+=1;
                tamAr7-=1;
                if(tamAr7==0){
                    borrar("Cola7.txt");
                    persLect.clear();
                    inic=0;
                }
            }else if(tamAr8>0 ){
                escribirArch(lectura(ar8,inic),archFinal);
                inic+=1;
                tamAr8-=1;
                if(tamAr8==0){
                    borrar("Cola8.txt");
                    persLect.clear();
                    inic=0;
                }
            }else if(tamAr9>0 ){
                escribirArch(lectura(ar9,inic),archFinal);
                inic+=1;
                tamAr9-=1;
                if(tamAr9==0){
                    borrar("Cola9.txt");
                    persLect.clear();
                    inic=0;
                }
            }
        }
    }
        
    public long tamanioArchivo(File archivoAMedir){
       /* */
        long tam=0;
        try {
            FileReader fr = new FileReader(archivoAMedir);
            BufferedReader bf = new BufferedReader(fr); //BufferedReader sirve para leer un archivo 
            tam=bf.lines().count(); 
           //tam es un contador igualado a la lectura del archivo BufferedReader y con .lines hace saltos de linea y .count sirve para contabilizar los saltos de linea
        } catch (FileNotFoundException ex) {
            System.out.println("No se registró una cola de tal número");
        }
       
        return tam;
    }
    public void borrar(String archAVaciar){
        try {
            PrintWriter pw = new PrintWriter(archAVaciar);
            pw.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo borrar");
        }        
    }
    
    public Persona lectura(File archivo,int i) {
        Scanner stdIn = new Scanner(System.in);
        Scanner fileIn;
        String line;
        String[] cadena;
        Persona persona=new Persona("","","");
        try {
            fileIn = new Scanner(new FileReader(archivo));
            while (fileIn.hasNextLine()) {
                line = fileIn.nextLine();
                cadena=line.split(",");

                persona = new Persona(cadena[0],cadena[1],cadena[2]); //permite que los atributos pasen individualmente a un arreglo sin perder su integridad 
                persLect.add(persona);
            }
            fileIn.close();
        }catch (FileNotFoundException e){
            System.out.println("Error: " );
        } 
        return persLect.get(i);

    }
    public void escribirArch(Persona personas,File archColas) {
        try {
            FileWriter escribir = new FileWriter(archColas,true);        //True permite añadir en la última posición
                escribir.write(personas.getNombre()+",");
                escribir.write(personas.getApellidos()+",");
                escribir.write(personas.getClaves()+",,"+"\n");  
                escribir.close();
        }catch (IOException e){
            System.out.println("Algo salió mal en la escritura de tu archivo.");
            e.printStackTrace();
        }
    }
    
}
