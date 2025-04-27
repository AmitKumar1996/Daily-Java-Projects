package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class iplTeam {
	
	 @Column
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    
	 @Column
	    private String name;
	    
	 @Column
	    private String captainName; 
	    
	 @Column
	    private int trophies;

		public iplTeam(Long id, String name, String captainName, int trophies) {
			super();
			this.id = id;
			this.name = name;
			this.captainName = captainName;
			this.trophies = trophies;
		}

		public iplTeam() {
			super();
			// TODO Auto-generated constructor stub
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
	    
	    


}
