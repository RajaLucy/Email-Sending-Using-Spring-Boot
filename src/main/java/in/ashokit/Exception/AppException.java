package in.ashokit.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppException {

	@ExceptionHandler(value=Exception.class)
	public String exception(Exception e)
	{
		e.printStackTrace();
		
		return "error";
	}
}
