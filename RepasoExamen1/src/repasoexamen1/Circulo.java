/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoexamen1;

/**
 *
 * @author miltonlab
 */
public class Circulo extends FiguraGeometrica{
    
    
    double radio;
    Punto centro;
    public Circulo(double radio, Punto centro) {
        this.radio = radio;
        this.centro = centro;
    }

    public Circulo() {
    }

    
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }

    @Override
    public void mover(int dx, int dy) {
        this.centro.setX(this.centro.getX() + dx);
        this.centro.setY(this.centro.getY() + dy);
    }

    @Override
    public String toString() {
        return "Circulo: " + nombre + ", centro: " + centro + ", radio: "+radio;
    }
    
    
    
    
}
