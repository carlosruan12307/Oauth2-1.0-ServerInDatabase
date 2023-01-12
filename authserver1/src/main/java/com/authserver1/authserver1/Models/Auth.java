package com.authserver1.authserver1.Models;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "oauth2_authorization")
@Getter
@Setter
public class Auth {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(length = 100)
	private String id;

    @Column(length = 100)
	private String registeredClientId;
    @Column(length = 200)
	private String principalName;
    @Column(length = 100)
	private String authorizationGrantType;
	@Column(length = 1000)
	private String authorizedScopes;
	@Lob
    @Column(length = 4000)
	private String attributes;
	@Column(length = 500)
	private String state;

	@Lob
    @Column(length = 4000)
	private String authorizationCodeValue;
	private Instant authorizationCodeIssuedAt;
	private Instant authorizationCodeExpiresAt;
    @Lob
	private String authorizationCodeMetadata;

	@Lob
    @Column(length = 4000)
	private String accessTokenValue;
	private Instant accessTokenIssuedAt;
	private Instant accessTokenExpiresAt;
	@Lob
    @Column(length = 4000)
	private String accessTokenMetadata;
    @Column(length = 100)
	private String accessTokenType;
	@Column(length = 1000)
	private String accessTokenScopes;

	@Lob
    @Column(length = 4000)
	private String refreshTokenValue;
	private Instant refreshTokenIssuedAt;
	private Instant refreshTokenExpiresAt;
	@Lob
    @Column(length = 4000)
	private String refreshTokenMetadata;

	@Lob
    @Column(length = 4000)
	private String oidcIdTokenValue;
	private Instant oidcIdTokenIssuedAt;
	private Instant oidcIdTokenExpiresAt;
	@Lob
    @Column(length = 4000)
	private String oidcIdTokenMetadata;
	@Column(length = 2000)
	private String oidcIdTokenClaims;
}
