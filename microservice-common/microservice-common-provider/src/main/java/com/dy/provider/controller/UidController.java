package com.dy.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dy.api.utils.JsonResult;
import com.dy.fsg.uid.UidGenerator;

@RestController
@RequestMapping("uid")
public class UidController {
	
	@Autowired
	private UidGenerator uidGenerator;
	
	@GetMapping
	public JsonResult<Long> getUid() {
		return new JsonResult<>(uidGenerator.getUID());
	}

}
