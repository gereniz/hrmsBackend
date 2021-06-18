package hrms.hrmsBackend.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsBackend.business.abstracts.JobAdvertisementService;
import hrms.hrmsBackend.core.utilities.results.DataResult;
import hrms.hrmsBackend.core.utilities.results.Result;
import hrms.hrmsBackend.core.utilities.results.SuccessDataResult;
import hrms.hrmsBackend.core.utilities.results.SuccessResult;
import hrms.hrmsBackend.dataAccess.abstracts.JobAdvertisementDao;
import hrms.hrmsBackend.entities.concretes.JobAdvertisement;
import hrms.hrmsBackend.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getall() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"İş ilanları listelendi");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getByIsActive(isActive),"Aktif iş ilanları getirildi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllIsActiveSorted(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getByIsActiveByOrderByReleaseDate());
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByIsActiveOfEmployer(int id) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getByIsActiveOfEmployer(id));
	}
	
	@Override
	public Result changeIsActiveByEmployer(int id) {
		boolean passive = false;
		JobAdvertisement employerValue = this.jobAdvertisementDao.getOne(id);
		employerValue.setActive(passive);
		this.jobAdvertisementDao.save(employerValue);
		return new SuccessResult("Pasifleştirildi");
	}
	

	


}
