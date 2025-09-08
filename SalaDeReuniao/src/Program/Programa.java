package Program;

import Entities.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public Programa() {

        Scanner scanner = new Scanner(System.in);
        ReservaMes reservaMes = new ReservaMes();

        ArrayList<Sala> salas = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Cargo> cargos = new ArrayList<>();

        Sala sala1 = new Sala(1,5);
        Sala sala2 = new Sala(2,10);
        Sala sala3 = new Sala(3,15);
        salas.add(sala1);
        salas.add(sala2);
        salas.add(sala3);

        Cargo cargo1 = new Cargo("Software Developer");
        Cargo cargo2 = new Cargo("Tech Lead");
        Cargo cargo3 = new Cargo("Gerente");
        Cargo cargo4 = new Cargo("Estagiário");

        Funcionario funcionario1 = new Funcionario("José", cargo1, 200,100);
        Funcionario funcionario2 = new Funcionario("Maria", cargo2, 201, 101);
        Funcionario funcionario3 = new Funcionario("Pedro", cargo3, 202,102);
        Funcionario funcionario4 = new Funcionario("Julia", cargo4, 203, 103);
        funcionarios.add(funcionario1);
        funcionarios.add(funcionario2);
        funcionarios.add(funcionario3);
        funcionarios.add(funcionario4);


        mostrarMenu();
        int opcao = scanner.nextInt();

        while (opcao != 5) {

            switch (opcao) {

                case 1:

                    System.out.println("======= NOVO FUNCIONÁRIO =======");
                    System.out.println("Insira o id do funcionário: ");
                    int idFunc = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Insira o nome do novo Funcionário: ");
                    String nome = scanner.nextLine();

                    System.out.println("Insira o cargo do funcionário: ");
                    String cargo = scanner.nextLine();
                    Cargo cargo5 = new Cargo(cargo);
                    cargos.add(cargo5);

                    System.out.println("Insira o ramal do funcionário: ");
                    int ramal = scanner.nextInt();

                    Funcionario funcionario = new Funcionario(nome, cargo5, ramal, idFunc);
                    funcionarios.add(funcionario);

                    mostrarMenu();
                    opcao = scanner.nextInt();
                    break;

                case 2:

                    System.out.println("Insira o número da sala: ");
                    int numeroSala = scanner.nextInt();

                    System.out.println("Insira a quantidade de lugares: ");
                    int nmrLugares = scanner.nextInt();

                    Sala sala = new Sala(numeroSala,nmrLugares);
                    salas.add(sala);

                    mostrarMenu();
                    opcao = scanner.nextInt();
                    break;

                case 3:

                    System.out.println("======= NOVA RESERVA =======");
                    System.out.println("Insira o id da Reunião: ");
                    int idReuniao = scanner.nextInt();

                    System.out.println("Insira o número da sala desejada: ");
                    mostrarSalas(salas);
                    int nmrSala = scanner.nextInt();
                    Sala salaEscolhida = buscarSala(salas, nmrSala);


                    System.out.print("Digite a data e hora (dd/MM/yyyy HH:mm): ");
                    scanner.nextLine(); // limpar buffer
                    String input = scanner.nextLine();
                    LocalDateTime dataHora = formatarData(input);

                    System.out.println("Insira o id do funcionário responsável: ");
                    mostrarFuncionario(funcionarios);
                    int idFuncionarioResponsavel = scanner.nextInt();
                    Funcionario funcionarioResposavel = buscarFuncionario(funcionarios, idFuncionarioResponsavel);


                    Reserva reserva = new Reserva(idReuniao, dataHora, salaEscolhida, funcionarioResposavel);
                    reservaMes.adicionarReserva(reserva);

                    mostrarMenu();
                    opcao = scanner.nextInt();
                    break;

                case 4:

                    System.out.println("Insira o id do Funcionário: ");
                    int idAddFunc = scanner.nextInt();
                    System.out.println("Insira o id da Reunião: ");
                    int idReserva = scanner.nextInt();
                    reservaMes.addFuncionario(reservaMes, funcionarios, idAddFunc, idReserva );

                    break;

            }

        }
            reservaMes.mostrarReservas();
        scanner.close();
    }

    public void adicionarCargo(ArrayList<Cargo> cargos, Cargo cargo) {
        for (Cargo c : cargos) {
            if (c.getCargo().equalsIgnoreCase(cargo.getCargo())) {
                return;
            }
        }
        cargos.add(cargo);
    }

    public LocalDateTime formatarData(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dataHora = LocalDateTime.parse(data, formatter);
        return dataHora;
    }

    public void mostrarSalas(ArrayList<Sala> salas){
        for (Sala sala : salas) {
            System.out.println("Sala de Reunião " + sala.getNumeroSala() + " - Número de Lugares: " + sala.getQntLugar());
        }
    }

    public void mostrarFuncionario(ArrayList<Funcionario> funcionarios){
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getId() + " - " + funcionario.getNome());
        }
    }



    public Sala buscarSala(ArrayList<Sala> salas, int idReuniao){
        for(Sala sala: salas){
            if (sala.getNumeroSala() == idReuniao){
                return sala;
            }
        }
        return null;
    }

    public Funcionario buscarFuncionario (ArrayList<Funcionario> funcionarios, int idFuncionario){
        for (Funcionario funcionario: funcionarios){
            if(funcionario.getId() == idFuncionario){
                return funcionario;
            }
        }
        System.out.println("Funcionário não encontrado!");
        return null;
    }

    public void mostrarMenu() {
        System.out.println("\n--- SISTEMA DE RESERVA DE SALAS ---");
        System.out.println("1 - Cadastrar funcionário");
        System.out.println("2 - Cadastrar sala");
        System.out.println("3 - Criar reserva");
        System.out.println("4 - Adicionar funcionário em reserva");
        System.out.println("5 - Listar reservas");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void main(String[] args) {
        Programa programa = new Programa();
    }
}