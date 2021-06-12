package hrms.hrmsBackend.core.services;



import org.springframework.stereotype.Service;

import hrms.hrmsBackend.entities.concretes.Candidate;

@Service
public class MernisVerification {

	public boolean mernisControl(Candidate candidate) {
		if(candidate.getName() != null && candidate.getSurname() != null && candidate.getNationalIdentity().length() ==11 &&candidate.getBirthYear() != null) {
			return true;
		}
		else {
			return false;
		}
	}
}
