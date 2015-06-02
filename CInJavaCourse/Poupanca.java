
public class Poupanca extends Conta{
	private double bonus;
	
	public Poupanca(String conta, double saldo, double limite, Cliente cliente, double bonus){
		super(conta, saldo, limite, cliente);
		this.bonus = bonus;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public void transferir(double valor, Conta cliente){
		valor = valor*0.80; // 80 porcento
		cliente.debitar(valor);
		cliente.creditar(valor);
	}
}