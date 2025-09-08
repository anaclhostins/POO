package Entities;

import java.util.ArrayList;

public class Sala {

    private int numeroSala;
    private int qntLugar;

    public Sala(int numeroSala, int qntLugar){
        this.numeroSala = numeroSala;
        this.qntLugar = qntLugar;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public int getQntLugar(){
        return qntLugar;
    }

    public void setQntLugar(int qntLugar){
        this.qntLugar = qntLugar;
    }

    @Override
    public String toString() {
        return "Sala de Reunião " + getNumeroSala();
    }
}
