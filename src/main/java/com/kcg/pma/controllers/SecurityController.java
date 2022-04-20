package com.kcg.pma.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kcg.pma.dao.IUserAccountRepository;
import com.kcg.pma.entities.UserAccount;

import net.bytebuddy.asm.Advice.This;

@Controller
public class SecurityController {
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	IUserAccountRepository iUserAccountRepository;
	
	@GetMapping("/register")
	public String register(Model model) {
		UserAccount userAccount = new UserAccount();
		model.addAttribute("userAccount", userAccount);
		List<String> roleList = Arrays.asList("ADMIN", "USER");
		model.addAttribute("allRoles", roleList);
		return "security/register";
	}
	
	@PostMapping("/register/save")
	public String saveUser(Model model, UserAccount userAccount) {
		userAccount.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
		iUserAccountRepository.save(userAccount);
		return "redirect:/";
	}
			
}
