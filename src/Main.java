import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import br.com.dio.desafio.dominio.Modulo;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        int opcao = 0;

        String menu = """
                \nBoas-vindas à trilha de Back-end Java do Bootcamp! Aprenda desde os primeiros passos com Java partindo da sintaxe básica até a implementação de uma API utilizando Spring para se tornar um profissional atrativo no mercado.
                Deseja prosseguir para a inscrição?
                1. SIIM!!
                2. Não.
                """;

        while(opcao != 2) {
            System.out.println(menu);
            opcao =scanner.nextInt();

            switch(opcao) {
                case 1: 
                    menuIncritoNoBootcamp(scanner, bootcamp);
                    break;
                case 2:
                    System.out.println("Poxa!! Adorariamos te ter por aqui, fique à vontade caso deseje retornar posteriormente.");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static void menuIncritoNoBootcamp(Scanner scanner, Bootcamp bootcamp) {

        Curso curso1 = new Curso();
        curso1.setTitulo("Aprendendo a Sintaxe Java");
        curso1.setDescricao("Curso introdutório de Java");
        curso1.setCargaHoraria(5);

        Curso curso2 = new Curso();
        curso2.setTitulo("Introdução e Estruturas Condicionais com Java");
        curso2.setDescricao("Introdução ao controle de fluxo");
        curso2.setCargaHoraria(1);

        Curso curso3 = new Curso();
        curso3.setTitulo("Fundamentos de Programação Orientada a Objetos com Java");
        curso3.setDescricao("Introdução ao POO");
        curso3.setCargaHoraria(3);

        Modulo modulo1 = new Modulo();
        modulo1.setTitulo("Dominando a linguagem de Programação Java");
        modulo1.getCursos().add(curso1);
        modulo1.getCursos().add(curso2);

        Modulo modulo2 = new Modulo();
        modulo2.setTitulo("Programação Orientada a Objetos com Java");
        modulo2.getCursos().add(curso3);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Live de lançamento do " + bootcamp.getNome());
        mentoria.setDescricao(bootcamp.getDescricao());
        mentoria.setData(LocalDate.now());
        mentoria.setHora(LocalTime.parse("16:00"));

        bootcamp.getConteudos().add(modulo1);
        bootcamp.getConteudos().add(modulo2);
        bootcamp.getConteudos().add(mentoria);

        Dev dev = new Dev();
        int opcao = 0;

        System.out.println("Qual é o seu nome?");
        String nome = scanner.next();
        dev.setNome(nome);

        System.out.println("Qual é o seu CPF?");
        int cpf = scanner.nextInt(); 
        dev.setCpf(cpf);

        dev.inscreverBootcamp(bootcamp);
        System.out.println("\nParabéns " + nome + "! Sua inscrição foi concluída com sucesso!! Confira a grade. \n" + dev.getConteudosInscritos());

        String menu = """
            \n---- Escolha o que deseja realizar: ----
            1. Progredir no curso
            2. Vizualizar o conteúdo inscrito
            3. Vizualizar o conteúdo concluído
            4. Vizualizar o XP
            5. Sair
            """;

        while(opcao != 5) {
            System.out.println(menu);
            opcao =scanner.nextInt();

            switch(opcao) {
                case 1: 
                    dev.progredir();
                    break;
                case 2:
                    System.out.println("Conteúdos Inscritos" + dev.getConteudosInscritos());
                    break;
                case 3:
                    System.out.println("Conteúdos Concluídos" + dev.getConteudosConcluidos());
                    break;
                case 4:
                    System.out.println("XP adquirido: " + dev.calcularTotalXp());
                    break;
                case 5: 
                    System.out.println("Menu encerrado! Retornando a tela principal.");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}

