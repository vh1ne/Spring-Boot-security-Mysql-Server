package com.vh1ne.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vh1ne.config.CurrentUser;
import com.vh1ne.dto.LocalUser;
import com.vh1ne.util.GeneralUtils;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class UserController {

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getCurrentUser(@CurrentUser LocalUser user) {
		return ResponseEntity.ok(GeneralUtils.buildUserInfo(user));
	}

	@GetMapping("/all")
	public ResponseEntity<?> getContent() {
		return ResponseEntity.ok("Public content goes here");
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
		var eList = new ArrayList<Employee>();
		eList.add(new Employee("Jack", "HR", 30000));
		eList.add(new Employee("Aria", "HR", 40000));
		eList.add(new Employee("Nora", "IT", 50000));
		eList.add(new Employee("Bella", "IT", 60000));
		eList.add(new Employee("Jacob", "IT", 70000));
		eList.add(new Employee("James", "HR", 80000));
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