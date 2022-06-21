package com.vh1ne.controller;

import com.vh1ne.strategies.nse.dto.BhavCopy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vh1ne.config.CurrentUser;
import com.vh1ne.dto.LocalUser;
import com.vh1ne.util.GeneralUtils;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}
	@Autowired
	private WebClient.Builder webClientBuilder;
	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getCurrentUser(@CurrentUser LocalUser user) {

		return ResponseEntity.ok(GeneralUtils.buildUserInfo(user));
	}

	@GetMapping("/all")
	public ResponseEntity<?> getContent() {
		log.info("Home callled");

		return ResponseEntity.ok("This is public content!!!!!!!!!!!!!!!!!!!");
	}
private List<BhavCopy> getBhavcopy()
{
	var obj=webClientBuilder.build()
			.get()
			.uri("http://localhost:8085/test/getByDate")
			.retrieve()
			.bodyToMono(new ParameterizedTypeReference<List<BhavCopy>>() {})
			.block();

	log.info(obj.toString());
	return obj;
}
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getUserContent() {
		var list =Arrays.asList("Venkatesh","Returning cached instance of singleton bean 'basicErrorController'"
				,"Opening JPA EntityManager in OpenEntityManagerInViewInterceptor",
				"Invoking TokenAuthenticationFilter (8/14)");
		return ResponseEntity.ok(list);
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAdminContent() {

		return ResponseEntity.ok("Admin content goes here");
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public ResponseEntity<?> getModeratorContent() {
		var eList = getBhavcopy();
		return ResponseEntity.ok(eList);
	}
}
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Employee {
	private String name;
	private String department;
	private double salary;
}