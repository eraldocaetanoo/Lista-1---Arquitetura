/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor., 
 */
package arquitetura;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * ler 1
 * decodificar1
 * ler2
 * op 1
 * decodificando2
 * ler3
 * exe1
 * op2
 * decodificando3
 * write1
 * exe2
 * op3
 * write2
 * exe3
 * write3
 * @author ennac
 */
  



public class Inicio {
    static int cont = 0;
    static int cont_a = 0;
    static int aux = 0;
    static int aux2 = 0;
    static int inst2;
    public static void Ativar1(int inst) {
        cont++; //cont 1
        cont_a++;
        if(cont == 1){ //n entra no if
            aux = inst;
            aux2 = aux;
            inst = 1;
            ChamarT1(inst);
            System.out.println("---------------------");
            Ativa2(inst);
        }else if(cont != 1){
            inst++;
            ChamarT1(inst);
            System.out.println("---------------------");
            inst = Ativa4(inst,1);
            if((cont_a%2) == 0){
                cont_a++;
                inst--;
                Ativa3(inst);
            }
            inst++;
            Ativa2(inst);
        }
        
    }
    public static void Ativa2(int inst){//3 instruções e 1 auxiliar
        if(aux > 1){//como 3 é maior 1, entra no if
            aux--;
            if(cont == 1){
                cont++;//cont passa a ser 2
                ChamarT2(inst);
                Ativar1(inst);//(2,3)
            }else{
                cont++;
                ChamarT2(inst);
                Ativar1(inst);//(2,3)
            }
        }else{
            cont++;
            ChamarT2(inst);
            System.out.println("---------------------");
            inst = Ativa4(inst,2);
            Ativa3(inst);
        }
    }
    
    public static void Ativa3(int inst){
        if(aux > 1){
            ChamarT3(inst);
        }else{
            ChamarT3(inst);
            if(aux2 == 1 || (aux2 == 2 && inst == 2)){
                System.out.println("---------------------");
            }
         inst = Ativa4(inst,3);
        }
    }
    public static int Ativa4(int inst, int tipo){
        if(tipo == 2){
            if(inst >= 2){
                if(inst == 2){
                    inst--;
                    //ChamarT5(inst);
                    ChamarT4(inst);
                    inst++;
                }else{
                    inst--;
                    inst--;
                    ChamarT5(inst);
                    inst++;
                    ChamarT4(inst);
                    inst++;   
                }
        }   
        }else if(tipo == 1){
         if(cont >= 5 && (cont%2 == 1)){
            if(inst >= 4){
                inst = inst - 3;
                ChamarT5(inst);
                inst = inst + 3;
            }
            inst = inst - 2;
            ChamarT4(inst);
            inst = inst + 2;
        }   
        }else if(tipo == 3){
            if(cont%2 == 0){
                
                if(inst == 1){
                    ChamarT4(inst);
                    System.out.println("---------------------");
                    ChamarT5(inst);
                }else{
                    inst--;
                    System.out.println("---------------------");
                    ChamarT5(inst);
                    inst++;
                    ChamarT4(inst);
                    System.out.println("---------------------");
                    ChamarT5(inst);
                }
                
            }
        }
        return inst;
    }
    public static void ChamarT1(int inst){
        inst2 = inst;
        Thread p1 = new Thread(){
          @Override
          public void run(){
                System.out.println("Buscando "+inst2);
          }  
        };
            p1.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void ChamarT2(int inst){
        inst2 = inst;
        Thread p2 = new Thread(){
          @Override
          public void run(){
                System.out.println("Decodificando "+inst2);
          }  
        };
            p2.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void ChamarT3(int inst){
        inst2 = inst;
        Thread p3 = new Thread(){
            @Override
            public void run(){
                  System.out.println("Buscando operandos "+inst2);
            }  
        };
            p3.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void ChamarT4(int inst){
        inst2 = inst;
        Thread p4 = new Thread(){
          @Override
          public void run(){
                System.out.println("Executando "+inst2);
          }  
        };
            p4.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void ChamarT5(int inst){
        inst2 = inst;
        Thread p5 = new Thread(){
          @Override
          public void run(){
                System.out.println("Gravando "+inst2);
          }  
        };
            p5.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("Digite o número de instruções: ");
        n = in.nextInt();
        Ativar1(n);
    }
}