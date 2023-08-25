package pro.demo.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ElementNotFound extends RuntimeException {
}
