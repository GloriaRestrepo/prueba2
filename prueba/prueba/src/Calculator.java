import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	/**
	 * Funcion que retorna la suma de los numeros positivos de cierto
	 * patron y especificaciones.
	 * @param String cadena La cadena que ingresa el usuario
	 * @return int retorna -2 si ingreso numeros negativos, retorna
	 * -1 si el patron no concuerda.
	 */
	public int add(String cadena) {

		String patron2 = "^//(\\[([^\\[\\]0-9])+\\])*\n"; //patron para evaluar los delimitadores
		String patron3 = "\\[[^\\[\\]0-9]+\\]"; //patron para obtener los delimitadores
		String patron4 = "^([0-9]*)((,|\n)[0-9]+)*"; //patron para evaluar la cadena de numeros a sumar
		String patron4part1 = "^([0-9]*)((,|\n"; //en caso de agregar delimitadores
		String patron4part2 = ")[0-9]+)*"; //en caso de agregar delimitadores
		String patron5 = "(-[0-9]*)((,|\n)-[0-9]+)*"; //patron para evaluar si la cadena de numeros a sumar tiene negativos
		String patron5part1 = "(-?[0-9]*)((,|\n";//en caso de agregar delimitadores
		String patron5part2 = ")-?[0-9]+)*";//en caso de agregar delimitadores
		String patron6 = "(-[0-9]*)"; // para obtener los numeros negativos
		String patron7 = "\\d+"; // para obtener los numeros de la cadena de numeros a sumar
		String[] delimitadores; //array que almace los delimitadores
		String cadenaSuma = ""; //la cadena con los numeros a sumar
		String cadenaDelimits = ""; //la cadena con los delimitadores
		int foo = 0; //variable auxiliar
		int suma = 0; //variable donde se guarda la suma de los numeros
		int num = 0; //variable auxiliar
		
		Pattern patroningreso = Pattern.compile(patron2);		
		Matcher matcher = patroningreso.matcher(cadena);
		
		if (matcher.find()) {
			cadenaSuma = cadena.substring(matcher.end());
			cadenaDelimits = cadena.substring(0,matcher.end()-1);
			
			patroningreso = Pattern.compile(patron3);		
			matcher = patroningreso.matcher(cadenaDelimits);			
			while(matcher.find()){
				foo++;
			}
			
			matcher = patroningreso.matcher(cadena);
			String foo2 = "";
			delimitadores = new String[foo];
			for(int i=0;i<foo;i++){
				matcher.find();
				foo2 = matcher.group();
				foo2 = foo2.substring(1,foo2.length()-1);
				delimitadores[i] = this.evaluarCadena(foo2);
			}
			for(int i=0;i<foo;i++){
				patron4part1 += "|"+delimitadores[i];
				patron5part1 += "|"+delimitadores[i];
			}
			patron4 = patron4part1+patron4part2;
			patron5 = patron5part1+patron5part2;
		} else {
			delimitadores = new String[0];
			cadenaSuma = cadena;
		}			
		
		patroningreso = Pattern.compile(patron4);			
		matcher = patroningreso.matcher(cadenaSuma);
		
		if (matcher.matches()) {
			patroningreso = Pattern.compile(patron7);			
			matcher = patroningreso.matcher(cadenaSuma);
			while (matcher.find()) {
				num = Integer.parseInt(matcher.group());
				if (num <= 1000) {
					suma += num;
				}
			}
			return suma;
		} else {
			patroningreso = Pattern.compile(patron5);			
			matcher = patroningreso.matcher(cadenaSuma);
			
			if (matcher.matches()) {
				patroningreso = Pattern.compile(patron6);
				matcher = patroningreso.matcher(cadenaSuma);
				while(matcher.find()){
					System.out.println(matcher.group());
				}
				return -2;
			}
		}
		
		return -1;		
	}
	
	/**
	 * Funcion que recibe una cadena y retorna una cadena formateada para
	 * que los caracteres especiales se puedan usar en las expresiones
	 * regulares.
	 * @param String cadena
	 * @return String cadena formateada
	 */
	private String evaluarCadena(String cadena)
	{		
		String foo = "";
		int longCad = cadena.length();
		String caracter = "";
		
		Pattern patroningreso = Pattern.compile("[\\*\\?\\+]");		
		Matcher matcher = patroningreso.matcher(cadena);
		
		if (matcher.find()) {
			for (int i=0;i<longCad;i++) {
				caracter = Character.toString(cadena.charAt(i));
				matcher = patroningreso.matcher(caracter);
				if (matcher.find()) {
					foo += "\\"+caracter; 
				} else {
					foo += caracter;
				}
			}	
		} else {
			foo = cadena;
		}		
		return foo;
	}
}