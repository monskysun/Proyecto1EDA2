
package proyectoeda1;

import java.util.ArrayList;
import java.util.LinkedList;

public class RadixExterno {
    LinkedList cola0 = new LinkedList();
    LinkedList cola1 = new LinkedList();
    LinkedList cola2 = new LinkedList();
    LinkedList cola3 = new LinkedList();
    LinkedList cola4 = new LinkedList();
    LinkedList cola5 = new LinkedList();
    LinkedList cola6 = new LinkedList();
    LinkedList cola7 = new LinkedList();
    LinkedList cola8 = new LinkedList();
    LinkedList cola9 = new LinkedList();

    public void radixExtrn(ArrayList<Persona> list){//list es de personas
        int n=list.size();
        System.out.println("\nIteración 1 (Ordenamiento por unidades)");
        num1(n,list);
//        imprimir(list);
//        System.out.println("------------------");
    
        num2(n,list);
        num3(n,list);
        num4(n,list);
        num5(n,list);
        num6(n,list);
        imprimir(list);
    }
    
    public void num1(int n,ArrayList<Persona> list){
        int aux;
        //imprimir(list);
        for(int i=0;i<n;i++){ //Unidades
        	//System.out.print("*****--"+list.get(i).getClaves() );
            int var = Integer.parseInt(list.get(i).getClaves());    //Para String
            aux=var%10;
            ingresar1(aux,i,list,cola1,cola2,cola3,cola4,cola5,cola6,cola7,cola8,cola9,cola0);
            
        }
        System.out.println(cola1);
        extraer(list,cola1,cola2,cola3,cola4,cola5,cola6,cola7,cola8,cola9,cola0);

    }
    public void num2(int n,ArrayList<Persona> list){
        int aux;
        for(int i=0;i<n;i++){ //Decenas
            int var = Integer.parseInt(list.get(i).getClaves());    //Para String
            aux=var%100;
            ingresar2(aux,i,list,cola1,cola2,cola3,cola4,cola5,cola6,cola7,cola8,cola9,cola0);
        }
        extraer(list,cola1,cola2,cola3,cola4,cola5,cola6,cola7,cola8,cola9,cola0);
    }
    public void num3(int n,ArrayList<Persona> list){
        int aux;
        for(int i=0;i<n;i++){ //Centenas
            int var = Integer.parseInt(list.get(i).getClaves());    //Para String
            aux=var%1000;
            ingresar3(aux,i,list,cola1,cola2,cola3,cola4,cola5,cola6,cola7,cola8,cola9,cola0);
        }
        extraer(list,cola1,cola2,cola3,cola4,cola5,cola6,cola7,cola8,cola9,cola0);
    }
    public void num4(int n,ArrayList<Persona> list){
        int aux;
        for(int i=0;i<n;i++){ //Millares
            int var = Integer.parseInt(list.get(i).getClaves());    //Para String
            aux=var%10000;
            ingresar4(aux,i,list,cola1,cola2,cola3,cola4,cola5,cola6,cola7,cola8,cola9,cola0);
        }
        extraer(list,cola1,cola2,cola3,cola4,cola5,cola6,cola7,cola8,cola9,cola0);
    }
    public void num5(int n,ArrayList<Persona> list){
        int aux;
        for(int i=0;i<n;i++){ //Decena de millar
            int var = Integer.parseInt(list.get(i).getClaves());    //Para String
            aux=var%100000;
            ingresar5(aux,i,list,cola1,cola2,cola3,cola4,cola5,cola6,cola7,cola8,cola9,cola0);
        }
        extraer(list,cola1,cola2,cola3,cola4,cola5,cola6,cola7,cola8,cola9,cola0);
    }
    public void num6(int n,ArrayList<Persona> list){
        int aux;
        for(int i=0;i<n;i++){ //Centena de millar
            int var = Integer.parseInt(list.get(i).getClaves());    //Para String
            aux=var%1000000;
            ingresar6(aux,i,list,cola1,cola2,cola3,cola4,cola5,cola6,cola7,cola8,cola9,cola0);
        }
        extraer(list,cola1,cola2,cola3,cola4,cola5,cola6,cola7,cola8,cola9,cola0);
    }
    
    public static void ingresar1(int x, int  iter,ArrayList<Persona> list,LinkedList col1,LinkedList col2,LinkedList col3,LinkedList col4,LinkedList col5,LinkedList col6,LinkedList col7,LinkedList col8,LinkedList col9,LinkedList col0){
        if(x==1){
            col1.offer(list.get(iter));
        }else if(x==2){
            col2.offer(list.get(iter));
        }else if(x==3){
            col3.offer(list.get(iter));
        }else if(x==4){
            col4.offer(list.get(iter));
        }else if(x==5){
            col5.offer(list.get(iter));
        }else if(x==6){
            col6.offer(list.get(iter));
        }else if(x==7){
            col7.offer(list.get(iter));
        }else if(x==8){
            col8.offer(list.get(iter));
        }else if(x==9){
            col9.offer(list.get(iter));
        }else if(x==0){
            col0.offer(list.get(iter));
        }
    }
    public static void ingresar2(int x, int  iter,ArrayList<Persona> list,LinkedList col1,LinkedList col2,LinkedList col3,LinkedList col4,LinkedList col5,LinkedList col6,LinkedList col7,LinkedList col8,LinkedList col9,LinkedList col0){
        if(x>=10 && x<=19){
            col1.offer(list.get(iter));
        }else if(x>=20 && x<=29){
            col2.offer(list.get(iter));
        }else if(x>=30 && x<=39){
            col3.offer(list.get(iter));
        }else if(x>=40 && x<=49){
            col4.offer(list.get(iter));
        }else if(x>=50 && x<=59){
            col5.offer(list.get(iter));
        }else if(x>=60 && x<=69){
            col6.offer(list.get(iter));
        }else if(x>=70 && x<=79){
            col7.offer(list.get(iter));
        }else if(x>=80 && x<=89){
            col8.offer(list.get(iter));
        }else if(x>=90 && x<=99){
            col9.offer(list.get(iter));
        }else if(x>=0 && x<=9){
            col0.offer(list.get(iter));
        }
    }
    public static void ingresar3(int x, int  iter,ArrayList<Persona> list,LinkedList col1,LinkedList col2,LinkedList col3,LinkedList col4,LinkedList col5,LinkedList col6,LinkedList col7,LinkedList col8,LinkedList col9,LinkedList col0){
        if(x>=100 && x<=199){
            col1.offer(list.get(iter));
        }else if(x>=200 && x<=299){
            col2.offer(list.get(iter));
        }else if(x>=300 && x<=399){
            col3.offer(list.get(iter));
        }else if(x>=400 && x<=499){
            col4.offer(list.get(iter));
        }else if(x>=500 && x<=599){
            col5.offer(list.get(iter));
        }else if(x>=600 && x<=699){
            col6.offer(list.get(iter));
        }else if(x>=700 && x<=799){
            col7.offer(list.get(iter));
        }else if(x>=800 && x<=899){
            col8.offer(list.get(iter));
        }else if(x>=900 && x<=999){
            col9.offer(list.get(iter));
        }else if(x>=0 && x<=99){
            col0.offer(list.get(iter));
        }
    }
    public static void ingresar4(int x, int  iter,ArrayList<Persona> list,LinkedList col1,LinkedList col2,LinkedList col3,LinkedList col4,LinkedList col5,LinkedList col6,LinkedList col7,LinkedList col8,LinkedList col9,LinkedList col0){
        if(x>=1000 && x<=1999){
            col1.offer(list.get(iter));
        }else if(x>=2000 && x<=2999){
            col2.offer(list.get(iter));
        }else if(x>=3000 && x<=3999){
            col3.offer(list.get(iter));
        }else if(x>=4000 && x<=4999){
            col4.offer(list.get(iter));
        }else if(x>=5000 && x<=5999){
            col5.offer(list.get(iter));
        }else if(x>=6000 && x<=6999){
            col6.offer(list.get(iter));
        }else if(x>=7000 && x<=7999){
            col7.offer(list.get(iter));
        }else if(x>=8000 && x<=8999){
            col8.offer(list.get(iter));
        }else if(x>=9000 && x<=9999){
            col9.offer(list.get(iter));
        }else if(x>=0 && x<=999){
            col0.offer(list.get(iter));
        }
    }
    public static void ingresar5(int x, int  iter,ArrayList<Persona> list,LinkedList col1,LinkedList col2,LinkedList col3,LinkedList col4,LinkedList col5,LinkedList col6,LinkedList col7,LinkedList col8,LinkedList col9,LinkedList col0){
           if(x>=10000 && x<=19999){
            col1.offer(list.get(iter));
        }else if(x>=20000 && x<=29999){
            col2.offer(list.get(iter));
        }else if(x>=30000 && x<=39999){
            col3.offer(list.get(iter));
        }else if(x>=40000 && x<=49999){
            col4.offer(list.get(iter));
        }else if(x>=50000 && x<=59999){
            col5.offer(list.get(iter));
        }else if(x>=60000 && x<=69999){
            col6.offer(list.get(iter));
        }else if(x>=70000 && x<=79999){
            col7.offer(list.get(iter));
        }else if(x>=80000 && x<=89999){
            col8.offer(list.get(iter));
        }else if(x>=90000 && x<=99999){
            col9.offer(list.get(iter));
        }else if(x>=0 && x<=9999){
            col0.offer(list.get(iter));
        }
    }
    public static void ingresar6(int x, int  iter,ArrayList<Persona> list,LinkedList col1,LinkedList col2,LinkedList col3,LinkedList col4,LinkedList col5,LinkedList col6,LinkedList col7,LinkedList col8,LinkedList col9,LinkedList col0){
        if(x>=100000 && x<=199999){
            col1.offer(list.get(iter));
        }else if(x>=200000 && x<=299999){
            col2.offer(list.get(iter));
        }else if(x>=300000 && x<=399999){
            col3.offer(list.get(iter));
        }else if(x>=400000 && x<=499999){
            col4.offer(list.get(iter));
        }else if(x>=500000 && x<=599999){
            col5.offer(list.get(iter));
        }else if(x>=600000 && x<=699999){
            col6.offer(list.get(iter));
        }else if(x>=700000 && x<=799999){
            col7.offer(list.get(iter));
        }else if(x>=800000 && x<=899999){
            col8.offer(list.get(iter));
        }else if(x>=900000 && x<=999999){
            col9.offer(list.get(iter));
        }else if(x>=0 && x<=9999){
            col0.offer(list.get(iter));
        }
    }
    
    
      
    public static void extraer(ArrayList<Persona> list,LinkedList col1,LinkedList col2,LinkedList col3,LinkedList col4,LinkedList col5,LinkedList col6,LinkedList col7,LinkedList col8,LinkedList col9,LinkedList col0){
        for(int j=0;j<list.size();j++){
            if(col1.peek()!=null){
                list.set(j, (Persona)col1.poll());      //Para String
            }else if(col2.peek()!=null){
                list.set(j, (Persona)col2.poll());
            }else if(col3.peek()!=null){
               list.set(j, (Persona)col3.poll()); 
            }else if(col4.peek()!=null){
               list.set(j, (Persona)col4.poll());
            }else if(col5.peek()!=null){
                list.set(j, (Persona)col5.poll());
            }else if(col6.peek()!=null){
                list.set(j, (Persona)col6.poll());
            }else if(col7.peek()!=null){
                list.set(j, (Persona)col7.poll());
            }else if(col8.peek()!=null){
                list.set(j, (Persona)col8.poll());
            }else if(col9.peek()!=null){
                list.set(j, (Persona)col9.poll());
            }else if(col0.peek()!=null){
                list.set(j, (Persona)col0.poll());
            }
        }
        
    }
    
    public void imprimir(ArrayList<Persona> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getClaves());
        }
    }
    
    
    
}
