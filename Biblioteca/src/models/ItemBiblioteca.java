package models;

import excecao.CampoVazioException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ItemBiblioteca {

    private String titulo;
    private LocalDate dataEmprestimo;
    private boolean isEmprestado;
    private int prazo;
    private float multa;

    public ItemBiblioteca(String nome, int prazo) throws CampoVazioException {
        setTitulo(nome);
        setPrazo(prazo);
        setMulta(0.5f);
    }

    public ItemBiblioteca(String nome, int prazo, LocalDate dataEmprestimo) {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws CampoVazioException {
        if (titulo.isEmpty() || titulo.trim().isEmpty()) {
            throw new CampoVazioException("Título");
        }
        this.titulo = titulo;
    }

    public boolean isEmprestado() {
        return isEmprestado;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) throws CampoVazioException {
        if (dataEmprestimo == null){
            throw new CampoVazioException("Data de empréstimo");
        }
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

    public boolean emprestar(LocalDate dataParaEmprestimo) throws CampoVazioException {
        if (dataEmprestimo == null) {
            setDataEmprestimo(dataParaEmprestimo);
            isEmprestado = true;
            return true;
        } else {
            isEmprestado = false;
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
            isEmprestado = false;
            return diferencaEmDias * multa;
        } else {
            dataEmprestimo = null;
            isEmprestado = false;
            return 0;
        }
    }

}
