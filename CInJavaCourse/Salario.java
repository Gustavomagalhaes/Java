
public class Salario extends Conta {
	double taxa;
	
	public Salario(String conta, double saldo, double limite, Cliente cliente, double taxa){
		super(conta, saldo, limite, cliente);
		this.taxa = taxa;
	}
	public double getTaxa() {
		return taxa;
	}
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	public void creditar(double valor){
		valor = valor*0.95;
		setSaldo(getSaldo() + valor);
	}
}
