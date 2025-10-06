package entities;

public class ContaEspecial extends ContaBancaria{

    private double limiteCredito;

    public ContaEspecial(Cliente cliente, int numero, double saldo, double limiteCredito) {
            super(cliente, numero, saldo);
            setLimiteCredito(limiteCredito);
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }
    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
    public void sacar(double valor) {
        if (valor > getSaldo() + limiteCredito){
        throw new IllegalArgumentException("O valor deve ser menor ou igual ao saldo");
        };
        setSaldo((getSaldo()+limiteCredito)-valor);
    }
}
