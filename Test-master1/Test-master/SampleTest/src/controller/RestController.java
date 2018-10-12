package controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import p1.ManageUserImpl;
import p1.User;

@Path("user")
public class RestController {

	ManageUserImpl manageUserImpl=new ManageUserImpl();
	
	@Path("add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addUser(User user){
		return manageUserImpl.addUser(user);
	}
	
	@Path("getUsers")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<User> getUsers(){
		return manageUserImpl.getUsers();
	}
	
	@Path("getUserById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public User getUserById(@PathParam("id")String id){
		return manageUserImpl.getUserById(id);
	}
	
	@Path("updateUser")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUser(User user){
		return manageUserImpl.updateUser(user);
	}
	
	@Path("getUserByAge/{minAge}/{maxAge}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<User> getUserByAge(@PathParam("minAge")int minAge,@PathParam("maxAge")int maxAge){
		return manageUserImpl.getUserByAge(minAge, maxAge);
	}
	
	@Path("deleteUserById/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@DELETE
	public String deleteUser(@PathParam("id")String id){
		return manageUserImpl.deleteUser(id);
	}
	
}
