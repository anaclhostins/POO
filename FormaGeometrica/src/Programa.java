import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Programa {

    private List<Retangulo> retangulos; // atributo da classe

    public Programa() {
        this.retangulos = new ArrayList<>();

        Ponto2D ponto2DSE = new Ponto2D(-2, 4);
        Ponto2D ponto2DIF = new Ponto2D(3, -2);
        Retangulo retangulo1 = new Retangulo(2, ponto2DSE, ponto2DIF);

        Ponto2D ponto2D1 = new Ponto2D(2, 3);
        Ponto2D ponto2D2 = new Ponto2D(6, -1);
        Retangulo retangulo2 = new Retangulo(1, ponto2D1, ponto2D2);
        retangulos.add(retangulo1);
        retangulos.add(retangulo2);

        int opcaoInt = mostrarMenu();
        while (opcaoInt != 6) {
            switch (opcaoInt) {
                case 1:
                    criarRetangulo();
                    opcaoInt = mostrarMenu();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, mostrarRetangulos());
                    opcaoInt = mostrarMenu();
                    break;
                case 3:
                    deletarRetangulo();
                    opcaoInt = mostrarMenu();
                    break;
                case 4:
                    contemPontos();
                    opcaoInt = mostrarMenu();
                    break;
                case 5:
                    isQuadrado();
                    opcaoInt = mostrarMenu();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saindo do sistema");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");
                    opcaoInt = mostrarMenu();
                    break;
            }
        }
    }

    public int mostrarMenu() {
        String opcaoString = JOptionPane.showInputDialog("""
                Selecione uma opção\
                
                1 - Criar novo retângulo\
                
                2- Mostrar retângulos criados\
                
                3 - Deletar retângulo\
                
                4 - Contém ponto\
                
                5 - É quadrado\
                
                6 - Sair do sistema""");
        return Integer.parseInt(opcaoString);
    }


    public Retangulo buscarRetangulo(Retangulo r) {
        for (Retangulo obj : retangulos) {
            if (obj.getInferiorDireito().getPontoX() == r.getInferiorDireito().getPontoX() &&
                    obj.getInferiorDireito().getPontoY() == r.getInferiorDireito().getPontoY() &&
                    obj.getSuperiorEsquerdo().getPontoX() == r.getSuperiorEsquerdo().getPontoX() &&
                    obj.getSuperiorEsquerdo().getPontoY() == r.getSuperiorEsquerdo().getPontoY()) ;
            return obj;
        }
        return null;
    }


    public void criarRetangulo() {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Insira o id do retângulo: "));
        for (Retangulo retangulo: retangulos) {
            if (retangulo.getId() == id){
                id = Integer.parseInt(JOptionPane.showInputDialog("Esse id já existe!\nInsira novamente"));
            }
        }

        double pontoXSE = Double.parseDouble(JOptionPane.showInputDialog("Insira o ponto X do Superior Esquerdo: "));
        double pontoYSE = Double.parseDouble(JOptionPane.showInputDialog("Insira o ponto Y do Superior Esquerdo: "));
        Ponto2D pontoSE = new Ponto2D(pontoXSE, pontoYSE);

        double pontoXIF = Double.parseDouble(JOptionPane.showInputDialog("Insira o ponto X do Inferior Direito: "));
        double pontoYIF = Double.parseDouble(JOptionPane.showInputDialog("Insira o ponto Y do Inferior Direito: "));
        Ponto2D pontoIF = new Ponto2D(pontoXIF, pontoYIF);

        Retangulo retangulo = new Retangulo(id, pontoSE, pontoIF);
        if (buscarRetangulo(retangulo) == null) {
            JOptionPane.showMessageDialog(null, "Retângulo já existe");
            return;
        } else {
            retangulos.add(retangulo);
            JOptionPane.showMessageDialog(null, retangulo + "\nPerímetro: " + retangulo.perimetro() + "\nÁrea: " + retangulo.area());
            return;
        }

    }


    public String mostrarRetangulos() {
        if (retangulos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lista de Retângulos está vazia!");
        }
        String listaRetangulos = "";
        int i = 1;
        for (Retangulo retangulo : retangulos) {
            listaRetangulos += "Retângulo " + i + ": " + retangulo + "\n";
            i++;
        }
        return listaRetangulos;
    }


    public void deletarRetangulo() {
        int idVerificar = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do retângulo"));
        for (Retangulo retangulo : retangulos) {
            if (retangulo.getId() == idVerificar) {
                retangulos.remove(retangulo);
                JOptionPane.showMessageDialog(null, "Retângulo deletado");
            } else {
                JOptionPane.showMessageDialog(null, "Retângulo não encontrado");
            }
        }
    }

    public void isQuadrado() {
        int idQuadrado = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do retângulo"));
        for (Retangulo retangulo : retangulos) {
            if (retangulo.isQuadrado()) {
                JOptionPane.showMessageDialog(null, "O retângulo é quadrado");
            } else {
                JOptionPane.showMessageDialog(null, "Retângulo não é quadrado");
            }
        }
    }

    public void contemPontos() {
        try {
            double pontoX = Double.parseDouble(JOptionPane.showInputDialog("Insira o Ponto X"));
            double pontoY = Double.parseDouble(JOptionPane.showInputDialog("Insira o Ponto Y"));
            Ponto2D ponto2DProcurar = new Ponto2D(pontoX, pontoY);

            StringBuilder ids = new StringBuilder();

            for (Retangulo retangulo : retangulos) {
                if (retangulo.contem(ponto2DProcurar)) {
                    if (!ids.isEmpty()) {
                        ids.append(", ");
                    }
                    ids.append(retangulo.getId());
                }
            }

            if (!ids.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "O ponto foi encontrado no(s) retângulo(s) de ID: " + ids);
            } else {
                JOptionPane.showMessageDialog(null,
                        "O ponto não foi encontrado em nenhum retângulo");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Entrada inválida. Digite apenas números.");
        }
    }

}
