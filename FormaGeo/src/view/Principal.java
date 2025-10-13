package view;

import exception.MenorIguala0Exception;
import models.FormaGeometrica;
import models.Quadrado;
import models.Triangulo;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    public Principal() throws MenorIguala0Exception {

        List<FormaGeometrica> formas = new ArrayList<>();

        Quadrado q1 = new Quadrado(5);
        Triangulo t1 = new Triangulo(3,4,5,5);
        Quadrado q2 = new Quadrado(10);

        formas.add(q1);
        formas.add(t1);
        formas.add(q2);

        for (FormaGeometrica f: formas){
            System.out.println(f.getClass().getSimpleName() + "\nÁrea: " + f.area() + "\nPerímetro: " + f.perimetro() + "\n\n");
        }
    }

    public static void main(String[] args) throws MenorIguala0Exception {
        Principal principal = new Principal();
    }
}
