package p1;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "updateManagerById", query = "update Team set manager=? where teamId=?")
public class Team {

	@Id
	private String teamId;
	private String teamName;
	private String manager;
	@Embedded
	private Address officeAddress;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="players")
	private List<Player> players;
	public Team() {
		super();
	}

	public Team(String teamId, String teamName, String manager, Address officeAddress, List<Player> players) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.manager = manager;
		this.officeAddress = officeAddress;
		this.players = players;
	}

	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", manager=" + manager + ", officeAddress="
				+ officeAddress + ", players=" + players + "]";
	}

	
	
}
