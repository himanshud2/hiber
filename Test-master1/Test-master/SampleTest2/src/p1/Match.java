package p1;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Column; 

@Entity
public class Match {

	@Id
	private String matchId;
	private String location;
	
	@OneToOne(cascade = CascadeType.ALL)
	/*@AttributeOverrides({
		@AttributeOverride(name="teamId",column=@Column(name="id")),
		@AttributeOverride(name="teamName",column=@Column(name="name")),
		@AttributeOverride(name="officeAddress",column=@Column(name="address")),
	})*/
	@JoinColumn(name="Team1")
	private Team team1;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Team2")
	private Team team2;
	
	public Match() {
		super();
	}
	public Match(String matchId, String location, Team team1, Team team2) {
		super();
		this.matchId = matchId;
		this.location = location;
		this.team1 = team1;
		this.team2 = team2;
	}
	public String getMatchId() {
		return matchId;
	}
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Team getTeam1() {
		return team1;
	}
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}
	public Team getTeam2() {
		return team2;
	}
	public void setTeam2(Team team2) {
		this.team2 = team2;
	}
	@Override
	public String toString() {
		return "Match [matchId=" + matchId + ", location=" + location + ", team1=" + team1 + ", team2=" + team2 + "]";
	}
	
}
