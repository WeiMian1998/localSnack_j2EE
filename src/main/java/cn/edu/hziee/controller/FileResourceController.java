package cn.edu.hziee.controller;  

import java.io.IOException;  
import java.nio.file.Files;  
import java.nio.file.Paths;  
import java.util.stream.Collectors;  
  
import javax.servlet.http.HttpServletRequest;  
  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;  
import org.springframework.http.ResponseEntity;  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.bind.annotation.ResponseBody;  
import org.springframework.web.multipart.MultipartFile;  
import org.springframework.web.servlet.mvc.support.RedirectAttributes;  
  
@Controller 
@RequestMapping("resource")
public class FileResourceController {  
  
    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);  
  
    
//  @Value("${filePath}")
  private   String ROOT ="F:/head/";    
  
    private final ResourceLoader resourceLoader;  
  
    @Autowired  
    public FileResourceController(ResourceLoader resourceLoader) {  
        this.resourceLoader = resourceLoader;  
    }  
  
  //显示图片的方法关键 匹配路径像 localhost:8080/b7c76eb3-5a67-4d41-ae5c-1642af3f8746.png  
    @RequestMapping(method = RequestMethod.GET, value = "/{filename:.+}")  
    @ResponseBody  
    public ResponseEntity<?> getFile(@PathVariable String filename) {  
  
        try {  
        	System.out.println(filename);
        	
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString()));  
        } catch (Exception e) {  
            return ResponseEntity.notFound().build();  
        }  
    }  
    
}