package Metier;

public class Panier {
	private int id;
	private int id_pro;
	private int id_user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_pro() {
		return id_pro;
	}
	public void setId_pro(int id_pro) {
		this.id_pro = id_pro;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public Panier(int id, int id_pro, int id_user) {
		super();
		this.id = id;
		this.id_pro = id_pro;
		this.id_user = id_user;
	}
	

}
