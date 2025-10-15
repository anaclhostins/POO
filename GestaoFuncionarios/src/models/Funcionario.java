package models;

import exception.CampoVazioException;
import exception.MenorIgualAZeroException;

public abstract class Funcionario {

    private String nome;
    private double salarioBase;

    public Funcionario(String nome, double salarioBase) throws MenorIgualAZeroException, CampoVazioException {
        setNome(nome);
        setSalarioBase(salarioBase);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws CampoVazioException {
        if (nome.isEmpty() || nome.trim().isEmpty()) {
            throw new CampoVazioException("Nome");
        }
        this.nome = nome;
    }

    public double getSalarioBase(){
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) throws MenorIgualAZeroException{
        if (salarioBase <= 0){
            throw new MenorIgualAZeroException("Salário");
        }
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalario();

}

