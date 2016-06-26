package dane;



public class Opcjie{
	public Opcjie(Opcjie deserialize) {
		this.wybur = deserialize.wybur;
	}

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
