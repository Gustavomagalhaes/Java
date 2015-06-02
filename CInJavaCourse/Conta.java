public class Conta {
	private String conta;
	private double saldo;
	private double limite;
	private Cliente cliente;
	
	public Conta(String conta, double saldo, double limite, Cliente cliente){
		this.conta = conta;
		this.saldo = saldo;
		this.limite = limite;
		this.cliente = cliente;	
	}
	public double getSaldo(){
		return saldo;
	}
	public double getLimite(){
		return limite;
	}
	public String getNome(){
		return cliente.getNome();
	}
	public String getCPF(){
		return cliente.getCPF();
	}
	public void setLimite(double valor){
		limite = valor;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getConta(){
		return conta;
	}
	public void creditar(double valor){
		saldo = saldo + valor;	
	}
	public void debitar(double valor){
		if (valor < limite){
			if (saldo > valor){
				saldo = saldo - valor;
			} else {
				System.out.print("Sem dinheiro");
			}
		} else {
			System.out.println("Valor acima do limite");
		}
	}
	public void transferir(double valor, Conta cliente){
		if (saldo > valor){
			saldo = saldo - valor;
			cliente.creditar(valor);
		} else {
			System.out.println("Dinheiro insuficiente");
		}
	}
	public boolean equalsConta(Conta conta){
		if (this.conta.equalsIgnoreCase(conta.conta)){
			return true;
		} else {
			return false;
		}
	}
}
