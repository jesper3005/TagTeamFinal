
package textadventuregame;


public class Player {
    
    private String playersName;
    private int playersHealth = 100;
    private Room location;

    public Room getLocation() {
        return location;
    }

    public void setLocation(Room location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Player{" + "playersName=" + playersName + ", playersHealth=" + playersHealth + '}';
    }

    public Player(String playersName,Room location) {
        this.playersName = playersName;
        this.location = location;
    }

    public String getPlayersName() {
        return playersName;
    }

    public void setPlayersName(String playersName) {
        this.playersName = playersName;
    }

    public int getPlayersHealth() {
        return playersHealth;
    }

    public void setPlayersHealth(int playersHealth) {
        this.playersHealth = playersHealth;
    }
    
}
