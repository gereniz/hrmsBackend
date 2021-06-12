package hrms.hrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsBackend.business.abstracts.EmployerService;
import hrms.hrmsBackend.core.services.EmailVerification;
import hrms.hrmsBackend.core.utilities.results.DataResult;
import hrms.hrmsBackend.core.utilities.results.ErrorResult;
import hrms.hrmsBackend.core.utilities.results.Result;
import hrms.hrmsBackend.core.utilities.results.SuccessDataResult;
import hrms.hrmsBackend.core.utilities.results.SuccessResult;
import hrms.hrmsBackend.dataAccess.abstracts.EmployerDao;
import hrms.hrmsBackend.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmailVerification emailVerification;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmailVerification emailVerification) {
		super();
		this.employerDao = employerDao;
		this.emailVerification = emailVerification;
	}

	@Override
	public DataResult<List<Employer>> getall() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi");
	}

	@Override
	public Result add(Employer employer) {
		if(employer.getWebAddress() == null || employer.getCompanyName() == null || employer.getTelephoneNumber() == null
				|| employer.getEmail() == null || employer.getPassword() == null || employer.getPasswordAgain() == null) {
			return new ErrorResult("Boş alan bırakmayınız");
		}else if(!checkEmail(employer.getEmail())) {
			return new ErrorResult("Email kullanılmaktadır.");
		}
		emailVerification.emailcontrol(employer.getEmail());
		this.employerDao.save(employer);
		return new SuccessResult("İş veren eklendi");
		
	}
	
	private  boolean checkEmail(String email) {
		if (this.employerDao.findByEmail(email) == null) {
			return true;
		}
		return false;
		
	}
	

}
