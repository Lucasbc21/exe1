package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}
      public String os() {
    	 // Retorno do Sistema Operacional em execução; 
    	 String os = System.getProperty("os.name");
    	 String arch = System.getProperty("os.arch");
    	 String version = System.getProperty("os.version");
    	 return os + " - v."+ version +" - arch. "+ arch;
     }
     public void callProcess(String process) {
    	 
    	 try {
    	 Runtime.getRuntime().exec(process);
    	 } catch(IOException e) {
    		String msgErro = e.getMessage();
    		if(msgErro.contains("740")) {
    			StringBuffer buffer = new StringBuffer();
    			buffer.append("cmd /c");
    			buffer.append(" ");
    			buffer.append(process);
    			try {
    				Runtime.getRuntime().exec(buffer.toString());
    			} catch(IOException e1) {
    				e1.printStackTrace();
    			}
    			
    		} else {
    			System.err.println(msgErro);
    		}
    	 }
    	 
     }
     public void readProcess(String process) {
    	 
    	 RedesController procController	= new RedesController();
			String os = procController.os();
    	 try {
    		 Process p = Runtime.getRuntime().exec(process);
    		 InputStream fluxo = p.getInputStream();
    		 InputStreamReader leitor = new InputStreamReader(fluxo);
    		 BufferedReader buffer = new BufferedReader(leitor);
    		 String linha = buffer.readLine();
    		 while (linha != null) {
    			 System.out.println(linha);
    			 linha = buffer.readLine();
    			 }
    		 buffer.close();
    		 leitor.close();
    		 fluxo.close();
    	 } catch(IOException e) {
    		 e.printStackTrace();

    	 }
     }
     public void Segundachamada (String process2) {
    	 try {
    		 Process p = Runtime.getRuntime().exec(process2);
    		 InputStream fluxo = p.getInputStream();
    		 InputStreamReader leitor = new InputStreamReader(fluxo);
    		 BufferedReader buffer = new BufferedReader(leitor);
    		 String linha = buffer.readLine();
    		 while (linha != null) {
    			 System.out.println(linha);
    			 linha = buffer.readLine();
    			 }
    		 buffer.close();
    		 leitor.close();
    		 fluxo.close();
    	 } catch(IOException e) {
    		 e.printStackTrace();
    		 
    	 }
     }
}