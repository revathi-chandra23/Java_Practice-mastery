package com.revathiPractice.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revathiPractice.Security.JwtTokenProvider;
import com.revathiPractice.model.User;

import cm.practice.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenProvider jwtTokenProvider;

	public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder,
			JwtTokenProvider jwtTokenProvider) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	// Register endpoint
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password
		userRepository.save(user);
		return "User registered successfully!";
	}

	// Login endpoint to get JWT token
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		User foundUser = userRepository.findByUsername(user.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));

		if (passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
			return jwtTokenProvider.generateToken(user.getUsername());
		} else {
			throw new RuntimeException("Invalid credentials");
		}
	}
}
