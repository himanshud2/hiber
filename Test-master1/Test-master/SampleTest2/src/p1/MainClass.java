package p1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import utility.SessionProvider;

public class MainClass {

	public static void main(String[] args) {
		MainClass mainClass=new MainClass();
		//mainClass.insert();
//		mainClass.display();
//		System.out.println("====================");
//		mainClass.updateManager();
//		System.out.println("====================");
//		mainClass.display();
//		System.out.println("====================");
//		mainClass.updatePlayerAddress();
//		System.out.println("====================");
//		mainClass.display();
//		System.out.println("====================");
//		mainClass.changeTeam();
//		System.out.println("====================");
//		mainClass.display();
		
		//mainClass.displayTeamAddress();
		
		//mainClass.displayAddressOfPlayer();
		
		mainClass.getPlayerByMatchByTeam();
	}
	
	public void insert(){
		Session session=SessionProvider.getSession();
		List<Player>players1 =new ArrayList<>();
		players1.add(new Player("P101", "Kohli", new Address("New Delhi", "India")));
		players1.add(new Player("P102", "Sachin", new Address("Mumbai", "India")));
		
		List<Player>players2 =new ArrayList<>();
		players2.add(new Player("P103", "Kohli", new Address("New Delhi", "India")));
		players2.add(new Player("P104", "Sachin", new Address("Mumbai", "India")));
		Transaction transaction=session.beginTransaction();
		Match match=new Match("M101", "Green Park", new Team("T101", "India", "Manager1", new Address("Kanpur", "India"), players1), new Team("T102", "West Indies", "Manager2", new Address("XYZ", "West Indies"), players2));
		session.save(match);
		transaction.commit();
	}
	
	public void display(){
		Session session=SessionProvider.getSession();
		List<Match> matches=session.createQuery("from Match").list();
		for (Match match : matches) {
			System.out.println(match.getMatchId());
			System.out.println(match.getLocation());
			System.out.println("Team-1");
			System.out.println("-----------");
			System.out.println(match.getTeam1().getTeamId());
			System.out.println(match.getTeam1().getTeamName());
			System.out.println(match.getTeam1().getManager());
			System.out.println(match.getTeam1().getOfficeAddress());
			System.out.println(match.getTeam1().getPlayers());
			System.out.println("Team-2");
			System.out.println("-----------");
			System.out.println(match.getTeam2().getTeamId());
			System.out.println(match.getTeam2().getTeamName());
			System.out.println(match.getTeam2().getManager());
			System.out.println(match.getTeam2().getOfficeAddress());
			System.out.println(match.getTeam2().getPlayers());
		}
		System.out.println("-----------------------------");
		System.out.println(matches);
	}
	
	public void updateManager(){
		Session session=SessionProvider.getSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.getNamedQuery("updateManagerById");
		query.setString(0, "Mike");
		query.setString(1, "T101");
		int result=query.executeUpdate();
		if(result>0)
			System.out.println("--------->Manager Updated");
		else
			System.out.println("--------->Manager Not Updated");
		transaction.commit();
	}
	
	public void updatePlayerAddress(){
		Session session=SessionProvider.getSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from Player where playerid=?");
		query.setString(0, "P101");
		List<Player> players=query.list();
		for (Player player : players) {
			player.setAddress(new Address("New York", "US"));
			session.update(player);
		}
		transaction.commit();
	}
	
	public void changeTeam(){
		Session session=SessionProvider.getSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from Match where matchId=?");
		query.setString(0, "M101");
		List<Match> matches=query.list();
		for (Match match : matches) {
			List<Player> players=new ArrayList<>();
			players.add(new Player("P105", "Andrew", new Address("Sydney", "Australia")));
			match.setTeam1(new Team("T103", "Australia", "Manager3", new Address("Canberra", "Australia"), players));
			session.update(match);
		}
		transaction.commit();
	}
	
	public void displayTeamAddress(){
		Session session=SessionProvider.getSession();
		Query query=session.createQuery("from Team where teamId=?");
		query.setString(0, "T101");
		List<Team> teams=query.list();
		for (Team team : teams) {
			System.out.println(team.getOfficeAddress());
		}
	}
	
	public void displayAddressOfPlayer(){
		Session session=SessionProvider.getSession();
		Criteria criteria=session.createCriteria(Player.class);
		criteria.add(Restrictions.eq("playerId", "P101"));
		List<Player> players=criteria.list();
		for (Player player : players) {
			System.out.println(player.getAddress());
		}
	}
	
	public void getPlayerByMatchByTeam(){
		Session session=SessionProvider.getSession();
		Criteria criteria=session.createCriteria(Match.class);
		criteria.add(Restrictions.eq("matchId", "M101"));
		List<Match> matches=criteria.list();
		if(matches.get(0).getTeam1().getTeamId().equals("T102")){
			/*Criteria criteria1=session.createCriteria(Team.class);
			criteria.add(Restrictions.eq("teamId", matches.get(0).getTeam1().getTeamId()));
			List<Player>players=criteria1.list();
			for (Player player : players) {
				System.out.println(player);
			}*/
			System.out.println(matches.get(0).getTeam1().getPlayers());
		}
		else if(matches.get(0).getTeam2().getTeamId().equals("T102")){
			/*Criteria criteria2=session.createCriteria(Team.class);
			criteria.add(Restrictions.eq("teamId", matches.get(0).getTeam2().getTeamId()));
			List<Player>players1=criteria2.list();
			for (Player player : players1) {
				System.out.println(player);
			}*/
			System.out.println(matches.get(0).getTeam2().getPlayers());
		}
	}
	
}
