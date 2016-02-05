
import java.io.*;

public class main {

	public static void main(String[] args) {
		BufferedReader reader = null;
		String read = null;
		try{
			reader = new BufferedReader(new FileReader("anser.csv"));
		}catch(FileNotFoundException e){
			System.err.println("Datei nicht gefunden!");
		}
		
		String output = "";		
		
		output += ("<?xml version=\"1.0\"?>\n");
		output += ("<xml>\n");
		

		try{
			read = reader.readLine();
			String[] separator;
			while(read != null){
				
				separator = read.split(",");
				output += ("	<Data>\n");
				int tmp = (separator.length);
				int lng = 0;
				
				
				while(tmp > lng){
					
					output += ("		<>" 		+ separator[lng] + "</>\n");
					lng++;
				}
 				
			
				
				
				output += ("	</Data>\n");
				read = reader.readLine();
			}
		} 
		catch (IOException e){
			System.err.println("Datei kann nicht gelesen werden!");
		}
		
		output += ("</xml>");
		System.out.println(output);
		BufferedWriter schreiben = null;
		try{
			schreiben = new BufferedWriter(new FileWriter("anser.xml"));
		}
		catch (IOException e){
			System.err.println("Konnte Datei nicht schreiben!");
		}
		
		try{
			schreiben.write(output);
		} catch(IOException e){
			System.err.println("Konnnte nicht in Datei schreiben!");
		}
		
		try{
			schreiben.close();
		} catch(IOException e){
			System.err.println("Konnnte Datei nicht schliessen!");
		}
	}	
		

}
