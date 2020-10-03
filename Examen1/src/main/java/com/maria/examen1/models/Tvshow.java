package com.maria.examen1.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tvshows")
public class Tvshow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Title  must be present")
	private String title;
	@NotBlank(message = "network  must be present")
	private String network;
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
    
    
	public Tvshow() {
		
	}

	
	  public Tvshow(@NotBlank(message = "Title  must be present") String title,
			@NotBlank(message = "network  must be present") String network, User creator, List<Raiting> raiting) {
		super();
		this.title = title;
		this.network = network;
		this.creator = creator;
		this.raiting = raiting;
	}


	//events
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
	private User creator; // MUCHOS EVENTOS PERTENECEN SOLO A UN USUARIO
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "qualify", 
        joinColumns = @JoinColumn(name = "tvshow_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
        )
    private List<User> qualifyingUser; // MUCHOS EVENTOS PUEDEN TENER MUCHOS ASISTENTES
    
//messages
	@OneToMany(mappedBy="tvshow", fetch = FetchType.LAZY)
	private List<Raiting> raiting;


	public User getCreator() {
		return creator;
	}


	public void setCreator(User creator) {
		this.creator = creator;
	}


	public List<User> getQualifyingUser() {
		return qualifyingUser;
	}


	public void setQualifyingUser(List<User> qualifyingUser) {
		this.qualifyingUser = qualifyingUser;
	}


	public List<Raiting> getRaiting() {
		return raiting;
	}


	public void setRaiting(List<Raiting> raiting) {
		this.raiting = raiting;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getNetwork() {
		return network;
	}


	public void setNetwork(String network) {
		this.network = network;
	}
    
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}
    
}
