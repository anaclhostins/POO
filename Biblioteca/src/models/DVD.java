package models;

import excecao.CampoVazioException;

import java.time.LocalDate;

public class DVD extends ItemBiblioteca{

    public DVD (String nome) throws CampoVazioException {
        super(nome, 3);
        setMulta(1.20f);
    }

    public DVD(String nome, LocalDate dataEmprestimo){
        super(nome, 14, dataEmprestimo);
        setMulta(1.20f);
    }
}
