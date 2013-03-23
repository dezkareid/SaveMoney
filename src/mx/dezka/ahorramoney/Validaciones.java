package mx.dezka.ahorramoney;

public class Validaciones {

	public static boolean es_numero(String numero)
	{
		try {
			Float.parseFloat(numero);
			return true;
		} catch (Exception e) {
			return true;
		}
		
	}
}
