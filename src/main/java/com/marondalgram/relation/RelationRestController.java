package com.marondalgram.relation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.marondalgram.relation.bo.RelationBO;

@RestController
public class RelationRestController {
	
	@Autowired
	private RelationBO relationBO;
	
}
