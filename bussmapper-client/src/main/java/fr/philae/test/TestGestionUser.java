package fr.philae.test;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fr.philae.busmapper.domain.User;
import fr.philae.busmapper.services.gestion.user.UserServicesRemote;










public class TestGestionUser {
	static UserServicesRemote remote;
	public static void doAddUser(UserServicesRemote remote){

		User user=new User();
		user.setUserName("bilel");
		user.setAdress("achddref");
		user.setEmail("achrddef");
		user.setFullName("achref");
		user.setPassword("bilel");
		
//		User user1 = new Client();
//		user1.setUserName("houda");
//		user1.setAdress("sousse");
//		user1.setEmail("houda.baya@esprit.tn");
//		user1.setFullName("houda");
//		user1.setPassword("houda");
//		user1.setImageUrl("houda.jpg");
//
//		User user2 = new Client();
//		user2.setUserName("baya");
//		user2.setAdress("msaken");
//		user2.setEmail("baya.baya@esprit.tn");
//		user2.setFullName("baya");
//		user2.setPassword("baya");
//		user2.setImageUrl("1.jpg");
//
//		User user3 = new Client();
//		user3.setUserName("smida");
//		user3.setAdress("gafsa");
//		user3.setEmail("khaled.smida@esprit.tn");
//		user3.setFullName("smida");
//		user3.setPassword("smida");
//		user3.setImageUrl("khaled.jpg");

		
//		if(remote.addUser(user) && remote.addUser(user1) && remote.addUser(user2) && remote.addUser(user3) ){
//			System.out.println("OK");
			if(remote.addUser(user)  ){
				System.out.println("OK");
		}
		else
			System.out.println("Erreur ...add");
		
	}
	public static void doUpdateUser(UserServicesRemote remote){

		User user=remote.findUserById(1);
		user.setUserName("bb");
		user.setFullName("bb");
		user.setParticipation("inactif");
		if(remote.updateUser(user)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...");

	}
	public static void doDeleteUser(UserServicesRemote remote){

		User user=remote.findUserById(1);
		if (user ==null)
System.out.println("user null");
		if(remote.deleteUser(user)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...delete");

	}
	
	public static void doAuthentifUser(UserServicesRemote remote){

User user= remote.authentificate("bilel", "bilel");
		
		
			
		
	if(user!=null)
	{
		System.out.println("OK authentification");
		
	}
	else
		System.out.println("ouupssss erreur authentification");

	}
	
	
	public static void doFindAllUser(UserServicesRemote remote){
		List<User> users=remote.findAllUsers();
		//Configuration configuration=new Configuration();

		if(users!=null){
			System.out.println("OK find");
		}
		else
			System.out.println("Erreur ...find Config");

	}
	public static void dofindParticipateOrNot(UserServicesRemote remote){
		Integer numberoffalse= remote.findParticipateOrNot("actif");
		
		if (numberoffalse==null)
			System.out.println("liste e a vide");
		else
			System.out.println(numberoffalse);
	}
	
	public static void main(String[] args) {
		
		
		try {
			Context context=new InitialContext();
			remote=(UserServicesRemote) context.lookup("busmapper-ejb/UserServices!fr.philae.busmapper.services.gestion.user.UserServicesRemote");
				} catch (NamingException e) {
		System.out.println("erreur jndi ... ");
			e.printStackTrace();
		}
	doAddUser(remote);	
	//dofindParticipateOrNot(remote);
//doFindAllUser(remote);
	//doUpdateUser(remote);
	//doDeleteUser(remote);
	//doAuthentifUser(remote);
	}
}
