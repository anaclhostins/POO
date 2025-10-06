package entities;

public class ContaBancaria {

    private Cliente cliente;
    private int numero;
    private double saldo;

    public ContaBancaria(Cliente cliente, int numero, double saldo) {
        setCliente(cliente);
        setNumero(numero);
        setSaldo(saldo);
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("O número da conta deve ser maior que zero");
        }
    }

    public double getSaldo() {
        return saldo;
    }
    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor > saldo){
            throw new IllegalArgumentException("O valor deve ser menor ou igual ao saldo ");
        }
        this.saldo -= valor;
    }

    public void trasferir(ContaBancaria contaDestino, int valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException("O valor deve ser menor ou igual ao saldo ");
        }
    }
}
