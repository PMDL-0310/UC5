package cadastroDeClienteBancoDeDados;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ClienteDAO dao = new ClienteDAO();
		
		while (true) {
			System.out.println("\n===== MENU =====");
			System.out.println("1 - Cadastrar Cliente");
			System.out.println("2 - Listar Clientes");
			System.out.println("3 - Atualizar Cliente");
			System.out.println("4 - Deletar Cliente");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");
			
			int opcao = scanner.nextInt();
			scanner.nextLine(); // Limpa buffer
			
			switch (opcao) {
			case 1:
				System.out.println("Nome: ");
				String nome = scanner.nextLine();
				System.out.println("Email: ");
				String email = scanner.nextLine();
				
				Cliente cliente = new Cliente(nome, email);
				dao.inserir(cliente);
				break;
					
			case 2:
				List<Cliente> clientes = dao.listarCliente();
				System.out.println("\n--- Lista de Clientes ---");
				for (Cliente c: clientes) {
					System.out.println(c.getId() + " - " + c.getNome() + " (" + c.getEmail() + ")");
				}
				break;
					
			case 3:
				System.out.println("ID do cliente para atualizar: ");
				int idAtualizar = scanner.nextInt();
				scanner.nextLine(); // Limpa buffer
				System.out.println("Novo nome: ");
				String novoNome = scanner.nextLine();
				System.out.println("Novo email: ");
				String novoEmail = scanner.nextLine();
				
				Cliente clienteAtualizado = new Cliente(idAtualizar, novoNome, novoEmail);
				dao.atualizar(clienteAtualizado);
				break;
					
			case 4:
				System.out.print("ID do cliente para deletar: ");
				int idDeletar = scanner.nextInt();
				dao.deletar(idDeletar);
				break;
				
			case 0:
				System.out.println("Saindo...");
				scanner.close();
				return;
				
				default:
					System.out.println("Opção inválida!");
			}
		}

	}

}
