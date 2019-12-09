package data.spring.controller;

import data.controller.InterfaceParameterControl;
import data.controller.modle.SynParameterWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RequestMapping(value = "/syn", method = RequestMethod.POST)
@RestController
public class SynController {

    private final InterfaceParameterControl interfaceParameterControl;
    @Autowired
    public SynController(InterfaceParameterControl interfaceParameterControl) {
        this.interfaceParameterControl = interfaceParameterControl;
    }


    @RequestMapping(value = "/syn/start", method = RequestMethod.POST)
    public String synStart(@RequestBody SynParameterWeb synParameterWeb) {
        System.out.println("连接成功");
        interfaceParameterControl.start(synParameterWeb);
        return "successful";

    }
    @PostMapping(value = "/syn/cancel")
    public String synCancel(@RequestBody SynParameterWeb synParameterWeb) {
        interfaceParameterControl.cancel(synParameterWeb);
        return "successful";
    }
    @PostMapping(value = "/llect")
    public void llect(@RequestBody SynParameterWeb synParameterWeb){

    }
}
