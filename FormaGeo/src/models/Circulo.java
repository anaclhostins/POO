package models;

import exception.MenorIguala0Exception;

public class Circulo extends FormaGeometrica{

    private float raio;

    public Circulo(float raio){

    }

    public float getRaio(){
        return raio;
    }

    public void setRaio(float raio) throws MenorIguala0Exception {
        if (raio < 0){
            throw new MenorIguala0Exception("Raio");
        }
        this.raio = raio;
    }
    @Override
    public float area() {
        return 0;
    }

    @Override
    public float perimetro() {
        return 0;
    }
}
