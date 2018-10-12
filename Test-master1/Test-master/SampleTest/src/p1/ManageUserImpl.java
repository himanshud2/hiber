package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utility.ConnectorJDBC;

public class ManageUserImpl implements ManageUser{

	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		String message=null;
		Connection connection=ConnectorJDBC.getConnecion();
		try{
			String query="insert into user_tab values(?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, user.getId());
			preparedStatement.setInt(3, user.getAge());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(4, user.getAddress());
			int result=preparedStatement.executeUpdate();
			if(result>0)
				message="Record Added";
			else
				message="Record Not Added";
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return message;
		
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List<User> users=new ArrayList<User>();
		Connection connection=ConnectorJDBC.getConnecion();
		try{
			String query="Select * from User_tab";
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(query);
			while(resultSet.next()){
				users.add(new User(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4)));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		User user=new User();
		Connection connection=ConnectorJDBC.getConnecion();
		try{
			String query="Select * from User_tab where user_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				user=new User(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		String message=null;
		Connection connection=ConnectorJDBC.getConnecion();
		try{
			String query="Update user_tab set name=?,age=?,address=? where user_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(4, user.getId());
			preparedStatement.setInt(2, user.getAge());
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(3, user.getAddress());
			int result=preparedStatement.executeUpdate();
			if(result>0)
				message="Record Updated";
			else
				message="Record Not Updated";
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public List<User> getUserByAge(int minAge, int maxAge) {
		// TODO Auto-generated method stub
		List<User> users=new ArrayList<User>();
		Connection connection=ConnectorJDBC.getConnecion();
		try{
			String query="Select * from User_tab where age between ? and ?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, minAge);
			preparedStatement.setInt(2, maxAge);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				users.add(new User(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4)));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public String deleteUser(String id) {
		// TODO Auto-generated method stub
		String message=null;
		Connection connection=ConnectorJDBC.getConnecion();
		try{
			String query="delete from user_tab where user_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			int result=preparedStatement.executeUpdate();
			if(result>0)
				message="Record Deleted";
			else
				message="Record Not Deleted";
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return message;
	}

}
