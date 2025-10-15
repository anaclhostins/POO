package view;

import control.Empresa;
import exception.CampoVazioException;
import exception.MenorIgualAZeroException;
import models.Programador;

import javax.swing.*;

public class Principal {

    public Principal() throws CampoVazioException, MenorIgualAZeroException {

        Empresa empresa = new Empresa("WS Sistemas");
        int opcao = Integer.parseInt("Selecione uma das opções: " +
                "\n1 - Adicionar Funcionário" +
                "\n2 - Excluir Funcionário" +
                "\n4 - Editar Funcionário" +
                "\n3 - Mostrar custos totais");
        do {
            switch (opcao){
                case 1:
                    String nome = JOptionPane.showInputDialog("Insira o nome do Funcionário: ");
                    double salarioBase = Double.parseDouble(JOptionPane.showInputDialog("Insira o salário base: "));
                    int tpFunc = Integer.parseInt(JOptionPane.showInputDialog("Selecione o tipo de Funcionário: " +
                            "1 - Programador" + "\n2 - Vendedor" ));
                    switch (tpFunc){
                        case 1:
                            Programador programador = new Programador(nome,salarioBase);

                    }
            }
        } while (opcao!=5);
    }
}
