package hrms.hrmsBackend.business.abstracts;

import java.util.List;

import hrms.hrmsBackend.core.utilities.results.DataResult;
import hrms.hrmsBackend.core.utilities.results.Result;
import hrms.hrmsBackend.entities.concretes.Candidate;

public interface CandidateService {

	DataResult<List<Candidate>> getall();
	Result add(Candidate candidate);
}
