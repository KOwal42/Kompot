package dane;


/**
 * Klasa przechowuj¹ca opcje wybrane przez u¿ytkownika
 * 
 *
 */
public class Opcjie{
	/**
	 * Konstruktor klasy Opcje inicjalizowany z deserialzowanych wartoœci
	 * @param deserialize Wartoœæ przekazywana z funkcji Deserialize
	 * @see ZapisOpcji#Deserialize()
	 * @see Opcjie
	 */
	public Opcjie(Opcjie deserialize) {
		this.wybur = deserialize.wybur;
	}
	/**
	 * Konstruktor klasy Opcje inicjalizowany z wartoœci¹ domyœln¹.
	 * U¿ywany przy pierwszym uruchomieniu programu.
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
