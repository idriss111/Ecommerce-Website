package Metier;

import java.io.InputStream;

public class Produit {
//	int qtee=1;
private	int numProduit;
private int qte;
public int getQte() {
	return qte;
}
public void setQte(int qte) {
	this.qte = qte;
}
public Produit() {
	super();
}
private double puProduit;private String photo;
public Produit(int numProduit, double puProduit, String photo, String nomProduit, int famProduit) {
	super();
	this.numProduit = numProduit;
	this.puProduit = puProduit;
	this.photo = photo;
	this.nomProduit = nomProduit;
	this.famProduit = famProduit;
}
public Produit(double puProduit, String nomProduit, int famProduit, InputStream photoProduit) {
	super();
	this.puProduit = puProduit;
	this.nomProduit = nomProduit;
	this.famProduit = famProduit;
	this.photoProduit = photoProduit;
}
public Produit(int numProduit, double puProduit, String nomProduit, int famProduit, InputStream photoProduit) {
	super();
	this.numProduit = numProduit;
	this.puProduit = puProduit;
	this.nomProduit = nomProduit;
	this.famProduit = famProduit;
	this.photoProduit = photoProduit;
}
public double getPuProduit() {
	return puProduit;
}
public void setPuProduit(double puProduit) {
	this.puProduit = puProduit;
}
private String nomProduit;
private int famProduit;
private InputStream photoProduit;
public Produit(int numProduit, String nomProduit,int famProduit, InputStream photoProduit) {
	super();
	this.numProduit = numProduit;
	this.nomProduit = nomProduit;
	this.famProduit = famProduit;
	this.photoProduit = photoProduit;
}
public int getNumProduit() {
	return numProduit;
}
public void setNumProduit(int numProduit) {
	this.numProduit = numProduit;
}
public String getNomProduit() {
	return nomProduit;
}
public void setNomProduit(String nomProduit) {
	this.nomProduit = nomProduit;
}
public int getFamProduit() {
	return famProduit;
}
public void setFamProduit(int famProduit) {
	this.famProduit = famProduit;
}
public InputStream getPhotoProduit() {
	return photoProduit;
}
public void setPhotoProduit(InputStream photoProduit) {
	this.photoProduit = photoProduit;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
	

}
