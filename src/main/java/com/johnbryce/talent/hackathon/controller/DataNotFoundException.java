package com.johnbryce.talent.hackathon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NO_CONTENT, reason="No such user")
public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4352519322137912951L;

}
