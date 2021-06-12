package hrms.hrmsBackend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsBackend.business.abstracts.EmployerService;
import hrms.hrmsBackend.core.utilities.results.DataResult;
import hrms.hrmsBackend.core.utilities.results.Result;
import hrms.hrmsBackend.entities.concretes.Employer;

@RestController
@RequestMapping("/api/empleyers")
public class EmployerController {

	private EmployerService employerService;

	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/gatall")
	public DataResult<List<Employer>> getall() {
		return this.employerService.getall();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}
	
	
	
}
