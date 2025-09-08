package Entities;

public class Cargo {

    private String cargo;

    public Cargo() {
    }

    public Cargo(String cargo) {
        setCargo(cargo);   // usa o setter no construtor
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Cargo: " + cargo;
    }
}