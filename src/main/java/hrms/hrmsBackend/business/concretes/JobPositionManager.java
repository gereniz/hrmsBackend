package hrms.hrmsBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsBackend.business.abstracts.JobPositionService;
import hrms.hrmsBackend.core.utilities.results.DataResult;
import hrms.hrmsBackend.core.utilities.results.ErrorResult;
import hrms.hrmsBackend.core.utilities.results.Result;
import hrms.hrmsBackend.core.utilities.results.SuccessDataResult;
import hrms.hrmsBackend.core.utilities.results.SuccessResult;
import hrms.hrmsBackend.dataAccess.abstracts.JobPositionDao;
import hrms.hrmsBackend.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}



	@Override
	public DataResult<List<JobPosition>>getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Ürünler listelendi");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(!checkTitle(jobPosition.getTitle())) {
			return new ErrorResult("İş Pozisyonu bulunmaktadır");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş posizyonu eklendi");
	}
	
	private boolean checkTitle(String title) {
		if(this.jobPositionDao.findByTitle(title) == null) {
			return true;
		}
		return false;
	}

}
