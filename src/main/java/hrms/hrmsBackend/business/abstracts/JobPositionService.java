package hrms.hrmsBackend.business.abstracts;

import java.util.List;

import hrms.hrmsBackend.core.utilities.results.DataResult;
import hrms.hrmsBackend.core.utilities.results.Result;
import hrms.hrmsBackend.entities.concretes.JobPosition;

public interface JobPositionService {

	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition jobPosition);
	
}
