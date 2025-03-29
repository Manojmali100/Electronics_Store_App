package electronics_store.validate;

import java.lang.annotation.ElementType;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


	
	@Target({ElementType.FIELD,ElementType.PARAMETER})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Constraint(validatedBy = ImageNameValidetor.class)
	
	public @interface ImagenameValid {
		String message() default "Invalid Image name !!";
		
		Class<?>[]groups()default{};
		
		Class<?extends Payload>[]payload()default{};
	
	
	

}