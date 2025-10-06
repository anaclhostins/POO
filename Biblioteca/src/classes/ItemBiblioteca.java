package classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ItemBiblioteca {

    private String titulo;
    private LocalDate dataEmprestimo;
    private int prazo;
    private float multa;

    public ItemBiblioteca(String nome, int prazo) {
        setTitulo(nome);
        setPrazo(prazo);
        setMulta(0.5f);
    }

    public ItemBiblioteca(String nome, int prazo, LocalDate dataEmprestimo) {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo.isEmpty() || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título não pode estar vazio");
        }
        this.titulo = titulo;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public int getPrazo() {
        return prazo;
    }

    public float getMulta(){
        return multa;
    }

    protected void setMulta(float multa){
        this.multa = multa;
    }

    public boolean emprestar(LocalDate dataParaEmprestimo) {
        if (dataEmprestimo == null) {
            setDataEmprestimo(dataParaEmprestimo);
            return true;
        } else {
            return false;
        }
    }

    public float devolver() {
        /*LocalDate hoje = LocalDate.now();
        LocalDate supostaDevolucao = dataEmprestimo.plusDays(prazo);*/
        //dado primitivo que representa números inteiros de 64 bits com sinal, usado para armazenar valores inteiros maiores do que o tipo int permite.
        long diferencaEmDias = ChronoUnit.DAYS.between(dataEmprestimo, LocalDate.now());
        if (diferencaEmDias > prazo) {
            dataEmprestimo = null;
            return diferencaEmDias * multa;
        } else {
            dataEmprestimo = null;
            return 0;
        }
    }
}
