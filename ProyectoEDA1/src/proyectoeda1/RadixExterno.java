
package proyectoeda1;

import java.io.File;
import java.util.ArrayList;

public class RadixExterno {
   
    ArrayList<Persona> persLect = new ArrayList<>();
    ManejoArch mane = new ManejoArch();
   /*Para el algoritmode radix es necesario el uso de archivos por digito, considerando que el rango de valores para las claves es de [0-9] , tendremos un archivo extra para 
   poder almacenara la lista despues de las iteraciones sin necesidad de modificar el archivo base*/
    File archivo0= new File("Cola0.txt");
    File archivo1 = new File("Cola1.txt");
    File archivo2= new File("Cola2.txt");
    File archivo3= new File("Cola3.txt");
    File archivo4= new File("Cola4.txt");
    File archivo5= new File("Cola5.txt");
    File archivo6= new File("Cola6.txt");
    File archivo7= new File("Cola7.txt");
    File archivo8= new File("Cola8.txt");
    File archivo9= new File("Cola9.txt");
    File archivo11 = new File("Final.txt");
    
    
    public void radixExtrn(ArrayList<Persona> list){//list es de personas
       /* El metodo num 1 recibe como parametro la lista completa ya que necesita recorrer la lista orginial, para num2 en adelante se le pasa el archivo final que es donde 
       se ha hido guardando la lista despues de la iteración*/
        int n=list.size();
        num1(n,list);
        num2(n,mane.LecturaArch("Final.txt"));
        num3(n,mane.LecturaArch("Final.txt"));
        num4(n,mane.LecturaArch("Final.txt"));
        num5(n,mane.LecturaArch("Final.txt"));
        num6(n,mane.LecturaArch("Final.txt"));
        
        imprimir(mane.LecturaArch("Final.txt"));
    }
    
    public void num1(int n,ArrayList<Persona> list){
       /* La primera funcion trabajara con el digito menos significativo de todas las clases almacenara la clave del objeto en la variable aux y entrara en un ciclo for en el 
       cual se sacara el modulo 10 de la clave y se ejecutara el metodo ingresar, el cual recibe como parametros todos los archivos, la variable, la lista y la clave*/
        int aux;
        for(int i=0;i<n;i++){ //Unidades
            int var = Integer.parseInt(list.get(i).getClaves());   
            aux=var%10;
            ingresar1(aux,i,list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0); //ingresa a la cola 
            
        }
        extraer(list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0,archivo11); // concatena las claves en los archivos

    }
    public void num2(int n,ArrayList<Persona> list){
       /* Sigue le mismo procedimiento de num1, pero el modulo ahora es de 100 para poder trabajar con las decenas */
        int aux;
        for(int i=0;i<n;i++){ //Decenas
            int var = Integer.parseInt(list.get(i).getClaves()); 
            aux=var%100;
            ingresar2(aux,i,list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0);
        }
        extraer(list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0,archivo11);
    }
    public void num3(int n,ArrayList<Persona> list){ /* Trabaja con las centenas y las instrucciones fueron explicadas en num1*/
        int aux;
        for(int i=0;i<n;i++){ //Centenas
            int var = Integer.parseInt(list.get(i).getClaves());    
            aux=var%1000;
            ingresar3(aux,i,list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0);
        }
        extraer(list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0,archivo11);
    }
    public void num4(int n,ArrayList<Persona> list){ /*Trabaja con los millares y las instrucciones fueron explicadas en num1*/
        int aux;
        for(int i=0;i<n;i++){ //Millares
            int var = Integer.parseInt(list.get(i).getClaves());   
            aux=var%10000;
            ingresar4(aux,i,list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0);
        }
        extraer(list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0,archivo11);
    }
    public void num5(int n,ArrayList<Persona> list){ /*Trabaja con las decenas de millar y las instrucciones fueron explicadas en num1*/
        int aux;
        for(int i=0;i<n;i++){ //Decena de millar
            int var = Integer.parseInt(list.get(i).getClaves());  
            aux=var%100000;
            ingresar5(aux,i,list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0);
        }
        extraer(list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0,archivo11);
    }
    public void num6(int n,ArrayList<Persona> list){ /*Trabaja con las centenas de millar y las instrucciones fueron explicadas en num1**/
        int aux;
        for(int i=0;i<n;i++){ //Centena de millar
            int var = Integer.parseInt(list.get(i).getClaves());   
            aux=var%1000000;
            ingresar6(aux,i,list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0);
        }
        extraer(list,archivo1,archivo2,archivo3,archivo4,archivo5,archivo6,archivo7,archivo8,archivo9,archivo0,archivo11);
    }
    
    public void ingresar1(int x, int  iter,ArrayList<Persona> list,File ar1,File ar2,File ar3,File ar4,File ar5,File ar6,File ar7,File ar8,File ar9,File ar0){
        /* La funcion ingresar permite alacenar en una cola el elemento evaluado en num##, para los casos fue necesario el uso de condiciones if*/
        if(x==0){
            mane.escribirArch(list.get(iter),ar0);
        }else if(x==1){
            mane.escribirArch(list.get(iter),ar1);
        }else if(x==2){
           mane.escribirArch(list.get(iter),ar2);
        }else if(x==3){
            mane.escribirArch(list.get(iter),ar3);
        }else if(x==4){
            mane.escribirArch(list.get(iter),ar4);
        }else if(x==5){
            mane.escribirArch(list.get(iter),ar5);
        }else if(x==6){
            mane.escribirArch(list.get(iter),ar6);
        }else if(x==7){
           mane.escribirArch(list.get(iter),ar7);
        }else if(x==8){
            mane.escribirArch(list.get(iter),ar8);
        }else if(x==9){
            mane.escribirArch(list.get(iter),ar9);
        }
    }
    public void ingresar2(int x, int  iter,ArrayList<Persona> list,File ar1,File ar2,File ar3,File ar4,File ar5,File ar6,File ar7,File ar8,File ar9,File ar0){
       /*Ingresar dos trabaja igual al metodo anterior pero ahora con decenas*/
        if(x>=0 && x<=9){
            mane.escribirArch(list.get(iter),ar0);
        }else if(x>=10 && x<=19){
            mane.escribirArch(list.get(iter),ar1);
        }else if(x>=20 && x<=29){
            mane.escribirArch(list.get(iter),ar2);
        }else if(x>=30 && x<=39){
            mane.escribirArch(list.get(iter),ar3);
        }else if(x>=40 && x<=49){
            mane.escribirArch(list.get(iter),ar4);
        }else if(x>=50 && x<=59){
            mane.escribirArch(list.get(iter),ar5);
        }else if(x>=60 && x<=69){
            mane.escribirArch(list.get(iter),ar6);
        }else if(x>=70 && x<=79){
            mane.escribirArch(list.get(iter),ar7);
        }else if(x>=80 && x<=89){
            mane.escribirArch(list.get(iter),ar8);
        }else if(x>=90 && x<=99){
            mane.escribirArch(list.get(iter),ar9);
        }
    }
    public void ingresar3(int x, int  iter,ArrayList<Persona> list,File ar1,File ar2,File ar3,File ar4,File ar5,File ar6,File ar7,File ar8,File ar9,File ar0){
        if(x>=0 && x<=99){
            mane.escribirArch(list.get(iter),ar0);
        }else if(x>=100 && x<=199){
            mane.escribirArch(list.get(iter),ar1);
        }else if(x>=200 && x<=299){
            mane.escribirArch(list.get(iter),ar2);
        }else if(x>=300 && x<=399){
            mane.escribirArch(list.get(iter),ar3);
        }else if(x>=400 && x<=499){
            mane.escribirArch(list.get(iter),ar4);
        }else if(x>=500 && x<=599){
            mane.escribirArch(list.get(iter),ar5);
        }else if(x>=600 && x<=699){
            mane.escribirArch(list.get(iter),ar6);
        }else if(x>=700 && x<=799){
            mane.escribirArch(list.get(iter),ar7);
        }else if(x>=800 && x<=899){
            mane.escribirArch(list.get(iter),ar8);
        }else if(x>=900 && x<=999){
            mane.escribirArch(list.get(iter),ar9);
        }
    }
    public void ingresar4(int x, int  iter,ArrayList<Persona> list,File ar1,File ar2,File ar3,File ar4,File ar5,File ar6,File ar7,File ar8,File ar9,File ar0){
        if(x>=0 && x<=999){
            mane.escribirArch(list.get(iter),ar0);
        }else if(x>=1000 && x<=1999){
            mane.escribirArch(list.get(iter),ar1);
        }else if(x>=2000 && x<=2999){
            mane.escribirArch(list.get(iter),ar2);
        }else if(x>=3000 && x<=3999){
            mane.escribirArch(list.get(iter),ar3);
        }else if(x>=4000 && x<=4999){
            mane.escribirArch(list.get(iter),ar4);
        }else if(x>=5000 && x<=5999){
            mane.escribirArch(list.get(iter),ar5);
        }else if(x>=6000 && x<=6999){
            mane.escribirArch(list.get(iter),ar6);
        }else if(x>=7000 && x<=7999){
            mane.escribirArch(list.get(iter),ar7);
        }else if(x>=8000 && x<=8999){
            mane.escribirArch(list.get(iter),ar8);
        }else if(x>=9000 && x<=9999){
            mane.escribirArch(list.get(iter),ar9);
        }
    }
    public void ingresar5(int x, int  iter,ArrayList<Persona> list,File ar1,File ar2,File ar3,File ar4,File ar5,File ar6,File ar7,File ar8,File ar9,File ar0){
           if(x>=0 && x<=9999){
            mane.escribirArch(list.get(iter),ar0);
        }else if(x>=10000 && x<=19999){
            mane.escribirArch(list.get(iter),ar1);
        }else if(x>=20000 && x<=29999){
            mane.escribirArch(list.get(iter),ar2);
        }else if(x>=30000 && x<=39999){
            mane.escribirArch(list.get(iter),ar3);
        }else if(x>=40000 && x<=49999){
            mane.escribirArch(list.get(iter),ar4);
        }else if(x>=50000 && x<=59999){
            mane.escribirArch(list.get(iter),ar5);
        }else if(x>=60000 && x<=69999){
            mane.escribirArch(list.get(iter),ar6);
        }else if(x>=70000 && x<=79999){
            mane.escribirArch(list.get(iter),ar7);
        }else if(x>=80000 && x<=89999){
            mane.escribirArch(list.get(iter),ar8);
        }else if(x>=90000 && x<=99999){
            mane.escribirArch(list.get(iter),ar9);
        }
    }
    public void ingresar6(int x, int  iter,ArrayList<Persona> list,File ar1,File ar2,File ar3,File ar4,File ar5,File ar6,File ar7,File ar8,File ar9,File ar0){
        if(x>=0 && x<=99999){
            mane.escribirArch(list.get(iter),ar0);
        }else if(x>=100000 && x<=199999){
            mane.escribirArch(list.get(iter),ar1);
        }else if(x>=200000 && x<=299999){
            mane.escribirArch(list.get(iter),ar2);
        }else if(x>=300000 && x<=399999){
            mane.escribirArch(list.get(iter),ar3);
        }else if(x>=400000 && x<=499999){
            mane.escribirArch(list.get(iter),ar4);
        }else if(x>=500000 && x<=599999){
            mane.escribirArch(list.get(iter),ar5);
        }else if(x>=600000 && x<=699999){
            mane.escribirArch(list.get(iter),ar6);
        }else if(x>=700000 && x<=799999){
            mane.escribirArch(list.get(iter),ar7);
        }else if(x>=800000 && x<=899999){
            mane.escribirArch(list.get(iter),ar8);
        }else if(x>=900000 && x<=999999){
            mane.escribirArch(list.get(iter),ar9);
        }
    }
    
    
      
    public void extraer(ArrayList<Persona> list,File ar1,File ar2,File ar3,File ar4,File ar5,File ar6,File ar7,File ar8,File ar9,File ar0,File archFinal){
       /* Para el metodo extraee fue necesario conocer el tamaño del archivo en el que ya se han almacenado las claves, recorre estos archivos en orden y concatena las 
       claves en el archivo final*/
        long tamAr1=ManejoArch.tamanioArchivo(ar1);
        long tamAr2=ManejoArch.tamanioArchivo(ar2);
        long tamAr3=ManejoArch.tamanioArchivo(ar3);
        long tamAr4=ManejoArch.tamanioArchivo(ar4);
        long tamAr5=ManejoArch.tamanioArchivo(ar5);
        long tamAr6=ManejoArch.tamanioArchivo(ar6);
        long tamAr7=ManejoArch.tamanioArchivo(ar7);
        long tamAr8=ManejoArch.tamanioArchivo(ar8);
        long tamAr9=ManejoArch.tamanioArchivo(ar9);
        long tamAr0=ManejoArch.tamanioArchivo(ar0);
        int inic=0;
        //ManejoArch.borrar("Final.txt");        //Se debe vaciar para evitar acoplamiento de información
        for(int j=0;j<list.size();j++){
            
            if(tamAr0>0 ){
                mane.escribirArch(mane.lectura(ar0,inic,persLect),archFinal);
                inic+=1;
                tamAr0-=1;
                if(tamAr0==0){
                    ManejoArch.borrar("Cola0.txt"); // borra el archivo 
                    persLect.clear(); // borra el contenido de la cola
                    inic=0;
                }
            }else if(tamAr1>0 ){
                mane.escribirArch(mane.lectura(ar1,inic,persLect),archFinal);
                inic+=1;
                tamAr1-=1;
                if(tamAr1==0){
                    ManejoArch.borrar("Cola1.txt");
                    persLect.clear();
                    inic=0;
                }
            }else if(tamAr2>0 ){
                mane.escribirArch(mane.lectura(ar2,inic,persLect),archFinal);
                inic+=1;
                tamAr2-=1;
                if(tamAr2==0){
                    ManejoArch.borrar("Cola2.txt");
                    persLect.clear();
                    inic=0;
                }
            }else if(tamAr3>0 ){
                mane.escribirArch(mane.lectura(ar3,inic,persLect),archFinal);
                inic+=1;
                tamAr3-=1;
                if(tamAr3==0){
                    ManejoArch.borrar("Cola3.txt");
                    persLect.clear();
                    inic=0;
                }
            }else if(tamAr4>0 ){
                mane.escribirArch(mane.lectura(ar4,inic,persLect),archFinal);
                inic+=1;
                tamAr4-=1;
                if(tamAr4==0){
                    ManejoArch.borrar("Cola4.txt");
                    persLect.clear();
                    inic=0;
                }
            }else if(tamAr5>0 ){
                mane.escribirArch(mane.lectura(ar5,inic,persLect),archFinal);
                inic+=1;
                tamAr5-=1;
                if(tamAr5==0){
                    ManejoArch.borrar("Cola5.txt");
                    persLect.clear();
                    inic=0;
                }
            }else if(tamAr6>0 ){
                mane.escribirArch(mane.lectura(ar6,inic,persLect),archFinal);
                inic+=1;
                tamAr6-=1;
                if(tamAr6==0){
                    ManejoArch.borrar("Cola6.txt");
                    persLect.clear();
                    inic=0;
                }
            }else if(tamAr7>0 ){
                mane.escribirArch(mane.lectura(ar7,inic,persLect),archFinal);
                inic+=1;
                tamAr7-=1;
                if(tamAr7==0){
                    ManejoArch.borrar("Cola7.txt");
                    persLect.clear();
                    inic=0;
                }
            }else if(tamAr8>0 ){
                mane.escribirArch(mane.lectura(ar8,inic,persLect),archFinal);
                inic+=1;
                tamAr8-=1;
                if(tamAr8==0){
                    ManejoArch.borrar("Cola8.txt");
                    persLect.clear();
                    inic=0;
                }
            }else if(tamAr9>0 ){
                mane.escribirArch(mane.lectura(ar9,inic,persLect),archFinal);
                inic+=1;
                tamAr9-=1;
                if(tamAr9==0){
                    ManejoArch.borrar("Cola9.txt");
                    persLect.clear();
                    inic=0;
                }
            }
        }
        
        
    }    
    public void imprimir(ArrayList<Persona> list){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).getClaves()+" ");
            System.out.print(list.get(i).getNombre()+" ");
            System.out.println(list.get(i).getApellidos());
            
        }
    }
}
