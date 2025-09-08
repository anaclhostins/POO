import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Programa {
    public Programa(){
        List<Retangulo> retangulos = new ArrayList<>();

        String opcaoString = JOptionPane.showInputDialog("Selecione uma opção" +
                "\n1 - Criar novo retângulo" +
                "\n2- Mostrar retângulos criados" +
                "\n3 - Atualizar retângulo" +
                "\n4 - Deletar retângulo");
        int opcaoInt = Integer.parseInt(opcaoString);
        switch (opcaoInt){
            case 1:
                /*String pontoXstringSE = JOptionPane.showInputDialog("Insira o ponto X do Superior Esquerdo: ");
                double pontoXintSE = Double.parseDouble(pontoXstringSE);
                String pontoYstringSE = JOptionPane.showInputDialog("Insira o ponto Y do Superior Esquerdo: ");
                double pontoYintSE = Double.parseDouble(pontoXstringSE);
                Ponto2D pontoSE= new Ponto2D(pontoXintSE,pontoYintSE);
                String pontoXstringIF = JOptionPane.showInputDialog("Insira o ponto X do Inferior Direito: ");
                double pontoXintIF = Double.parseDouble(pontoXstringSE);
                String pontoYstringIF = JOptionPane.showInputDialog("Insira o ponto Y do Inferior Direito: ");
                double pontoYintIF = Double.parseDouble(pontoXstringSE);
                Ponto2D pontoIF= new Ponto2D(pontoXintSE,pontoYintSE);
                Retangulo retangulo = new Retangulo(pontoSE,pontoIF);*/
                Retangulo retangulo = criarRetangulo();
                retangulos.add(retangulo);
                
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    public Retangulo criarRetangulo(){
        String pontoXstringSE = JOptionPane.showInputDialog("Insira o ponto X do Superior Esquerdo: ");
        double pontoXintSE = Double.parseDouble(pontoXstringSE);
        String pontoYstringSE = JOptionPane.showInputDialog("Insira o ponto Y do Superior Esquerdo: ");
        double pontoYintSE = Double.parseDouble(pontoXstringSE);
        Ponto2D pontoSE= new Ponto2D(pontoXintSE,pontoYintSE);
        String pontoXstringIF = JOptionPane.showInputDialog("Insira o ponto X do Inferior Direito: ");
        double pontoXintIF = Double.parseDouble(pontoXstringSE);
        String pontoYstringIF = JOptionPane.showInputDialog("Insira o ponto Y do Inferior Direito: ");
        double pontoYintIF = Double.parseDouble(pontoXstringSE);
        Ponto2D pontoIF= new Ponto2D(pontoXintSE,pontoYintSE);
        Retangulo retangulo = new Retangulo(pontoSE,pontoIF);
        return retangulo;
    }

}
