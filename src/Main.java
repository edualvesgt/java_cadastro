import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<PessoaFisica> pessoasFisicas = new ArrayList<>();
    private static List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Cálculo de Imposto!");
        int choice;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Pessoa Física");
            System.out.println("2. Pessoa Jurídica");
            System.out.println("3. Sair do Sistema");
            System.out.print("Opção: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    menuPessoaFisica(scanner);
                    break;
                case 2:
                    menuPessoaJuridica(scanner);
                    break;
                case 3:
                    System.out.println("Saindo do Sistema. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (choice != 3);
    }

    public static void menuPessoaFisica(Scanner scanner) {
        int choice;

        do {
            System.out.println("\nEscolha uma opção para Pessoa Física:");
            System.out.println("1. Calcular Imposto");
            System.out.println("2. Cadastrar Pessoa Física");
            System.out.println("3. Listar Pessoas Físicas");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("Opção: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    float rendimento;
                    sleep(500);
                    System.out.print("Por favor, insira o rendimento mensal para Pessoa Física: ");
                    rendimento = scanner.nextFloat();

                    PessoaFisica pessoaFisica = new PessoaFisica();
                    float imposto = pessoaFisica.CalcularImposto(rendimento);
                    sleep(2000);
                    System.out.println("\nResumo do Cálculo de Imposto para Pessoa Física:");
                    System.out.println("----------------------------");
                    System.out.println("Rendimento Anual: $" + rendimento);
                    System.out.println("Imposto Calculado: $" + imposto);

                    System.out.print("\nPressione Enter para continuar...");
                    waitForEnter(scanner);
                    break;
                case 2:
                    cadastrarPessoaFisica(scanner);
                    break;
                case 3:
                    listarPessoasFisicas();
                    break;
                case 4:
                    System.out.println("Retornando ao Menu Principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (choice != 4);
    }

    public static void menuPessoaJuridica(Scanner scanner) {
        int choice;

        do {
            System.out.println("\nEscolha uma opção para Pessoa Juridica:");
            System.out.println("1. Calcular Imposto");
            System.out.println("2. Cadastrar Pessoa Juridica");
            System.out.println("3. Listar Pessoas Juridica");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("Opção: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    float rendimento;
                    sleep(500);
                    System.out.print("Por favor, insira o rendimento mensal para Pessoa Juridica: ");
                    rendimento = scanner.nextFloat();

                    PessoaJuridica pessoaJuridica = new PessoaJuridica();
                    float imposto = pessoaJuridica.CalcularImposto(rendimento);
                    sleep(2000);
                    System.out.println("\nResumo do Cálculo de Imposto para Pessoa Juridica:");
                    System.out.println("----------------------------");
                    System.out.println("Rendimento Anual: $" + rendimento);
                    System.out.println("Imposto Calculado: $" + imposto);

                    System.out.print("\nPressione Enter para continuar...");
                    waitForEnter(scanner);
                    break;
                case 2:
                    CadastrarPessoaJuridica(scanner);
                    break;
                case 3:
                    ListarPessoasJuridica(scanner);
                    break;
                case 4:
                    System.out.println("Retornando ao Menu Principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (choice != 4);
    }



    public static void cadastrarPessoaFisica(Scanner scanner) {
        PessoaFisica NovaPessoa = new PessoaFisica();
        Endereco NovoEndereco = new Endereco();

        System.out.println("Digite o nome da pessoa física: ");
        NovaPessoa.Nome = scanner.next();

        System.out.println("Digite o CPF: ");
        NovaPessoa.CPF = scanner.next();

        System.out.println("Digite o rendimento mensal (Digite somente numero): ");
        NovaPessoa.Rendimento = scanner.nextInt();

        System.out.println("Digite a data de Nascimento (dd/MM/aaaa): ");
        LocalDate Date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Period periodo = Period.between(Date, LocalDate.now());

        NovaPessoa.DataNascimento = String.valueOf(Date);

        if (periodo.getYears() >= 18) {
            System.out.println("A pessoa tem mais de 18 anos");
        } else {
            System.out.println("A pessoa tem menos de 18 anos. Retornando menu...");

        }

        System.out.println("Digite o logradouro: ");
        NovoEndereco.Logradouro = scanner.next();

        System.out.println("Digite o número: ");
        NovoEndereco.Numero = scanner.next();

        System.out.println("Este endereço é comercial? S/N: ");
        String EnderecoComercial;
        EnderecoComercial = scanner.next();

        if (EnderecoComercial.equalsIgnoreCase("S")) {
            NovoEndereco.EndereComercial = true;
        } else {
            NovoEndereco.EndereComercial = false;
        }

        NovaPessoa.Endereco = NovoEndereco;

        pessoasFisicas.add(NovaPessoa);

        System.out.println("Cadastro realizado com sucesso!");
    }

    public static void listarPessoasFisicas() {
        if (pessoasFisicas.size() > 0) {


            for (PessoaFisica list : pessoasFisicas) {
                System.out.println();
                System.out.println("Nome: " + list.Nome);
                System.out.println("CPF: " + list.CPF);
                System.out.println("Endereço: " + list.Endereco.Logradouro + ", " + list.Endereco.Numero);
                System.out.println("Data de Nascimento: " + list.DataNascimento.format(String.valueOf(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                System.out.println("Imposto a ser pago: " + list.CalcularImposto(list.Rendimento));
                System.out.println();
                sleep(3000);
            }


        } else {
            System.out.println("Lista vazia");
        }


    }

    public static void CadastrarPessoaJuridica(Scanner scanner) {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        Endereco endereco = new Endereco();

        System.out.println("Digite o nome da pessoa Juridica: ");
        pessoaJuridica.Nome = scanner.next();

        System.out.println("Digite o CNPJ: ");
        pessoaJuridica.CNPJ = scanner.next();

        System.out.println("Digite a Razao Social: ");
        pessoaJuridica.RazaoSocial = scanner.next();

        System.out.println("Digite o rendimento mensal (Digite somente numero): ");
        pessoaJuridica.Rendimento = scanner.nextInt();


        System.out.println("Digite o logradouro: ");
        endereco.Logradouro = scanner.next();

        System.out.println("Digite o número: ");
        endereco.Numero = scanner.next();

        System.out.println("Este endereço é comercial? S/N: ");
        String EnderecoComercial;
        EnderecoComercial = scanner.next();

        if (EnderecoComercial.equalsIgnoreCase("S")) {
            endereco.EndereComercial = true;
        } else {
            endereco.EndereComercial = false;
        }

        pessoaJuridica.Endereco = endereco;

        pessoasJuridicas.add(pessoaJuridica);

        System.out.println("Cadastro realizado com sucesso!");


    }
    public static void ListarPessoasJuridica(Scanner scanner) {
        if (pessoasJuridicas.size() > 0) {


            for (PessoaJuridica list : pessoasJuridicas) {
                System.out.println();
                System.out.println("Nome: " + list.Nome);
                System.out.println("CPF: " + list.CNPJ);
                System.out.println("Endereço: " + list.Endereco.Logradouro + ", " + list.Endereco.Numero);
                System.out.println("Imposto a ser pago: " + list.CalcularImposto(list.Rendimento));
                System.out.println();
                sleep(3000);
            }


        } else {
            System.out.println("Lista vazia");
        }
    }


    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void waitForEnter(Scanner scanner) {
        scanner.nextLine(); // Limpa o buffer de entrada
        scanner.nextLine(); // Aguarda que o usuário pressione Enter
    }
}

