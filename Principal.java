package concessionaria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Principal {
    // Lista para armazenar os veículos cadastrados
    private static ArrayList<Veiculo> veiculos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cadastro automatico de 7 carros
        cadastrarVeiculosIniciais();

        int opcao; // Declaração da variável para armazenar a opção do usuário
        do {
            // Exibir menu para o usuário
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Listar Veículos");
            System.out.println("3. Buscar Veículo por Placa");
            System.out.println("4. Remover Veículo por Placa");
            System.out.println("5. Modificar Veículo por Placa");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha 
           
            //Looping para o que executar em cada opção
            switch (opcao) {
                case 1:
                    
                    cadastrarVeiculo(scanner);// Aciona o método para cadastrar um novo veículo
                    break;
                case 2:
                    
                    listarVeiculos(); // Aciona o método para listar os veículos cadastrados
                    break;
                case 3:
                   
                    buscarVeiculo(scanner);// Aciona o método para buscar um veículo
                    break;
                case 4:
                    
                    removerVeiculo(scanner);// Aciona o método para remover um veículo por placa
                    break;
                case 5:
                    
                    modificarVeiculo(scanner);// Aciona o método para modificar um veículo por placa
                    break;
                case 6:
                    // Sair do programa
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);// Repete o loop até que a opção seja para sair

        scanner.close();// Fecha o objeto Scanner
    }

    //para o cadastro dos veículos automatico
    private static void cadastrarVeiculosIniciais() {
        veiculos.add(new Carro("ABC1234", 2020, "Toyota", "Corolla", "Preto", "João Silva", 85000.00));
        veiculos.add(new Carro("DEF5678", 2019, "Honda", "Civic", "Branco", "Maria Souza", 78000.00));
        veiculos.add(new Carro("GHI9101", 2018, "Ford", "Focus", "Prata", "Carlos Lima", 65000.00));
        veiculos.add(new Carro("JKL1121", 2021, "Chevrolet", "Cruze", "Vermelho", "Ana Pereira", 92000.00));
        veiculos.add(new Carro("MNO3141", 2017, "Hyundai", "Elantra", "Azul", "Roberto Costa", 70000.00));
        veiculos.add(new Carro("PQR5161", 2016, "Nissan", "Sentra", "Cinza", "Fernando Alves", 60000.00));
        veiculos.add(new Carro("STU7181", 2015, "Volkswagen", "Jetta", "Verde", "Lucia Santos", 55000.00));
    }

    //para cadastro de um novo veículo 
    private static void cadastrarVeiculo(Scanner scanner) {
        System.out.print("Digite a placa: ");
        String placa = scanner.nextLine();
        System.out.print("Digite o ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Digite a marca: ");
        String marca = scanner.nextLine();
        System.out.print("Digite o modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite a cor: ");
        String cor = scanner.nextLine();
        System.out.print("Digite o proprietário: ");
        String proprietario = scanner.nextLine();
        System.out.print("Digite o preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();  

        // Cria um novo objeto de veículo com os dados fornecidos para adiciona a lista
        Veiculo veiculo = new Carro(placa, ano, marca, modelo, cor, proprietario, preco);
        veiculos.add(veiculo);

        System.out.println("Veículo cadastrado com sucesso!");
    }

    // lista os veículos cadastrados de forma ordenada por ano
    private static void listarVeiculos() {
        // Ordenar a lista de veículos por ano
        Collections.sort(veiculos, Comparator.comparingInt(Veiculo::getAno));

        // Exibe os veículos no formato tubular
        System.out.printf("%-10s %-6s %-10s\n", "Placa", "Ano", "Marca");//especifica o formato, alinhamento, largura e formato
        for (Veiculo veiculo : veiculos) {
            System.out.printf("%-10s %-6d %-10s\n", veiculo.getPlaca(), veiculo.getAno(), veiculo.getMarca());
        }
    }

    //busca um veículo por placa e exibe todos os seus atributos
    private static void buscarVeiculo(Scanner scanner) {
        System.out.print("Digite a placa do veículo(Somente letras e números): ");
        String placa = scanner.nextLine();
 
        // Procura o veículo na lista e exibe suas informações caso seja encontrado
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println(veiculo);
                return;
            }
        }

        System.out.println("Veículo não encontrado!");
    }

    //remove um veículo por placa
    private static void removerVeiculo(Scanner scanner) {
        System.out.print("Digite a placa do veículo(Somente letras e números) a ser removido: ");
        String placa = scanner.nextLine();

        // Procura o veículo na lista e remove caso seja encontrado
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                // Pede confirmação ao usuário antes de remover
                System.out.print("Tem certeza que deseja remover este veículo? (s/n): ");
                String confirmacao = scanner.nextLine();
                if (confirmacao.equalsIgnoreCase("s")) {
                    veiculos.remove(veiculo);
                    System.out.println("Veículo removido com sucesso!");
                } else {
                    System.out.println("Remoção cancelada.");
                }
                return;
            }
        }

        System.out.println("Veículo não encontrado!");
    }

    // modifica os atributos de um veículo por placa
    private static void modificarVeiculo(Scanner scanner) {
        System.out.print("Digite a placa do veículo(Somente letras e números) a ser modificado: ");
        String placa = scanner.nextLine();

        // Procura o veículo na lista para modificação caso seja encontrado
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
             
                System.out.println("Veículo encontrado: " + veiculo);
                // Solicita os novos valores para os dados do veículo
                System.out.print("Digite o novo proprietário (ou deixe em branco para manter o atual):");
                 String novoProprietario = scanner.nextLine();
                if (!novoProprietario.isEmpty()) {
                    veiculo.setProprietario(novoProprietario);// Modifica o proprietário se um novo valor foi fornecido
                }

                System.out.print("Digite o novo preço (ou deixe em branco para manter o atual): ");
                String novoPrecoInput = scanner.nextLine();
                if (!novoPrecoInput.isEmpty()) {
                    double novoPreco = Double.parseDouble(novoPrecoInput);
                    veiculo.setPreco(novoPreco);// Modifica o preço se um novo valor foi fornecido
                }

                System.out.println("Veículo modificado com sucesso!");
                return;
            }
        }

        System.out.println("Veículo não encontrado!");
    }
}