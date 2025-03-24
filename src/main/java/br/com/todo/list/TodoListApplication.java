package br.com.todo.list;

import br.com.todo.list.adapters.controller.TarefaController;
import br.com.todo.list.application.TarefaService;
import br.com.todo.list.domain.NotificadorDePrazo;
import br.com.todo.list.domain.Status;
import br.com.todo.list.infrastructure.Notificador;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class TodoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoListApplication.class, args);

        NotificadorDePrazo notificador = new NotificadorDePrazo();

        TarefaService tarefaService = new TarefaService(notificador);

        TarefaController tarefaController = new TarefaController(tarefaService);
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        while (true) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Filtrar Tarefas por Status");
            System.out.println("4. Listar Tarefas Ordenadas por Prazo ");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Titulo: ");
                    String titulo = scanner.nextLine();

                    System.out.println("Descrição: ");
                    String descricao = scanner.nextLine();

                    System.out.println("Prazo (Formato: dd-MM-yyyy HH:mm): ");
                    String prazoInput = scanner.nextLine();

                    try {
                        LocalDateTime prazo = LocalDateTime.parse(prazoInput, formatter);
                        System.out.print("Status (PENDENTE, EM_ANDAMENTO, CONCLUIDO): ");
                        String statusInput = scanner.nextLine();
                        Status status = Status.valueOf(statusInput.toUpperCase());

                        tarefaController.adicionarTarefa(titulo, descricao, prazo, status);
                    } catch (Exception ex) {
                        System.out.println("Erro ao adicionar tarefa: " + ex.getMessage());

                    }
                    break;

                case 2:
                    System.out.println("Todas as Tarefas: ");
                    tarefaController.listarTarefas().forEach(tarefa -> {
                        System.out.println("Titulo: " + tarefa.getTitulo() + ", Descrição" + tarefa.getDescricao() + ", Prazo: " + tarefa.getPrazo() + ", Status" + tarefa.getStatus());
                    });
                    break;

                case 3:
                    System.out.println("Digite o status para filtrar (PENDENTE, EM_ANDAMENTO, CONCLUIDO): ");
                    String statusFiltro = scanner.nextLine();
                    tarefaController.filtrarTarefasPorStatus(Status.valueOf(statusFiltro.toUpperCase()))
                            .forEach(tarefa -> {
                                System.out.println("Titulo: " + tarefa.getTitulo() + ", Descrição" + tarefa.getDescricao() + ", Prazo: " + tarefa.getPrazo() + ", Status" + tarefa.getStatus());

                            });
                    break;
                case 4:
                    System.out.println("Tarefas Ordenadas Por Prazo: ");
                    tarefaController.listarTarefasOrdenadasPorPrazo().forEach(tarefa -> {

                        System.out.println("Titulo: " + tarefa.getTitulo() + ", Descrição" + tarefa.getDescricao() + ", Prazo: " + tarefa.getPrazo() + ", Status" + tarefa.getStatus());


                    });
                    break;
                case 5:
                    System.out.println("Saindo... ");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção invalida. Tente novamente! ");
            }

        }


    }

}
