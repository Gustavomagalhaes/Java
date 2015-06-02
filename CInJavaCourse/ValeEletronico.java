
public class ValeEletronico {
	private String id;
	private String nome;
	private String cpf;
	private double saldo;
	
	/** CONSTRUTOR DA CLASSE **/
	public void ValeEletronico(String id, String nome, String cpf, double saldo){
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.saldo = saldo;
	}
	
	/** GETS E SETS DA CLASSE **/
	public String GetId() {
		return id;
	}
	public void SetId(String id) {
		this.id = id;
	}
	public String GetNome() {
		return nome;
	}
	public void SetNome(String nome) {
		this.nome = nome;
	}
	public String GetCpf() {
		return cpf;
	}
	public void SetCpf(String cpf) {
		this.cpf = cpf;
	}
	public double GetSaldo() {
		return saldo;
	}
	public void SetSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	/** METODO PARA CARREGAR O CARTAO **/
	public void CarregarCartao(double valor){
		this.saldo+=valor;
	}
}
