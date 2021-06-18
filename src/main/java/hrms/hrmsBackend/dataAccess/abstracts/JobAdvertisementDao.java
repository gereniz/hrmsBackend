package hrms.hrmsBackend.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrms.hrmsBackend.entities.concretes.JobAdvertisement;
import hrms.hrmsBackend.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao  extends JpaRepository<JobAdvertisement,Integer>{
	
	@Query("Select new hrms.hrmsBackend.entities.dtos.JobAdvertisementDto(ja.id,e.companyName,ja.openPositionCount,ja.releaseDate,ja.applicationDeadline,ja.jobPosition.title) From Employer e Inner Join e.jobAdvertisements ja where ja.isActive = true")
	List<JobAdvertisementDto> getByIsActive(boolean isActive);
	
	@Query("Select new hrms.hrmsBackend.entities.dtos.JobAdvertisementDto(ja.id,e.companyName,ja.openPositionCount,ja.releaseDate,ja.applicationDeadline,ja.jobPosition.title) From Employer e Inner Join e.jobAdvertisements ja  where ja.isActive = true order by ja.releaseDate desc")
	List<JobAdvertisementDto> getByIsActiveByOrderByReleaseDate();
	
	@Query("Select new hrms.hrmsBackend.entities.dtos.JobAdvertisementDto(ja.id,e.companyName,ja.openPositionCount,ja.releaseDate,ja.applicationDeadline,ja.jobPosition.title) From Employer e Inner Join e.jobAdvertisements ja where ja.isActive = true and e.id=:id")
	List<JobAdvertisementDto> getByIsActiveOfEmployer(int id);
	

	
}
