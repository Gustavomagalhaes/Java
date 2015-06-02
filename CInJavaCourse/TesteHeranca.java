
public class TesteHeranca {
	public static void main(String[] args) {
		
		Cliente gustavoPereira = new Cliente ("Gustavo Pereira", "111222333",TipoCliente.ESPECIAL);
		Cliente danielSouza = new Cliente ("Daniel Souza", "444555666",TipoCliente.OURO);
		
		Conta gustavo;
		gustavo = new Poupanca("1234", 300.0, 1000.0,gustavoPereira,10.0);
		
		Conta daniel;
		daniel = new Salario ("1224", 200.0, 1000.0,danielSouza,50.0);
		
		
		System.out.println(gustavo.getNome()+" CPF:"+gustavo.getCPF());
		System.out.println("R$"+gustavo.getSaldo());
		System.out.println();
		
		System.out.println(daniel.getNome()+" CPF:"+daniel.getCPF());
		System.out.println("R$"+daniel.getSaldo());
		System.out.println();
		
		if (gustavo instanceof Poupanca){
			gustavo.creditar(200.0);
			System.out.println("SUCCEED");
		} else {
			System.out.println("FAIL");
		}
		if (daniel instanceof Salario){
			daniel.creditar(200.0);
			System.out.println("SUCCEED");
		} else {
			System.out.println("FAIL");
		}
		
		System.out.println();
		System.out.println(gustavo.getNome()+" CPF:"+gustavo.getCPF());
		System.out.println("R$"+gustavo.getSaldo());
		System.out.println();
		
		System.out.println(daniel.getNome()+" CPF:"+daniel.getCPF());
		System.out.println("R$"+daniel.getSaldo());
		System.out.println();
		
	}

}
