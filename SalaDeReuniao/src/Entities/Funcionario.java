package Entities;

public class Funcionario {

    private String nome;
    private Cargo cargo;
    private int ramal;
    private int id;

    public Funcionario(String nome, Cargo cargo, int ramal, int id) {
        setNome(nome);
        setCargo(cargo);
        setRamal(ramal);
        setId(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo){
        this.cargo = cargo;
    }

    public int getRamal() {
        return ramal;
    }

    public void setRamal(int ramal) {
        this.ramal = ramal;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Funcionario" +
                "\nNome:" + nome +
                "\nCargo:" + cargo +
                "\nRamal: " + ramal +
                "\nId: " + id;
    }
}
