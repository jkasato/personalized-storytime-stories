package storytime.websites;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@EnableAutoConfiguration
public class AdminSiteController {
    Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

  //http://localhost:8090/admin/stories
    @GetMapping("/admin/stories")
    public String stories(ModelMap model) {
        log.info("getting /admin/stories");
        return "admin/story-all-show";
    }
    
  //http://localhost:8090/admin/story/edit/1
    @GetMapping("/admin/story/edit/{id}")
    public String story__edit(ModelMap model,
                              @PathVariable("id") long id) {
        log.info("getting /admin/story/edit/{}", id);
        model.addAttribute("id", id);
        return "admin/story-one-edit";
    }
    
    //http://localhost:8090/admin/story/new
    @GetMapping("/admin/story/new")
    public String story__new(ModelMap model) {
        log.info("getting admin/story/new");
//        return "admin/story-one-edit";
      return "admin/story-one-new";
    }

}
