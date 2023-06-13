package com.Spring.toDoApp.controllers;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VelocityController {
	
	  @RequestMapping("/exampleVelocity")
	    String home()throws Exception{
	        String result = null;

	        VelocityEngine velocity = new VelocityEngine();
	        velocity.init();
	        Template template = velocity.getTemplate("src/main/resources/templates/general/htmlElement.vm");

	        VelocityContext context = new VelocityContext();
	        context.put("title", "Apache Velocity");

	        StringWriter writer = new StringWriter();
	        template.merge(context, writer);

	        result = writer.toString();

	        return result;
	}

}
