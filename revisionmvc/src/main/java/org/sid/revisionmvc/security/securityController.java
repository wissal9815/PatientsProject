package org.sid.revisionmvc.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class securityController {
	
	@GetMapping("/notAutorized")
	public String error() {
		return "notAutorized";
	}

}
