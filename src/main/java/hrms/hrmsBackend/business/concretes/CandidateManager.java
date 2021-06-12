package hrms.hrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsBackend.business.abstracts.CandidateService;
import hrms.hrmsBackend.core.services.EmailVerification;
import hrms.hrmsBackend.core.services.MernisVerification;
import hrms.hrmsBackend.core.utilities.results.DataResult;
import hrms.hrmsBackend.core.utilities.results.ErrorResult;
import hrms.hrmsBackend.core.utilities.results.Result;
import hrms.hrmsBackend.core.utilities.results.SuccessDataResult;
import hrms.hrmsBackend.core.utilities.results.SuccessResult;
import hrms.hrmsBackend.dataAccess.abstracts.CandidateDao;
import hrms.hrmsBackend.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private  CandidateDao candidateDao;
	private MernisVerification mernisVerification;
	private EmailVerification emailVerification;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,MernisVerification mernisVerification,EmailVerification emailVerification) {
		super();
		this.candidateDao = candidateDao;
		this.mernisVerification = mernisVerification;
		this.emailVerification = emailVerification;
	}
	
	@Override
	public DataResult<List<Candidate>> getall() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Adaylar listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		
		if(candidate.getName() == null || candidate.getSurname() == null || candidate.getBirthYear() == null 
				|| candidate.getNationalIdentity() == null || candidate.getEmail() == null || candidate.getPassword() == null 
				|| candidate.getPasswordAgain() == null )  {
			return new ErrorResult("Boş alan bırakmayınız");
			
		}else if(!mernisVerification.mernisControl(candidate)) {
			return new ErrorResult("Mernis Doğrulaması yapılamadı");
			
		}else if(!checkEmail(candidate.getEmail())) {
			return new ErrorResult("Email kullanılmaktadır");
		}else if(!checkNationalId(candidate.getNationalIdentity())) {
			return new ErrorResult("TC Kimlik Numarası kullanılmaktadır");
		}else {
			emailVerification.emailcontrol(candidate.getEmail());
			this.candidateDao.save(candidate);
			return new SuccessResult("Aday eklendi");
		}
	}
	
	private  boolean checkEmail(String email) {
		if (this.candidateDao.findByEmail(email) == null) {
			return true;
		}
		return false;
		
	}
	
	private boolean checkNationalId(String nationalId) {
		if(this.candidateDao.findByNationalIdentity(nationalId) == null) {
			return true;
		}
		return false;
	}
}
