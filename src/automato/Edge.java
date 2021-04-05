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
public class Edge {

    private Character c;

    public Edge(Character c) {
        this.c = c;
    }

    public Character getC() {
        return c;
    }

    public void setC(Character c) {
        this.c = c;
    }

    public static Edge instance(Character _c) {
        return new Edge(_c);
    }

    @Override
    public String toString() {
        return "edge { " + this.c + " }";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge && ((Edge) obj).c == this.c) {
            return true;
        }
        return false;
    }

}
