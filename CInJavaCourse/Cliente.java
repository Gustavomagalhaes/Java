
public class Cliente {
	private String nome;
	private String cpf;
	private TipoCliente tipo;
	
	public Cliente(String nome, String cpf, TipoCliente tipo){
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tipo;
	}
	public String getNome(){
		return this.nome;
	}
	public TipoCliente getTipo(){
		return this.tipo;
	}
	public String getCPF(){
		return this.cpf;
	}
	public boolean equalsCliente(Cliente cliente){
		if ((this.nome.equalsIgnoreCase(cliente.nome)) && (this.cpf.equalsIgnoreCase(cliente.cpf))){
			return true;
		} else {
			return false;
		}
	}
}

