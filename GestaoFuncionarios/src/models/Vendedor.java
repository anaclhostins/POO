package models;

import exception.CampoVazioException;
import exception.MenorIgualAZeroException;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Funcionario {

    private double percentualComissao;
    private List<Venda> vendas;

    public Vendedor(String nome, double salarioBase, double percentualComissao) throws MenorIgualAZeroException, CampoVazioException {
        super(nome, salarioBase);
        vendas = new ArrayList<>();
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) throws MenorIgualAZeroException {
        if (percentualComissao <= 0) {
            throw new MenorIgualAZeroException("Percentual de comissão");
        }
        this.percentualComissao = percentualComissao;
    }

    public StringBuilder getVendas() {
        StringBuilder sb = new StringBuilder();
        for (Venda v : vendas) {
            sb.append(v).append("\n");
        }
        return sb;
    }

    public void incluirVenda(Venda venda){
        vendas.add(venda);
    }

    @Override
    public double calcularSalario() {
        double comissao = 0;
        for (Venda v: vendas){
            comissao += v.getValor()*(percentualComissao/100);
        }
        return getSalarioBase() + comissao;
    }
}
