package fr.philae.beans;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import fr.philae.busmapper.domain.User;
import fr.philae.busmapper.services.gestion.user.UserServicesLocal;



@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
	private static final long serialVersionUID = 71207265440168749L;
	@EJB 
	private UserServicesLocal userServicesLocal;
private String login;
private String password;

User user1;
User user2=new User();

public String doLogin(){

	user1=new User();
	
	user1.setAdress("mesdazdaztir");
	user1.setUserName("ka");
	user1.setPassword("kdaz");
	
userServicesLocal.addUser(user1);
	
	if( userServicesLocal.authentificate(login, password)!=null ){
		user2=userServicesLocal.authentificate(login, password);
		System.out.println("OK loto");
		return "Home?faces-redirect=true";
	}
	else
		System.out.println("Erreur ...add");
	return "about?faces-redirect=true";
	
}
	
//	if (login.equals("b")&&(pwd.equals("b")))
//	{
//		
//		System.out.println("adress user et : "+user2.getAdress());
//		return "espace?faces-redirect=true";
//	}
//	else return "error?faces-redirect=true" ;
//	
	

public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}
public UserServicesLocal getUserServicesLocal() {
	return userServicesLocal;
}
public void setUserServicesLocal(UserServicesLocal userServicesLocal) {
	this.userServicesLocal = userServicesLocal;
}


}
