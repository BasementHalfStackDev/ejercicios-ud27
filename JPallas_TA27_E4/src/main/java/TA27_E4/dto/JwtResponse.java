/**
 * @author BasementHalfStackDev/Josep Maria Pallas Batalla
 */
package TA27_E4.dto;

import java.util.List;

// JWT response
public class JwtResponse {

	// Arguments
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private List<String> roles;

	// Constructors
	public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	// Getters
	public String getAccessToken() {
		return token;
	}

	public String getTokenType() {
		return type;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public List<String> getRoles() {
		return roles;
	}

	// Setters
	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
