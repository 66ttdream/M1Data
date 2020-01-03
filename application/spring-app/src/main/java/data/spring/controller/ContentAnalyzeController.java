package data.spring.controller;

import data.controller.ContentAnalyzeControl;
import data.controller.modle.ContentShareNum;
import data.controller.modle.ContentShareRate;
import data.controller.modle.Heatwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "analyse")
@RestController
public class ContentAnalyzeController {
    private ContentAnalyzeControl ContentanalyzeControl;

    @Autowired
    public ContentAnalyzeController(ContentAnalyzeControl contentAnalyzeControl){
        this.ContentanalyzeControl = contentAnalyzeControl;
    }

    /**
     * 获取个人作品热度排行榜
     * @param userId 作者id
     * @param pageNum 页码
     * @param pageSize 页面条数
     * @return
     */
    @GetMapping(value = "heatwork/practitioner")
    public List<Heatwork> getHeatwork(@PathVariable int userId, @PathVariable int pageNum, @PathVariable int pageSize){
        return ContentanalyzeControl.getHeatwork(userId,pageNum,pageSize);
    }

    /**
     * 获取全部作品排行榜
     * @param pageNum 页码
     * @param pageSize 页面条数
     * @return
     */
    @GetMapping(value = "heatwork/manager ")
    public List<Heatwork> getAllHeatwork(@PathVariable int pageNum, @PathVariable int pageSize){
        return ContentanalyzeControl.getAllHeatwork(pageNum,pageSize);
    }
    @GetMapping(value = "sharenum/practitioner")
    public List<ContentShareNum> getShareNum(@PathVariable int userId,@PathVariable int pageNum, @PathVariable int pageSize){
        return ContentanalyzeControl.getShareNum(userId,pageNum,pageSize);
    }
    @GetMapping(value = "sharenum/manager")
    public List<ContentShareNum> getAllShareNum(@PathVariable int pageNum, @PathVariable int pageSize){
       return ContentanalyzeControl.getAllShareNum(pageNum,pageSize);
    }
    @GetMapping(value = "sharerate/practitioner")
    public List<ContentShareRate> getShareRate(@PathVariable int userId){
        return ContentanalyzeControl.getShareRate(userId);
    }
    @GetMapping(value = "sharerate/manager")
    public List<ContentShareRate> getAllShareRate(@PathVariable int userId){
        return ContentanalyzeControl.getAllShareRate();
    }
}
