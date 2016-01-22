package com.example.controller;

import com.example.service.DataService;
import com.example.utils.Ajax;
import com.example.utils.RestException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Set;

/**
 * Created by azaz on 14/01/16.
 */
@Controller
public class DataController extends ExceptionHandlerController {

    private static final Logger LOG = Logger.getLogger(DataController.class);

    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/persist", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> persist(@RequestParam("data") String data) throws RestException {
        try {
            if (data == null || data.equals("")) {
                return Ajax.emptyResponse();
            }
            dataService.persist(data);
            return Ajax.emptyResponse();
        } catch (Exception e) {
            throw new RestException(e);
        }
    }
    @RequestMapping(value = "/getByDescr",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getByDescr(@RequestParam("data")String data){
        LOG.info(Ajax.successResponse(dataService.findByDescr(data))+" "+dataService.findByDescr(data));
        return Ajax.successResponse(dataService.findByDescr(data));
    }
    @RequestMapping(value = "/getRandomData", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getRandomData() throws RestException {
        try {
            Set<String> result = dataService.getRandomData();
            return Ajax.successResponse(result);
        } catch (Exception e) {
            throw new RestException(e);
        }
    }


}