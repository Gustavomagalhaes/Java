
public class ContaTeste {
	public static void main(String[] args){
		
		Cliente gustavoPereira = new Cliente ("Gustavo Pereira", "111222333",TipoCliente.ESPECIAL);
		Cliente danielSouza = new Cliente ("Daniel Souza", "444555666",TipoCliente.OURO);
		
		Conta gustavo = new Conta ("1234", 3000.0, 1000.0,gustavoPereira);
		Conta daniel = new Conta ("1224", 2000.0, 1000.0,danielSouza);
		
		RepositorioConta c1 = new RepositorioConta();
		RepositorioConta c2 = new RepositorioConta();
		
		c1.inserir(gustavo);
		c2.inserir(daniel);
		
		c1.getPrint();
		c2.getPrint();
		System.out.println();
		
		System.out.println(gustavoPereira.getTipo());
		System.out.println(danielSouza.getTipo());
		System.out.println();
		
		System.out.println(gustavoPereira.equalsCliente(danielSouza));
		System.out.println(gustavo.equalsConta(daniel));
		System.out.println();
		
		gustavo.creditar(200.0);
		daniel.creditar(200.0); 

		System.out.println(gustavo.getNome()+" CPF:"+gustavo.getCPF());
		System.out.println("R$"+gustavo.getSaldo());
		System.out.println();
		
		System.out.println(daniel.getNome()+" CPF:"+daniel.getCPF());
		System.out.println("R$"+daniel.getSaldo());
		System.out.println();
		
		gustavo.debitar(1200.0); 
		daniel.debitar(1200.0); 
		
		System.out.println(gustavo.getNome()+" CPF:"+gustavo.getCPF());
		System.out.println("R$"+gustavo.getSaldo());
		System.out.println();
		
		System.out.println(daniel.getNome()+" CPF:"+daniel.getCPF());
		System.out.println("R$"+daniel.getSaldo());
		System.out.println();
		
		daniel.transferir(500.0, gustavo);
		
		System.out.println(gustavo.getNome()+" CPF:"+gustavo.getCPF());
		System.out.println("R$"+gustavo.getSaldo());
		System.out.println();
		
		System.out.println(daniel.getNome()+" CPF:"+daniel.getCPF());
		System.out.println("R$"+daniel.getSaldo());
		System.out.println();
	}
}
