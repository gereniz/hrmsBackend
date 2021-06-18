package hrms.hrmsBackend.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsBackend.business.abstracts.JobAdvertisementService;
import hrms.hrmsBackend.core.utilities.results.DataResult;
import hrms.hrmsBackend.core.utilities.results.Result;
import hrms.hrmsBackend.entities.concretes.JobAdvertisement;
import hrms.hrmsBackend.entities.dtos.JobAdvertisementDto;


@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getall(){
		return this.jobAdvertisementService.getall();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvertisementDto>> getByIsActive() {
		return this.jobAdvertisementService.getByIsActive(true);
	}
	
	@GetMapping("getAllSorted")
	public DataResult<List<JobAdvertisementDto>> getAllIsActiveSorted() {
		return this.jobAdvertisementService.getAllIsActiveSorted(true);
	}
	
	@GetMapping("/getByIsActiveOfEmployer")
	public DataResult<List<JobAdvertisementDto>> getByIsActiveOfEmployer(int id) {
		return this.jobAdvertisementService.getByIsActiveOfEmployer(id);
		
	}
	
	@PostMapping("/changeIsActiveByEmployer")
	public Result changeIsActiveByEmployer(@RequestParam int id) {
		return this.jobAdvertisementService.changeIsActiveByEmployer(id);
		
	}
	

}
