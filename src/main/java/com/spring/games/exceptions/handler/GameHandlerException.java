package com.spring.games.exceptions.handler;

import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.spring.games.dto.ErrorDto;
import com.spring.games.exceptions.game.GameIsAlreadySetException;
import com.spring.games.exceptions.game.GameNotFoundException;

@ControllerAdvice
public class GameHandlerException extends ResponseEntityExceptionHandler {

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler({ GameNotFoundException.class })
	@ResponseBody
	public ErrorDto handleGameNotFound(HttpServletRequest request, GameNotFoundException exception) {
		return new ErrorDto("01", exception.getDetalle());
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler({ GameIsAlreadySetException.class })
	@ResponseBody
	public ErrorDto handleIsAlreadySet(HttpServletRequest request, GameIsAlreadySetException exception) {
		return new ErrorDto("02", exception.getDetalles());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream().map(e -> e.getDefaultMessage())
				.collect(Collectors.toList());
		return new ResponseEntity<>(new ErrorDto("03", errorMessages.toString()), HttpStatus.BAD_REQUEST);
	}

}
