/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoexamen1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.scene.chart.Chart;

/**
 *
 * @author miltonlab
 */
public class Graficador {

    String datos = "";
    static ArrayList<FiguraGeometrica> figuras = new ArrayList<FiguraGeometrica>();

    public static void agregar(FiguraGeometrica f) {
        figuras.add(f);
    }

    public static void moverFiguras(int dx, int dy) {
        for (FiguraGeometrica figura : figuras) {
            figura.mover(dx, dy);
        }
    }

    public static void grabar() {
        PrintWriter pw = null;
        try {
            FileWriter fw = new FileWriter("figuras.csv", true);
            pw = new PrintWriter(fw);
        } catch (Exception e) {
            System.out.println("Error en la lectura del archivo");
        }
        for (FiguraGeometrica figura : figuras) {
            if (figura instanceof Circulo) {
                Circulo c = (Circulo) figura;
                String line = "Circulo" + ";" + c.getNombre() + ";" + c.getCentro() + ";" + c.getRadio();
                pw.println(line);
            }
            if (figura instanceof Rectangulo) {
                Rectangulo rec = (Rectangulo) figura;
                String linea = "Rectangulo" + ";" + rec.getNombre() + ";" + rec.getV1() + ";" + rec.getV2() + ";" + rec.getV3() + ";" + rec.getV4();
                pw.println(linea);
            }
        }
        pw.close();
    }

    public static String recargar() {
        BufferedReader leer = null;
        String lector = "";
        try {

            FileReader f = new FileReader("C://Users//Personal//Documents//RepasoExamen1//figuras.csv");
            leer = new BufferedReader(f);
            String linea;
            while ((linea = leer.readLine()) != null) {
                String[] registro = linea.split(";");
                if (registro[0].equals("Circulo")) {
                    String puntosCadena = registro[2];
                    String[] puntos = puntosCadena.split(",");
                    int xc = Integer.parseInt(puntos[0]);
                    int yc = Integer.parseInt(puntos[1]);
                    double radio = Double.parseDouble(registro[3]);
                    Circulo circulo = new Circulo();
                    circulo.radio = radio;
                    circulo.centro = new Punto(xc, yc);
                    circulo.nombre = registro[1];
                    Graficador.agregar(circulo);
                    lector += circulo.toString() + "\n";
                } else {
                    String puntosV1 = registro[2];
                    String[] punto1 = puntosV1.split(",");
                    int xv1 = Integer.parseInt(punto1[0]);
                    int yv1 = Integer.parseInt(punto1[1]);
                    String puntosV3 = registro[4];
                    String[] punto3 = puntosV3.split(",");
                    int xv3 = Integer.parseInt(punto3[0]);
                    int yv3 = Integer.parseInt(punto3[1]);
                    Rectangulo rectangulo = new Rectangulo(new Punto(xv1, yv1), new Punto(xv3, yv3));
                    rectangulo.nombre=registro[1];
                    Graficador.agregar(rectangulo);
                    lector += rectangulo.toString() + "\n";
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura del archivo");
        }
        return lector;
    }

}
