package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "IPLTeams")
public class IplTeam {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    private String captainName; // ✅ Better use camelCase here
    
    private int trophies;

    public IplTeam() {
        super();
    }

    public IplTeam(Long id, String name, String captainName, int trophies) {
        super();
        this.id = id;
        this.name = name;
        this.captainName = captainName;
        this.trophies = trophies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }

    @Override
    public String toString() {
        return "IplTeam [id=" + id + ", name=" + name + ", captainName=" + captainName + ", trophies=" + trophies + "]";
    }
}
