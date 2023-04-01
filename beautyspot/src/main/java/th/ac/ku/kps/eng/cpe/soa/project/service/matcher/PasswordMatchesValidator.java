package th.ac.ku.kps.eng.cpe.soa.project.service.matcher;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import th.ac.ku.kps.eng.cpe.soa.project.model.dto.SignupDTO;



public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		SignupDTO user = (SignupDTO) obj;
		return user.getPwd().equals(user.getMatchingPassword());
	}

	
}
