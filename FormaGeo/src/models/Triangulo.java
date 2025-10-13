package models;

import exception.MenorIguala0Exception;

public class Triangulo extends FormaGeometrica {

    private float base;
    private float altura;
    private float lado1;
    private float lado2;


    public Triangulo(float base, float altura, float lado1, float lado2) throws MenorIguala0Exception {
        setBase(base);
        setAltura(altura);
        setLado1(lado1);
        setLado2(lado2);
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) throws MenorIguala0Exception {
        if (base <= 0) {
            throw new MenorIguala0Exception("Base");
        }
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float Altura) throws MenorIguala0Exception {
        if (altura <= 0) {
            throw new MenorIguala0Exception("Altura");
        }
        this.altura = altura;
    }

    public float getLado1() {
        return lado1;
    }
    public void setLado1(float lado) throws MenorIguala0Exception {
        if (lado <= 0) {
            throw new MenorIguala0Exception("Lado");
        }
        this.lado1 = lado;
    }

    public float getLado2() {
        return lado2;
    }

    public void setLado2(float lado) throws MenorIguala0Exception {
        if (lado <= 0) {
            throw new MenorIguala0Exception("Lado");
        }
        this.lado2 = lado;
    }

    public float area() {
        return (base*altura)/2;
    }

    public float perimetro() {
        return (lado1 + lado2 + base);
    }
}