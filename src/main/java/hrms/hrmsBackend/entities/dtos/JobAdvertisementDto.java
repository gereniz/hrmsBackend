package hrms.hrmsBackend.entities.dtos;



import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private int id;
	
	private String companyName;
	
	private int  openPositionCount;
	
	private LocalDate releaseDate;
	
	private LocalDate applicationDeadline;
	
	private String jobPosition;
	
}
