package hrms.hrmsBackend.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsBackend.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate findByEmail(String email);
	Candidate findByNationalIdentity(String nationalIdentity);

}
