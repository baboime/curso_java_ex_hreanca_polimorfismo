package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;
import entidades.FuncionarioTerceiro;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> listaFunc = new ArrayList<>();
		
		System.out.print("Informe o número de funcionários: ");
		int qtdeFunc = sc.nextInt();
		
		for (int i=1; i<=qtdeFunc; i++) {
			System.out.println("Dados do funcionário #" + i);
			System.out.print("Tercerizado (s/n)? ");
			char respTerc = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nomeFunc = sc.nextLine();
			System.out.print("Horas: ");
			int qtdeHoras = sc.nextInt();
			System.out.print("Valor por hora: ");
			double valorHora = sc.nextDouble();
			double valorAdicional = 0.0;
			if (respTerc == 's') {
				System.out.print("Valor adicional: ");
				valorAdicional = sc.nextDouble();
//				Funcionario func = new FuncionarioTerceiro(nomeFunc, qtdeHoras, valorHora, valorAdicional);
//              listaFunc.add(func);
				listaFunc.add(new FuncionarioTerceiro(nomeFunc, qtdeHoras, valorHora, valorAdicional));
			}
			else {
//				Funcionario func = new Funcionario(nomeFunc, qtdeHoras, valorAdicional);
//              listaFunc.add(func);
				listaFunc.add(new Funcionario(nomeFunc, qtdeHoras, valorHora));
			}			
		}
		
		System.out.println();
		System.out.println("Pagamentos: ");
		for (Funcionario func : listaFunc) {
			System.out.println(func.getNome() + " - $ " + String.format("%.2f", func.pagamento()));
		}		
		sc.close();
	}

}
