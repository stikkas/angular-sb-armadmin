package ru.insoft.archive.app.ctrl;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Разруливает два основных маршрута
 *
 * @author stikkas<stikkas@yandex.ru>
 */
@Controller
public class MainController {

	@RequestMapping(value = "/login", method = POST, produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Boolean> processSuccessLogin() {
		return new ResponseEntity<>(true, OK);
	}

	@RequestMapping(value = "/failedLogin", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> processFailedLogin() {
		return new ResponseEntity<>(false, NOT_FOUND);
	}

}
