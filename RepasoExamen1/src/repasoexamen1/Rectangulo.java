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
public class Rectangulo extends FiguraGeometrica{
    private Punto v1;
    private Punto v2;
    private Punto v3;
    private Punto v4;

    public Rectangulo(Punto v1, Punto v3) {
        this.v1 = v1;
        this.v3 = v3;
        this.v2 =  new Punto();
        this.v2.setX(this.v3.getX());
        this.v2.setY(this.v1.getY());
        this.v4 =  new Punto();
        this.v4.setX(this.v1.getX());
        this.v4.setY(this.v3.getY());
    }

    public Rectangulo() {
    }

    @Override
    public void mover(int dx, int dy) {
        this.v1.setX(this.v1.getX() + dx);
        this.v1.setY(this.v1.getY() + dy);
        this.v2.setX(this.v2.getX() + dx);
        this.v2.setY(this.v2.getY() + dy);
        this.v3.setX(this.v3.getX() + dx);
        this.v3.setY(this.v3.getY() + dy);
        this.v4.setX(this.v4.getX() + dx);
        this.v4.setY(this.v4.getY() + dy);
    }

    
    public Punto getV1() {
        return v1;
    }

    public void setV1(Punto v1) {
        this.v1 = v1;
    }

    public Punto getV2() {
        return v2;
    }

    public void setV2(Punto v2) {
        this.v2 = v2;
    }

    public Punto getV3() {
        return v3;
    }

    public void setV3(Punto v3) {
        this.v3 = v3;
    }

    public Punto getV4() {
        return v4;
    }

    public void setV4(Punto v4) {
        this.v4 = v4;
    }

    @Override
    public String toString() {
        return "Rectangulo: " +nombre+ ", punto 1: " + v1 + ", punto 2: " + v2 + ", punto 3: " + v3 + ", punto 4; " + v4 ;
    }
    
    
}
