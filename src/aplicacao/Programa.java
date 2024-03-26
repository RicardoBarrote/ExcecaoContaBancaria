package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidade.Conta;
import entidade.RegraExcecao;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe os dados da conta: ");
		System.out.print("Número da conta: ");
		Integer nConta = sc.nextInt();
		System.out.print("Titular da conta: ");
		sc.nextLine();
		String titular = sc.nextLine();
		System.out.print("Saldo inicial: ");
		Double saldo = sc.nextDouble();
		System.out.print("Limite de saque: ");
		Double limiteSaque = sc.nextDouble();

		Conta conta = new Conta(nConta, titular, saldo, limiteSaque);
		System.out.println();

		try {
			System.out.println("Informe uma quantia para sacar: ");
			Double valorSaque = sc.nextDouble();

			conta.saque(valorSaque);

		} 
		catch (RegraExcecao e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado. ");
		}
		
		System.out.println();
		System.out.println(conta);
		
		sc.close();
	}

}
