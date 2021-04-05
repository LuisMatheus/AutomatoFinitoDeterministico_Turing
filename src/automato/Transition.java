/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automato;

/**
 *
 * @author Matheus
 */
public class Transition {
    private final State state;
    private final Edge edge;
    private final Character action;
    private final Character write;

    public Transition(State state, Edge edge, Character write ,Character action) {
        this.state = state;
        this.edge = edge;
        this.action = action;
        this.write = write;
    }
    
    public Character getAction() {
        return action;
    }

    public Character getWrite() {
        return write;
    }
    
    public State getState() {
        return state;
    }

    public Edge getEdge() {
        return edge;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Transition){
            Transition t = (Transition) obj;
            return t.getEdge() == this.getEdge() && t.getState() == this.getState();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Transition: " + this.toString() + "{ "+ state.getName() + " ---> "+ edge.toString() +" }";
    }
    
    
}
