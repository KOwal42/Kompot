package dane;


/**
 * Klasa przechowuj�ca opcje wybrane przez u�ytkownika
 * 
 *
 */
public class Opcjie{
	/**
	 * Konstruktor klasy Opcje inicjalizowany z deserialzowanych warto�ci
	 * @param deserialize Warto�� przekazywana z funkcji Deserialize
	 * @see ZapisOpcji#Deserialize()
	 * @see Opcjie
	 */
	public Opcjie(Opcjie deserialize) {
		this.wybur = deserialize.wybur;
	}
	/**
	 * Konstruktor klasy Opcje inicjalizowany z warto�ci� domy�ln�.
	 * U�ywany przy pierwszym uruchomieniu programu.
	 * @see Opcjie
	 */
	public Opcjie() {
		wybur = 0;
	}

	private int wybur;

	public int getWybur() {
		return wybur;
	}

	public void setWybur(int wybur) {
		this.wybur = wybur;
	}

}
