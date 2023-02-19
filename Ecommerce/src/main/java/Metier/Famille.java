package Metier;

import java.io.InputStream;

public class Famille {
int numFamille;
String nomFamille;
InputStream PhotoFamille;
private String outputstream;
public String getOutputstream() {
	return outputstream;
}
public void setOutputstream(String outputstream) {
	this.outputstream = outputstream;
}

public Famille(int numFamille, String nomFamille, String outputstream) {
	super();
	this.numFamille = numFamille;
	this.nomFamille = nomFamille;
	this.outputstream = outputstream;
}
public Famille(int numFamille, String nomFamille) {
	super();
	this.numFamille = numFamille;
	this.nomFamille = nomFamille;
}
public Famille(String nomFamille) {
	super();
	this.nomFamille = nomFamille;
}
public int getNumFamille() {
	return numFamille;
}
public void setNumFamille(int numFamille) {
	this.numFamille = numFamille;
}
public String getNomFamille() {
	return nomFamille;
}
public void setNomFamille(String nomFamille) {
	this.nomFamille = nomFamille;
}
public InputStream getPhotoFamille() {
	return PhotoFamille;
}
public void setPhotoFamille(InputStream photoFamille) {
	PhotoFamille = photoFamille;
}
public Famille(int numFamille, String nomFamille, InputStream photoFamille) {
	super();
	this.numFamille = numFamille;
	this.nomFamille = nomFamille;
	PhotoFamille = photoFamille;
}
public Famille(String nomFamille, InputStream photoFamille) {
	super();
	this.nomFamille = nomFamille;
	PhotoFamille = photoFamille;
}



}
