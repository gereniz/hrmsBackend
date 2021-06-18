package hrms.hrmsBackend.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrmsBackend.core.utilities.results.DataResult;
import hrms.hrmsBackend.core.utilities.results.Result;
import hrms.hrmsBackend.entities.concretes.JobAdvertisement;
import hrms.hrmsBackend.entities.dtos.JobAdvertisementDto;

@Service
public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getall();
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisementDto>> getByIsActive(boolean isActive);
	DataResult<List<JobAdvertisementDto>> getAllIsActiveSorted(boolean isActive);
	DataResult<List<JobAdvertisementDto>> getByIsActiveOfEmployer(int id);
	Result changeIsActiveByEmployer(int id);
	
}
