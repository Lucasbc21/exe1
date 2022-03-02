 package view;
import javax.swing.JOptionPane;
import Controller.RedesController;

public class Principal {

	public static void main(String[] args) {
		int option;
		do {
			option = Integer.parseInt(JOptionPane.showInputDialog(
			"1 - Identificador de Sistema Operacional\n"+
			"2 - Chamada de configuração de IP\n"+
			"3 - Chamada de PING\n"+
			"9 - Finaliza"));
			RedesController procController	= new RedesController();
			String os = procController.os();
		switch(option) {
		
		case 1:System.out.println(os); break;
		
		case 2:String process = "ipconfig";procController.readProcess(process); 
		; break;
		
		case 3:String process2 = "PING www.google.com.br";procController.readProcess(process2); 
		; break;
		
		case 9: JOptionPane.showMessageDialog(null, "Encerrando.");break;

		default: JOptionPane.showMessageDialog(null, "Codigo invalido tente novamente");break;
		}
		}while(option != 9);
	}
}