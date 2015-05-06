/**
 * 
 */
package com.inertia.solutions.apollo.item.mvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Basic Web Controller (Html)
 * 
 * @author Ian Hamilton
 *
 */

@Controller
@RequestMapping(value={"/maintenance"})
public class MaintenanceController {

	@RequestMapping(method = RequestMethod.GET)
	public String get(Model model) {
		return "maintenance/data-maintenance";
	}
}
