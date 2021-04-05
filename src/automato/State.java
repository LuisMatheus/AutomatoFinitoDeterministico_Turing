/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automato;

import automato.Transition;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class State {
    private final String name;
    private boolean isFinal = false;
    private List<Transition> transitions = new ArrayList<>();

    public State(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "State{" + name + '}';
    }
    
    public void setFinal(){
        this.isFinal = true;
    }
    
    public boolean isFinal(){
        return this.isFinal;
    }
    
    public State addTransition(State target, Character c,Character write,Character action){
        return addTransition(target, Edge.instance(c),write,action);
    }
    
    public State addTransition(State target, Edge e,Character write,Character action){
            Transition t = new Transition(target,e,write, action);
            if(transitions.contains(t)){
                return null;
            }
            transitions.add(t);
        
        return this;
    }
    
    public Transition transition(Character _c){
        for (Transition t : transitions) {
            Edge e = t.getEdge();
            if(e.getC()!= null && e.getC().equals(_c)){
                return t;
            }
            
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof State){
            return ((State) obj).getName().equals(this.getName());
        }
        return false;
    }
    
    
    
}
