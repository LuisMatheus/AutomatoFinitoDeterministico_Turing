/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automato;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public abstract class AFD {
    public String fita;
    public State q;
    public ArrayList<State> states = new ArrayList<>();
    public State qi;
    
    public void load(File f) {
        try {
            
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] aux;
                if (data.isEmpty() || data.startsWith("@")){
                    continue;
                }
                aux = data.split(" ");
                if(aux[0].equals("fita")){
                    fita = aux[1];
                    
                }else if(aux[0].equals("states")){
                    
                    aux = aux[1].split(",");
                    for (String string : aux) {
                        if(!states.contains(string)){
                            states.add(new State(string));
                        }
                    }
                    
                }else if(aux[0].equals("init")){
                    
                    for (State s : states) {
                        if(s.getName().equals(aux[1])){
                            qi = s;
                        }
                    }
                    
                }else if(aux[0].equals("final")){
                    
                    aux = aux[1].split(",");
                    for (String string : aux) {
                        for (State s : states) {
                            if(s.getName().equals(string)) {
                                s.setFinal();
                            }
                        }
                    }
                    
                }else{
                    aux = aux[0].split(",");
                    //[ORIGEM,VALOR_TRANSICAO,DESTINO,ESCREVER,ACAO]
                    for (State state : states) {
                        if(state.getName().equals(aux[0])){
                            for (State state1 : states) {
                                if(state1.getName().equals(aux[2])){
                                    state.addTransition(state1,                                 //add destino
                                            Edge.instance(Character.valueOf(aux[1].charAt(0))), //add edge
                                            Character.valueOf(aux[3].charAt(0)),                //add escrever
                                            Character.valueOf(aux[4].charAt(0)));               //add acao
                                }
                            }
                        }
                    }
                }
                
                
                
                
                
            }
            myReader.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AFD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public abstract void run();
    
    public abstract void estenderFitaDireita();
    
    public abstract void estenderFitaEsquerda();
}
