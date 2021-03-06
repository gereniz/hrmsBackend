package hrms.hrmsBackend.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrmsBackend.core.utilities.results.DataResult;
import hrms.hrmsBackend.core.utilities.results.Result;
import hrms.hrmsBackend.entities.concretes.Employer;
import hrms.hrmsBackend.entities.concretes.JobAdvertisement;

@Service
public interface EmployerService {

	DataResult<List<Employer>> getall();
	Result add(Employer employer);
	Result update(Employer employer);
}
