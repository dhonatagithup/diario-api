package com.borges.diario_eletronico.domain;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String login;
	private String senha;
	private String nome;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuarios_role", uniqueConstraints = @UniqueConstraint(
			columnNames = {"usuario_id", "role_id"}, name = "unique_role_user"),
			joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario", unique = false,
			foreignKey = @ForeignKey(name="usuario_fk", value = ConstraintMode.CONSTRAINT)),
			
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", table = "role", unique = false,
			foreignKey = @ForeignKey (name = "role_fk", value = ConstraintMode.CONSTRAINT)))
	private List<Role>roles;/*Os papeis ou acesso do usuario*/
	
	public Usuario() {
		super();
	}

	public Usuario(Integer id, String login, String senha, String nome, List<Role> roles) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.roles = roles;
	}


	public Usuario(Usuario obj) {
		super();
		this.id = obj.getId();
		this.login = obj.getLogin();
		this.senha = obj.getSenha();
		this.roles = obj.getRoles();
		this.nome = obj.getNome();
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setPassword(String senha) {
		this.senha = senha;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setPapeis(List<Role> roles) {
		this.roles = roles;
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	/*São acesso do usuario ROLE_ADMIN OU ROLE_VISITATE*/
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}


	@Override
	public String getUsername() {
		return this.login;
	}
	
	@Override
	public String getPassword() {
		return this.senha;
	}
		
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
		
}
