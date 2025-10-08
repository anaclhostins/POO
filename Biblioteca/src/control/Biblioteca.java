package control;

import models.DVD;
import models.ItemBiblioteca;
import models.Livro;
import models.Revista;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

        private List<ItemBiblioteca> itens;

    public Biblioteca(){
        itens = new ArrayList<>();
    }

    public void add(ItemBiblioteca item){
        if (item == null){
            throw new IllegalArgumentException("Item deve ser informado");
        }
        itens.add(item);
    }

    public String listar(){
        String dados = "";
        for (ItemBiblioteca item: itens){
            if(item instanceof Livro){
                dados += "Livro \n";
            } else if (item instanceof Revista){
                dados += "Revista: ";
            } else if (item instanceof DVD) {
                dados += "DVD: ";
            } else {
                dados += "Outro: ";
            }
            dados += "\nTítulo: " + item.getTitulo() + "\nPrazo: " +  item.getPrazo() + " - Multa: " + item.getMulta() + "\nSituação: ";
            if (item.isEmprestado()){
                dados += "Empréstimo";
            } else {
                dados += "Disponível";
            }
        }
        return dados;
    }
}
