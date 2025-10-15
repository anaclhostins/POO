package models;

import exception.MenorIgualAZeroException;

public class Venda {

    private double valor;

    public Venda(double valor) throws MenorIgualAZeroException {
        setValor(valor);
    }

    public double getValor(){
        return valor;
    }

    public void setValor(double Valor) throws MenorIgualAZeroException {
        if (valor <= 0){
            throw new MenorIgualAZeroException("Valor");
        }
        this.valor = valor;
    }
}
