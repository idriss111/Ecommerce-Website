package Metier;

public class Client {
private int numClient;
private String nomClient;
private String prenomClient;
private String adresse;
private String password;

public String getNomClient() {
	return nomClient;
}
public void setNomClient(String nomClient) {
	this.nomClient = nomClient;
}
public String getPrenomClient() {
	return prenomClient;
}
public void setPrenomClient(String prenomClient) {
	this.prenomClient = prenomClient;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public int getNumClient() {
	return numClient;
}
public void setNumClient(int numClient) {
	this.numClient = numClient;
}
public Client(int numClient, String nomClient, String prenomClient, String adresse, String password) {
	super();
	this.numClient = numClient;
	this.nomClient = nomClient;
	this.prenomClient = prenomClient;
	this.adresse = adresse;
	this.password = password;

}

public Client(String nomClient, String prenomClient, String adresse, String password) {
	super();
	this.nomClient = nomClient;
	this.prenomClient = prenomClient;
	this.adresse = adresse;
	this.password = password;

}
public Client(String nom,String password) {
	super();
	this.nomClient=nom;
	this.password = password;

}
public Client() {
	super();
}



}
