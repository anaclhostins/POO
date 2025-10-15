package control;

import exception.CampoVazioException;
import models.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nome;
    private List<Funcionario> funcionarios;

    public Empresa(String nome) throws CampoVazioException {
        setNome(nome);
        funcionarios = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) throws CampoVazioException {
        if (nome.isEmpty() || nome.trim().isEmpty()){
            throw new CampoVazioException("Nome");
        }
        this.nome = nome;
    }

    public void incluirFuncionario(Funcionario f){
        funcionarios.add(f);
    }

    public void excluirFuncionario(Funcionario f){
        for (Funcionario i: funcionarios){
            if (i.equals(f)){
                funcionarios.remove(i);
            }
        }
    }

    public String getFuncionarios(){
        String sb = "";
        for (Funcionario f: funcionarios){
            sb += f.getClass().getSimpleName() + "\n" + f.getNome() + "\nSalário: " + f.getSalarioBase() + "\n\n";
        }
        return sb;
    }

    public double calcularCustosSalario(){
        double custoTotal = 0;
        for (Funcionario f:funcionarios){
            custoTotal += f.calcularSalario();
        }
        return custoTotal;
    }
}
