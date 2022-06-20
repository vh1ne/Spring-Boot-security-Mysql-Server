package com.vh1ne.dto;

import lombok.Value;

@Value
public class JwtAuthenticationResponse {
	private String accessToken;
	private UserInfo user;
}