package models;

import exception.CampoVazioException;
import exception.MenorIgualAZeroException;

import java.util.ArrayList;
import java.util.List;

public class Programador extends Funcionario{

    private List<String > linguagens;

    public Programador(String nome, double salarioBase) throws MenorIgualAZeroException, CampoVazioException {
        super(nome, salarioBase);
        linguagens = new ArrayList<>();
    }

    public void incluirLinguagem(String linguagem) throws CampoVazioException {
        if (linguagem.isEmpty() || linguagem.trim().isEmpty()){
            throw new CampoVazioException("Linguagem");
        }
        linguagens.add(linguagem);
    }

    public boolean excluirLinguagem(String linguagem){
         for (String l: linguagens){
             if (l.equalsIgnoreCase(linguagem)){
                 linguagens.remove(l);
                 return true;
             }
         }
         return false;
    }

    public StringBuilder getLinguagens(){
        StringBuilder sb = new StringBuilder();
        for (String l: linguagens){
            sb.append(l).append("\n");
        }
        return sb;
    }

    @Override
    public double calcularSalario() {
        double salarioFinal = getSalarioBase();
        for (String l: linguagens){
            if (l.equalsIgnoreCase("JAVA")){
                salarioFinal += getSalarioBase()*0.2;
                return salarioFinal;
            }
        }
        return salarioFinal;
    }
}
