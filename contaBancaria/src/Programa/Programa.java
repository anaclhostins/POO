package Programa;

import entities.Cliente;
import entities.ContaBancaria;
import entities.ContaEspecial;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Programa {

    List<Cliente> clientes = new ArrayList<Cliente>();
    List<ContaBancaria> contas = new ArrayList<ContaBancaria>();

    public Programa() {


        int opcao = mostrarMenu();
        while (opcao != 5) {
            switch (opcao) {
                case 1:
                    novoCliente();
                    opcao = mostrarMenu();
                    break;
                case 2:
                    int nmrConta = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da Conta:"));
                    depositarConta(nmrConta);
                    opcao = mostrarMenu();
                    break;
                case 3:
                    nmrConta = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da Conta:"));
                    sacarConta(nmrConta);
                    opcao = mostrarMenu();
                    break;
                    /*case 4:
                        nmrConta = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da Conta:"));
                    */
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                    opcao = mostrarMenu();
            }
        }
    }

    public int mostrarMenu(){
        int opcao = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção:" +
                "\n1 - Novo Cliente\n2-Depositar valor\n3-Sacar Valor\n4-Transferir Valor\n5-Sair do Sistema"));
        return opcao;
    }

    public void novoCliente() {
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente: ");
        String endereco = JOptionPane.showInputDialog("Digite o endereco do cliente: ");
        Cliente cliente = new Cliente(nome, endereco);
        clientes.add(cliente);
        int opcao = Integer.parseInt(JOptionPane.showInputDialog("Insira a conta a ser criada:"
                + "\n1 - Conta Básica\n2 - Conta Especial"));
        switch (opcao) {
            case 1:
                int nmr = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta "));
                double saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo da conta "));
                ContaBancaria contaBancaria = new ContaBancaria(cliente, nmr, saldo);
                contas.add(contaBancaria);

                break;
            case 2:
                int nmrEspecial = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta "));
                double saldoEspecial = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da conta "));
                double limiteCredito = Double.parseDouble(JOptionPane.showInputDialog("Digite o limite da conta "));
                ContaEspecial contaEspecial = new ContaEspecial(cliente, nmrEspecial, saldoEspecial, limiteCredito);
                contas.add(contaEspecial);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcao invalida");
                opcao = Integer.parseInt(JOptionPane.showInputDialog("Insira a conta a ser criada:"
                        + "1 - Conta Básica\n2 - Conta Especial"));
                break;
        }
    }

    public void depositarConta(int nmr) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == nmr) {
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do deposito: "));
                conta.depositar(valor);
                JOptionPane.showMessageDialog(null, "Valor depositado com sucesso!");
            }
        }
        JOptionPane.showMessageDialog(null, "Conta não encontrada!");
    }

    public void sacarConta(int nmr) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == nmr) {
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do saque: "));
                conta.sacar(valor);
                JOptionPane.showMessageDialog(null, "Valor sacado com sucesso!");
            }
        }
        JOptionPane.showMessageDialog(null, "Conta não encontrada!");
    }

    //public void transferir(){

    //}
}
