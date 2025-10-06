package classes;

import java.time.LocalDate;

public class Revista extends ItemBiblioteca{

    public Revista(String nome){
        super(nome, 7);
        setMulta(7);
    }

    public Revista(String nome, LocalDate dataEmprestimo){
        super(nome, 7, dataEmprestimo);
        setMulta(7);
    }
}
