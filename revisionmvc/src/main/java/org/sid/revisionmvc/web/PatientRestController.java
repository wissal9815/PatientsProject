package org.sid.revisionmvc.web;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.sid.revisionmvc.dao.PatientRepository;
import org.sid.revisionmvc.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.implementation.bind.MethodDelegationBinder.BindingResolver;

@RestController
public class PatientRestController {
	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping(path = "/listPatient")
	@ResponseBody
	public List<Patient> list(){
		return patientRepository.findAll();	
	}
	
	@GetMapping(path = "/patient/{id}")
	
	public Patient getOne(@PathVariable Long id){
		return patientRepository.findById(id).get();	
	}
}
