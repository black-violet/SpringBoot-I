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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Name must be present") 
	private String name;
	@Email
	@NotBlank(message = "Email must be present and valid format")
	private String email;
	@NotBlank
	@Size(min=8, message="Password must be at least 8 characters long")
	private String password;
	@Transient
	@NotBlank(message = "Password and password confirmation must be match")
	private String passwordConfirmation;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	
	public User() {
		
	}
	
	
	public User(@NotBlank(message = "Name must be present") String name,
			@Email @NotBlank(message = "Email must be present and valid format") String email,
			@NotBlank @Size(min = 8, message = "Password must be at least 8 characters long") String password,
			@NotBlank(message = "Password and password confirmation must be match") String passwordConfirmation,
			List<Tvshow> shows, List<Raiting> raiting) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.shows = shows;
		this.raiting = raiting;
	}


	//events
		@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
		private List<Tvshow> shows; // UN USUARIO PUEDE CREAR MUCHOS EVENTOS

		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(name = "qualify", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tvshow_id"))
		private List<Tvshow> qualifiedtvshow; // UN USUARIO PUEDE ASISTIR A MUCHOS EVENTOS

	
	public List<Tvshow> getShows() {
			return shows;
		}

		public void setShows(List<Tvshow> shows) {
			this.shows = shows;
		}

		public List<Tvshow> getQualifiedtvshow() {
			return qualifiedtvshow;
		}

		public void setQualifiedtvshow(List<Tvshow> qualifiedtvshow) {
			this.qualifiedtvshow = qualifiedtvshow;
		}

	//raiting
	@OneToMany(mappedBy ="user", fetch =FetchType.LAZY)
	private List<Raiting> raiting;
	
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

	public List<Raiting> getRaiting() {
		return raiting;
	}

	public void setRaiting(List<Raiting> raiting) {
		this.raiting = raiting;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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
