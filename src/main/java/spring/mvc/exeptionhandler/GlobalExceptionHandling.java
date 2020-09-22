package spring.mvc.exeptionhandler;

import java.io.IOException;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(value = IOException.class)
	private ModelAndView processIOException(IOException exception) {
		return new ModelAndView("error", "error", exception.getMessage());
	}
	
	@ExceptionHandler(value = BindException.class)
	private ModelAndView processInvalidData(BindException exception) {
		StringBuilder error=new StringBuilder();
		for(ObjectError objectError:exception.getAllErrors()) {
			error.append(objectError.getDefaultMessage());
			error.append("<br/>");
		}
		return new ModelAndView("error", "error", error);
	} 
}
