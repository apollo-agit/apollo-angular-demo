/**
 * 
 */
package com.inertia.solutions.apollo.item.mvc.rest.controller;

import java.util.Collection;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItem;
import com.inertia.solutions.apollo.item.mvc.domain.entity.ApolloItemHistory;
import com.inertia.solutions.apollo.item.mvc.domain.service.ApolloItemHistoryService;
import com.inertia.solutions.apollo.item.mvc.domain.service.ApolloItemService;


/**
 * Using JRE 1.7.0_75
 * 
 * The Class ApolloItemsRestController which is a basic controller for
 * the main RESTful HTTP types. Except "PUT" since angular really uses
 * either POST or PUT for update transactions.
 *
 * @author Ian Hamilton
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping("/service/apolloitems")
public class ApolloItemsRestController {
	private static final String ACCEPT_APPLICATION_JSON = "Accept=application/json";

	@Autowired
	ApolloItemService apolloItemService;
	
	@Autowired
	ApolloItemHistoryService apolloItemHistoryService;
	
    @RequestMapping(value="/item/metadata", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
	public String head() throws JsonProcessingException  {
        ObjectMapper mapper = new ObjectMapper();
        JsonSchemaGenerator generator = new JsonSchemaGenerator(mapper);
        JsonSchema jsonSchema = generator.generateSchema(ApolloItem.class);
        String ret =  mapper.writeValueAsString(jsonSchema);
        return ret;
    }  
    
    @RequestMapping(value = "/item", method = RequestMethod.GET, headers = ACCEPT_APPLICATION_JSON)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
	public Collection<ApolloItem> getAll() {
    	return apolloItemService.findAllApolloItems();
    }
    

    @RequestMapping(value = "/item", method = RequestMethod.POST, headers = ACCEPT_APPLICATION_JSON)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
	public ApolloItem put(@RequestBody ApolloItem apolloItem) {
    	ApolloItem ret = apolloItemService.saveApolloItem(apolloItem);
    	ApolloItemHistory history = new ApolloItemHistory();
    	history.setApolloItemId(ret.getId());
    	history.setItemUpdateBy("system");
    	history.setItemUpdateDate(new Date());
    	history.setItemUpdateNote(String.format("Updated during REST call for ->%s", ret.getApolloItemName()));
    	apolloItemHistoryService.saveApolloItemHistory(history);
    	return ret;
    }
    

    @RequestMapping(value = "/item", method = RequestMethod.DELETE, headers = ACCEPT_APPLICATION_JSON)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
	public void delete(@RequestParam(required = false) String id) {
    	if(!StringUtils.isEmpty(id)) 
    		apolloItemService.deleteApolloItem(id);
    }   	
	

    @RequestMapping(value = "/history", method = RequestMethod.GET, headers = ACCEPT_APPLICATION_JSON)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Collection<ApolloItemHistory> getAllHistory(@RequestParam String itemId){
    	return apolloItemHistoryService.findAllApolloItemHistorysForItem(itemId);
    }
    
    @RequestMapping(value = "/history", method = RequestMethod.POST, headers = ACCEPT_APPLICATION_JSON)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ApolloItemHistory putHistory(@RequestBody ApolloItemHistory apolloItemHistory){
    	return apolloItemHistoryService.saveApolloItemHistory(apolloItemHistory);
    }
    
    
    
    @ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handleException(Exception ex) {
		return ex.getMessage();
	}

}
