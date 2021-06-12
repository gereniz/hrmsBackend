package hrms.hrmsBackend.core.services;

import org.springframework.stereotype.Service;



@Service
public class EmailVerification {

	public void emailcontrol(String email) {
		System.out.println(email + " adresine doğrulama mesajı gitmiştir.");
	}
}
