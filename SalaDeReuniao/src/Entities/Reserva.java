package Entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

    private int id;
    private LocalDateTime dataHora;
    private Sala sala;
    private List<Funcionario> listaFuncionarios;

    public Reserva(int id, LocalDateTime dataHora, Sala sala, Funcionario funcionario){
        listaFuncionarios = new ArrayList<>();
        setId(id);
        setDataHora(dataHora);
        setDataHora(dataHora);
        setSala(sala);
        listaFuncionarios.add(funcionario);
    }

    // id
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }



    // data
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }



    // sala
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }



    // funcionário
    public List<Funcionario> getListaFuncionarios(){
        return listaFuncionarios;
    }

    public boolean adicionarFuncionario(int id){
        for(Funcionario funcionario: listaFuncionarios){
            if (id == funcionario.getId()){
                listaFuncionarios.add(funcionario);
                return true;
            }
        }
        return false;
    }


    public void RemoverFunc(String nome) {
        for (Funcionario i : listaFuncionarios) {
            if (i.getNome().equals(nome)) {
                listaFuncionarios.remove(i);
            }
        }
    }


    // to string
    public String toString() {
        String funcionariosStr = "";
        for (Funcionario f : listaFuncionarios) {
            funcionariosStr += "- " + f.getNome() + "\n";
        }

        return "\nId: " + id +
                "\nData e Horário da Reserva: " + dataHora +
                "\nSala: " + sala +
                "\nLista de Funcionários:\n" + funcionariosStr;
    }
}
