package Servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import Metier.Client;
import Metier.Commande;
import Metier.Famille;
import Metier.Produit;
import Metier.Client;

import dao.CommandeJDBC;
import dao.FamilleJDBC;
import dao.JDBC;

import dao.LoginJDBC;
import dao.ProduitJDBC;
import dao.RegisteerJDBC;


@WebServlet({"/login","/register","/ajouterFamille","/ajouterProduit","/Home","/listerProduits",
	"/supprimerFamille","/supprimerProduit","/panier","/commande","/logout","/commandeValide","/deletElment","/viderPanier"
	,"/consulterCommandes","/modifierProduit"})
@MultipartConfig
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	ArrayList<Produit> produitss = null;
	ArrayList<Produit> pro= new ArrayList<Produit>(); 
	public static String noo=null;
	Produit p=new Produit();
	static String nomm=null;
	static String nommm=null;
	 int j=1;
	
    public Servlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getServletPath().equals("/login") || request.getServletPath().equals("/register")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			doPost(request,response);
			
		}
		if (request.getServletPath().equals("/ajouterFamille") ) {
			doPost(request,response);
		}
		 if (request.getServletPath().equals("/ajouterProduit")) {
			  doPost(request,response);
		  }
		 if (request.getServletPath().equals("/Home") ) {
			 ArrayList<Famille> familles = null;
				try {
					familles = FamilleJDBC.getFamillesWithPic();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
				request.setAttribute("familles", familles);
				//
				ArrayList<Produit> produits = null;
				try {
					produits = ProduitJDBC.getProduitsWithPic();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
				request.setAttribute("produits", produits);
			//	int id=
				
				request.getRequestDispatcher("/ecom_templates/index.jsp").forward(request, response);
			 doPost(request,response);
			}
		 if (request.getServletPath().equals("/listerProduits") ) {
				doPost(request,response);
			}
		 if (request.getServletPath().equals("/supprimerFamille") ) {
           		request.getRequestDispatcher("/Admin/supprimer.jsp").forward(request, response);
                doPost(request,response);
			}
		 if (request.getServletPath().equals("/modifierProduit") ) {
        	//	request.getRequestDispatcher("/Admin/Modifier1.jsp").forward(request, response);
        		 
					
	 				
			 doPost(request,response);
			}
		 if (request.getServletPath().equals("/modifierFamille") ) {
     		request.getRequestDispatcher("/Admin/Modifier1.jsp").forward(request, response);

			 doPost(request,response);
			}
		 if (request.getServletPath().equals("/commande") ) {
				
			 doPost(request,response);
			}
		 
		 // panier
		 if (request.getServletPath().equals("/panier")) {
			 System.out.println("halala");
			 String nompro= request.getParameter("nompro");
			String photopro= request.getParameter("photoproduit");
			String prixpro= request.getParameter("prixproduit");
			System.out.println(nompro);
			System.out.println(photopro);
			System.out.println(prixpro);
		request.setAttribute("nompro", nompro);
		request.setAttribute("photopro", photopro);
		request.setAttribute("prixpro", prixpro);

			 doPost(request,response);
		  }
		 if (request.getServletPath().equals("/logout")) {
			 System.out.println("/logout doget:");
			 doPost(request,response);
		 }
		 if (request.getServletPath().equals("/commandeValide") ) {
			 doPost(request,response);
		 }
		 
		 if (request.getServletPath().equals("/deletElment") ) {
			 doPost(request,response);
		 }
		 if (request.getServletPath().equals("/viderPanier") ) {
				
			 doPost(request,response);
			}
		 if (request.getServletPath().equals("/consulterCommandes") ) {
				
			 doPost(request,response);
			}
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               
		System.out.println(request.getServletPath());
		//login
               if (request.getServletPath().equals("/login")) {
           		System.out.println("tests");

            	     try {
            	    	 request.setAttribute("error", "OK");

            					String name = request.getParameter("nom");
            					String pass = request.getParameter("password");
            					System.out.println("nom :" + name);
            					System.out.println("pass :" + pass);
                               // JDBC.connect();
            					if (name.equals("admin") && pass.equals("admin")) {
            						request.getRequestDispatcher("Admin/Ajouter.jsp").forward(request, response);
            					}
            					Client client=LoginJDBC.getClient(name, pass);
            					if(client.getPassword()==null) {
            						System.out.println("non");
            					String	error= "le nom ou le mot de passe sont incorrectes";	
            						request.setAttribute("error", error);
            					String erreur=	(String) request.getAttribute("error");
            					System.out.println(erreur);
            				   request.getRequestDispatcher("login.jsp").forward(request, response);
            					}
            					else {
            						HttpSession session= request.getSession();
            						System.out.println("created ");
            						//--------------------------
            						Client c1=LoginJDBC.getClient(name,pass);
            						//--------------------------
            						System.out.println( c1.getNomClient());
            						session.setAttribute("idd",c1.getNumClient());
            						System.out.println("++++++++++++++++++++");
            						System.out.println(c1.getNumClient());
            						System.out.println("++++++++++++++++++++");
            						session.setAttribute("nom",c1.getNomClient());
            						session.setAttribute("prenom", c1.getPrenomClient());
            						session.setAttribute("adresse", c1.getAdresse());
            						session.setAttribute("password", c1.getPassword());
            					//	session.setAttribute("client", c1);
                                     request.setAttribute("client", c1);
                                     ArrayList<Famille> familles = null;
                     				try {
                     					familles = FamilleJDBC.getFamillesWithPic();
                     				} catch (InstantiationException | IllegalAccessException e) {
                     					e.printStackTrace();
                     				}
                     				request.setAttribute("familles", familles);
                     				//
                     				ArrayList<Produit> produits = null;
                     				try {
                     					produits = ProduitJDBC.getProduitsWithPic();
                     				} catch (InstantiationException | IllegalAccessException e) {
                     					e.printStackTrace();
                     				}
                     				request.setAttribute("produits", produits);
                     				
                     				request.getRequestDispatcher("/ecom_templates/index.jsp").forward(request, response);
         						
            						
            							
            						
            						}
               }catch(Exception e) {

					e.printStackTrace();
				}}
               
        //register
               
	else if (request.getServletPath().equals("/register")) {
		System.out.println("/register");
          	     try {
          				String prenom=request.getParameter("prenom");
          				System.out.println("prenom :" + prenom);
          				String nom=request.getParameter("nom");
          				String adresse=request.getParameter("adresse");
          				String password=request.getParameter("password");
          				Client c=new Client(nom,prenom,adresse,password);
          				RegisteerJDBC.saveRegistration(c);
          	     } catch (Exception e) {
      				
      				e.printStackTrace();}
	}
	
	//ajouter famille
               
	else if (request.getServletPath().equals("/ajouterFamille")) {
			
 	     try {ArrayList <Famille> familles=FamilleJDBC.getFamilles();
			request.setAttribute("familles", familles);
			request.getRequestDispatcher("/Admin/Ajouter.jsp").forward(request, response);

 				String nomfam=request.getParameter("nomf");
 				System.out.println(nomfam);
 				//System.out.println("prenom :" + n);
 				InputStream inputStream = null ;//input stream of uploaded file
				Part part = request.getPart("photoFamille");
				if(part!=null){	
				System.out.println(part.getName());
				System.out.println(part.getSize());
				System.out.println(part.getContentType());
				inputStream = part.getInputStream(); 	}			
				Famille f=new Famille(nomfam,inputStream);
				FamilleJDBC.saveFamille(f);
				FamilleJDBC.getFamilles();
 	     } catch (Exception e) {
				
				e.printStackTrace();}
}
               
               //ajouter produit
	else if (request.getServletPath().equals("/ajouterProduit")) {
		
		System.out.println("hna1");
	     try {  
	    	 ArrayList <Famille> familles=FamilleJDBC.getFamilles();
				request.setAttribute("familles", familles);
				familles.get(1);
				request.getRequestDispatcher("/Admin/Ajouter.jsp").forward(request, response);
	    	 double prixpro=Double.parseDouble(request.getParameter("prixProduit"));
	    	 System.out.println("prix:");
	    	 System.out.println(prixpro);
				String nomprod=request.getParameter("nomProduit");
				System.out.println(nomprod);
				//System.out.println("prenom :" + n);
				InputStream inputStream = null ;//input stream of uploaded file
				Part part = request.getPart("photoProduit");
				if(part!=null){	
				System.out.println(part.getName());
				System.out.println(part.getSize());
				System.out.println(part.getContentType());
				inputStream = part.getInputStream(); 	}			
				
				String nomFamille=request.getParameter("famille");
				int nfam=FamilleJDBC.getFamillesNumber(nomFamille);
				Produit pr=new Produit(prixpro,nomprod,nfam,inputStream);
				ProduitJDBC.saveProduit(pr);
	     } catch (Exception e) {
				
				e.printStackTrace();}
}
              
               //home
               
	else if (request.getServletPath().equals("/Home")) {
	//	  pro.clear();
		
		System.out.println(  request.getParameter("nomFamille"));
		 nommm=request.getParameter("nomFamille");
		 // int nump=Integer.parseInt(request.getParameter("nump"));
		//  System.out.println(nump);
		  if (nomm==null) 
	    nomm=request.getParameter("nomFamille");
	   // request.setAttribute("nomfam", nomm);
   		ArrayList<Produit> produitss = null;
       	try {
       		int id=	FamilleJDBC.getIdFamille(nommm);
       		produitss=ProduitJDBC.getProduitsFromFam(id);
       		request.setAttribute("produitss", produitss);
       		request.getRequestDispatcher("/ecom_templates/produits.jsp").forward(request, response);
       		

       	} catch (InstantiationException | IllegalAccessException e) {
       		
       		e.printStackTrace();
       	}
		  
	}
               if (request.getServletPath().equals("/listerProduits") ) {
            	   
            	   System.out.println( "parametre"+ request.getParameter("nomfam"));
            	   System.out.println( "attribut"+request.getAttribute("nomfamm"));
            	   
            	   String noo=(String) request.getAttribute("nomfam");
            	   
            	   String nomm=request.getParameter("nomfam");
              		ArrayList<Produit> produitss = null;
                  	try {
                  		int id=	FamilleJDBC.getIdFamille(nomm);
                  		produitss=ProduitJDBC.getProduitsFromFam(id);
                  		request.setAttribute("produitss", produitss);}
                  	catch(Exception e) {}
            	   
            	   
            	   String nompro= request.getParameter("nompro");
            	   System.out.println(nompro);
       			String photopro= request.getParameter("photoProduit");
       			String prixpro= request.getParameter("prixProduit");
       			System.out.println(prixpro);
       			Produit p=new Produit();
       			p.setNomProduit(nompro);
       			p.setPuProduit(Double.parseDouble(prixpro));
       			p.setPhoto(photopro);
       			ArrayList<Produit> pro= new ArrayList<Produit>();pro.add(p);
       			request.setAttribute("pros", pro);
              		response.sendRedirect("/ecom_templates/produits.jsp");

           		
             }
               //supprimer famille
               
               if (request.getServletPath().equals("/supprimerFamille") ) {
            	   String nom=request.getParameter("nomf");
   				System.out.println(nom);
   				try {
					if(FamilleJDBC.verifierFamille(nom)) {
						FamilleJDBC.deleteFamille(nom);
						System.out.println("supression avec success");
					}
					else {
						request.setAttribute("existePas", "Famille non existante");
						System.out.println("non existant");
					}
				} catch (InstantiationException | IllegalAccessException e) {
					
					e.printStackTrace();
				}
            	   
   		        request.getRequestDispatcher("/Admin/supprimer.jsp").forward(request, response);

   			}
               // supprimer produit 
               
               if (request.getServletPath().equals("/supprimerProduit") ) {
            	   String nom=request.getParameter("nomProduit");
   				System.out.println(nom);
   				try {
					if(ProduitJDBC.verifierProduit(nom)) {
						ProduitJDBC.deleteProduit(nom);
						System.out.println("supression avec success");
					}
					else {
						request.setAttribute("existePas", "Produit non existant");
						System.out.println("non existant");
					}
				} catch (InstantiationException | IllegalAccessException e) {
					
					e.printStackTrace();
				}
            	   
   		        request.getRequestDispatcher("/Admin/supprimer.jsp").forward(request, response);

   			}
               if (request.getServletPath().equals("/panier") ) {
            	 
            	   System.out.println( "b=nump:  "+ request.getParameter("nump"));
            	   int nump=Integer.parseInt(request.getParameter("nump"));
            	   System.out.println(nump);
            	   
            	   System.out.println( "parametre"+ request.getParameter("nomfam"));
            	   System.out.println( "attribut"+request.getAttribute("nomfamm"));
            	   HttpSession session= request.getSession();
				session.setAttribute("famille",request.getParameter("nomfam"));
            	  if (noo==null)
            	    noo=(String) request.getAttribute("nomfam");
            	  if (nomm==null)
            	  nomm=request.getParameter("nomfam");
            	  System.out.println("*=====hnaaaaa"+nommm);
              	   
            	  
                  	try {
                  		int id=	FamilleJDBC.getIdFamille(nommm);
                  		produitss=ProduitJDBC.getProduitsFromFam(id);
                  		request.setAttribute("produitss", produitss);}
                  	catch(Exception e) {}
            	   
            	   
            	    String nompro= request.getParameter("nompro");
            	   System.out.println("nom du pro"+nompro);
       			String photopro= request.getParameter("photoProduit");
       			String prixpro= request.getParameter("prixProduit");
       			System.out.println(prixpro);
       			
       			p.setNomProduit(nompro);
       			p.setPuProduit(Double.parseDouble(prixpro));
       			p.setPhoto(photopro);
       		//	HttpSession session= request.getSession();
       			
       		//	ArrayList<Produit> pro= new ArrayList<Produit>();
       			boolean productExists = false;
       			for (Produit product : pro) {
       			  if (product.getNomProduit().equals(p.getNomProduit())) {
       			    productExists = true;
       			    // increment the quantity of the existing product
       			    product.setQte(product.getQte() + 1);
       			 System.out.println("Quantity: "+product.getQte());
       			    break;
       			  }
       			}

       			if (!productExists) {
       			  // add the new product to the list with a quantity of 1
       			  p.setQte(1);
       			  pro.add(p);
       			}
       			
       			
       			
       			
       					
       //		pro.add(p);	
       			
       			
       			p=new Produit();
       			for (int i = 0; i < pro.size();i++) 
      	      { 		System.out.println("Arraylist")   ;   
      	          System.out.println(pro.get(i).getNomProduit()); 		
      	      }
       			if(j<2) 
       			session.setAttribute("prods", pro);
       			//request.setAttribute("pros", pro);
       			
       			
       			request.getRequestDispatcher("/ecom_templates/produits.jsp").forward(request, response);
       		// session	
       			//Produit prod=(Produit) session.getAttribute("prods");
       			ArrayList<Produit> proo= new ArrayList<Produit>();
       		System.out.println("session:   "+	session.getAttribute("prods"));
       		proo=(ArrayList<Produit>) session.getAttribute("prods");
       		for (int i = 0; i < proo.size();i++) 
    	      { 		//System.out.println("Arraylist")   ;   
    	      System.out.println("*************************");
    	      System.out.println(proo.get(i).getNomProduit()); 
    	      System.out.println(proo.get(i).getNumProduit());
    	      j=2;
    	      }
       		
       		
            	   }
               
               if (request.getServletPath().equals("/commande") ) {
            	   HttpSession session= request.getSession();
            	   ArrayList<Produit> prooo= new ArrayList<Produit>();
              		System.out.println("session:   "+	session.getAttribute("prods"));
              		prooo=(ArrayList<Produit>) session.getAttribute("prods");
              		request.getRequestDispatcher("/ecom_templates/commande.jsp").forward(request, response);
       		}
               if (request.getServletPath().equals("/commandeValide") ) {
            	   HttpSession session= request.getSession();
            	   ArrayList<Produit> prds= new ArrayList<Produit>();
             		//System.out.println("session:   "+	session.getAttribute("prods"));
             		prds=(ArrayList<Produit>) session.getAttribute("prods");
             		System.out.println("|||||||||||||||");
             		
             		for (int i = 0; i < prds.size();i++) 
          	      { 		//System.out.println("Arraylist")   ;   
          	      System.out.println("*************************");
          	      System.out.println(prds.get(i).getNomProduit()); 
          	      System.out.println(prds.get(i).getNumProduit());
          	      
          	      }
             		
             		for (Produit p : prds) {
             			System.out.println("session d commmmmmmmmm:  "+p.getNomProduit());
             		} 
             		int idCmd=0;
             		for (Produit p : prds) 
          	      { 
             		try {
             			idCmd=	CommandeJDBC.saveCommande();
    					System.out.println("idddddddddcmde:  "+idCmd);
						int idPrd=	ProduitJDBC.getIdProduit(p.getNomProduit());
						int qte=p.getQte();
						CommandeJDBC.saveProcde(idPrd,idCmd,qte);
						
						
					} catch (InstantiationException | IllegalAccessException e) {
						
						e.printStackTrace();
					}}
             		
             		int idd=(int) session.getAttribute("idd");
             		System.out.println("++++++++++++++++++++");
					System.out.println(session.getAttribute("nom"));
					System.out.println("++++++++++++++++++++");
             		
             //	int	idSes=c.getNumClient();
             		try {
						CommandeJDBC.saveCde(idCmd, idd);
					} catch (InstantiationException | IllegalAccessException e) {
						
						e.printStackTrace();
					}
             		
             		request.getRequestDispatcher("/ecom_templates/commandeValidee.jsp").forward(request, response);
             	
             		
               }
               if (request.getServletPath().equals("/deletElment") ) {
            	   System.out.println("post/deletElment");
            	   HttpSession session= request.getSession();
            	   ArrayList<Produit> pi= new ArrayList<Produit>();
             		//System.out.println("session:   "+	session.getAttribute("prods"));
             		pi=(ArrayList<Produit>) session.getAttribute("prods");
             		String pv= (String) session.getAttribute("pp");
             		System.out.println("hghxbvsxyvsgxvsxsxssxsxs"+pv);
             	//	System.out.println(ni);
             		     
             		for (int i = 0; i < pi.size();i++) 
             			
            	      { 		
             			if(pi.get(i).getNomProduit().equals(pv))
                 		   pi.remove(i);
            	      }
             	//String nomi=	(String) session.getAttribute("famille");
             	try {
              		int id=	FamilleJDBC.getIdFamille(nomm);
              		produitss=ProduitJDBC.getProduitsFromFam(id);
              		request.setAttribute("produitss", produitss);}
              	catch(Exception e) {}
             		request.getRequestDispatcher("/ecom_templates/produits.jsp").forward(request, response);
               }
             
               //vider Panier
               
               if (request.getServletPath().equals("/viderPanier") ) {
            	   HttpSession session= request.getSession();
            	   ArrayList<Produit> pii= new ArrayList<Produit>();
             		//System.out.println("session:   "+	session.getAttribute("prods"));
             		pii=(ArrayList<Produit>) session.getAttribute("prods");
             		pii.clear();
             		try {
                  		int id=	FamilleJDBC.getIdFamille(nomm);
                  		produitss=ProduitJDBC.getProduitsFromFam(id);
                  		request.setAttribute("produitss", produitss);}
                  	catch(Exception e) {}
                 		request.getRequestDispatcher("/ecom_templates/produits.jsp").forward(request, response);
                   
               }
               
               if (request.getServletPath().equals("/consulterCommandes") ) {
            	   try {
   					ArrayList<Integer>cmds=	CommandeJDBC.getnumcmd();
   					request.setAttribute("cmds", cmds);
   					ArrayList<Integer>numclis=	CommandeJDBC.getnumcli();
   					ArrayList<String>noms=	CommandeJDBC.getNomCli();
   					request.setAttribute("noms", noms);

   					ArrayList<Date>dates=	CommandeJDBC.getDate();
   					request.setAttribute("dates", dates);

   					ArrayList<String>adrss=	CommandeJDBC.getAdrCli();
   					request.setAttribute("adresses", adrss);

   					for (Integer cmd : cmds) {
   						System.out.println(cmd);
   					}
   					System.out.println("++++++++++++++++++++++");
   					for (Integer numcli : numclis) {
   						System.out.println(numcli);
   					}
   					System.out.println("++++++++++++++++++++++");
   					for (String nom : noms) {
   						System.out.println(nom);
   					}
   					System.out.println("++++++++++++++++++++++");
   					for (Date numcli : dates) {
   						System.out.println(numcli);
   					}
   					
   					
             	   request.getRequestDispatcher("/Admin/Consulter.jsp").forward(request, response);

   					
   				} catch (InstantiationException | IllegalAccessException e) {
   					
   					e.printStackTrace();
   				}
            		
            	//   request.getRequestDispatcher("/ecom_templates/produits.jsp").forward(request, response);

            	   
               }
               
               
               if (request.getServletPath().equals("/modifierProduit") ) {
            	
           String  Produit =request.getParameter("nomP");
           		System.out.println("---___----______"+Produit);
            //   String nom=request.getParameter("nomp");
  			/*	System.out.println(nom);
  				try {
					if(ProduitJDBC.verifierProduit(nom)) {
						//ProduitJDBC.modifyProduit(nom);
						System.out.println("modification avec success");
					}
					else {
						request.setAttribute("existePas", "Produit non existant");
						System.out.println("non existant");
					}
				} catch (InstantiationException | IllegalAccessException e) {
					
					e.printStackTrace();
				} */
  				
  				
  				try {	
				
				
					
					 
				 /*	if(Produit==null) {
				 	 this.getServletContext().getRequestDispatcher("/Admin/Modifier1.jsp").forward(request, response);
				 	   }*/

					Produit c=	ProduitJDBC.getProduit(Produit);
					request.setAttribute("produit", c);
					
					
					if (ProduitJDBC.verifierProduit(Produit) ) {
						 System.out.println("---___----______verified");
					this.getServletContext().getRequestDispatcher("/Admin/Modifier2.jsp").forward(request, response);
				 		String no=request.getParameter("nou");
				 		System.out.println("----------"+no);
				 		String prix=request.getParameter("nouv");
				 		 System.out.println("----------"+prix);
				 		double prixx=Double.parseDouble(prix);
				 		
				 		
				 		
				 		ProduitJDBC.modifyProduct(c, no, prixx);
				 		System.out.print("update reussie");
				 	
				 	}
						else {
							System.out.println("error");
							request.setAttribute("error"," non existant");
							this.getServletContext().getRequestDispatcher("/Admin/Modifier1.jsp").forward(request, response);

					}
					
				 	
				 	   
					
					 
			}catch(Exception e) {

				e.printStackTrace();
			}
               
  		        request.getRequestDispatcher("/Admin/Modifier1.jsp").forward(request, response);}
               
               
               
               if (request.getServletPath().equals("/logout") ) {
            	   System.out.println("/logout:");
            	   HttpSession session=request.getSession();
       			session.invalidate();
       			j=1;
       			response.sendRedirect("Home");
               }
            	
            	   
            	   
            	   }
               
     
               
                 
               
               
}




