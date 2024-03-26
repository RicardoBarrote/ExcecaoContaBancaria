package entidade;

public class Conta {

	private Integer numero;
	private String titular;
	private Double saldo;
	private double limiteSaque;

	public Conta() {

	}

	public Conta(Integer numero, String titular, Double saldo, double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public void deposito(Double valor) {
		saldo += valor;
	}

	public void saque(Double valor) throws RegraExcecao {
		validacaoSaque(valor);
		saldo -= valor;
	}

	public void validacaoSaque(Double valor) throws RegraExcecao {
		if (valor > limiteSaque) {
			throw new RegraExcecao("Erro: valor é maior que o limite permitido.");
		}
		if (valor > saldo) {
			throw new RegraExcecao("Erro: valor é maior que o saldo atual. ");
		}
	}
	@Override
	public String toString () {
		return "Titular da conta: "
				+ titular
				+", Saldo: "
				+ saldo
				+ ", Limite de saque: "
				+ limiteSaque;
	}
}
