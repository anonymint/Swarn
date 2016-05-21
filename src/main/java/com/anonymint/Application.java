package com.anonymint;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description of this class
 *
 * @author <a href="mailto:mint.com@gmail.com">anonymint</a>
 * @since 2016-05-21
 */

@SpringBootApplication
@Controller
@Api(basePath = "/data", value = "data", description = "Data API version 1", produces = "application/json")
@RequestMapping(value = "/data/api/v1")
public class Application {

	@ApiOperation(value = "Return id value", notes = "Return id value notes")
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getId(@PathVariable String id) {
		return String.format("{id: %s}", id);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
