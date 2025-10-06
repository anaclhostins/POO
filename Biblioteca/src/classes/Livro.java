package classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Livro extends ItemBiblioteca{

    public Livro(String nome) {
        super(nome, 14);
        setMulta(0.75f);
    }

    public Livro(String nome, LocalDate dataEmprestimo){
        super(nome, 14, dataEmprestimo);
        setMulta(0.75f);
    }


}
