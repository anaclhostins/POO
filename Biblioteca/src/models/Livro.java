package models;

import excecao.CampoVazioException;

import java.time.LocalDate;

public class Livro extends ItemBiblioteca{

    public Livro(String nome) throws CampoVazioException {
        super(nome, 14);
        setMulta(0.75f);
    }

    public Livro(String nome, LocalDate dataEmprestimo){
        super(nome, 14, dataEmprestimo);
        setMulta(0.75f);
    }


}
