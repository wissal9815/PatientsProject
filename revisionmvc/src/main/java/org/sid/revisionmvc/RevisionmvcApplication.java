package org.sid.revisionmvc;

import java.util.Date;

import org.sid.revisionmvc.dao.PatientRepository;
import org.sid.revisionmvc.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RevisionmvcApplication implements CommandLineRunner{

	@Autowired
	private PatientRepository patientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(RevisionmvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"HASSAN", new Date(),false,8));
		patientRepository.save(new Patient(null,"MOHAMED", new Date(),false,10));
		patientRepository.save(new Patient(null,"SAMIRA", new Date(),false,5));
		
		patientRepository.findAll().forEach(p->{
			System.out.println(p.getName());
		});
		
	}

}
