package models;

import exception.MenorIguala0Exception;

public class Quadrado extends FormaGeometrica {

    private float lado;

    public Quadrado(int lado) throws MenorIguala0Exception {
        setLado(lado);
    }

    public float getLado(){
        return lado;
    }

    public void setLado(int lado) throws MenorIguala0Exception {
        if (lado <= 0){
            throw new MenorIguala0Exception("Lado");
        }
        this.lado = lado;
    }

    @Override
    public float area() {
        return lado*lado;
    }

    @Override
    public float perimetro() {
        return 4*lado;
    }
}
