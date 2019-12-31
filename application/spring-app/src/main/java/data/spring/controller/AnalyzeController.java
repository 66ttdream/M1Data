package data.spring.controller;

import data.controller.AnalyzeControl;
import data.controller.modle.Heatwork;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "analyse")
@RestController
public class AnalyzeController {
    private AnalyzeControl analyzeControl;
    @GetMapping
    public List<Heatwork> getHeatwork(@PathVariable int userId, @PathVariable int pageNum, @PathVariable int pageSize){
        return analyzeControl.getHeatwork(userId,pageNum,pageSize);
    }
    @GetMapping
    public List<Heatwork> getAllHeatwork(@PathVariable int pageNum, @PathVariable int pageSize){
        return analyzeControl.getAllHeatwork(pageNum,pageSize);
    }
}
