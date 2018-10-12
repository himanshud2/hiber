package p1;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Player {

	@Id
	private String playerId;
	private String playerName;
	@Embedded
	private Address address;
	@ManyToOne
	@JoinColumn(name="players")
	private Team team;
	public Player() {
		super();
	}
	public Player(String playerId, String playerName, Address address) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.address = address;
	}
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", address=" + address + "]";
	}
	
}
