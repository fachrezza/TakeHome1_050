/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.takehome;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author A S U S
 */
@Controller
public class myController {
    @RequestMapping("/Input")
    //@ResponseBody
    public String next(@RequestParam(value = "varA") String bagianA,
            @RequestParam(value = "varB") String bagianB,
            @RequestParam(value = "foto") MultipartFile bagianfoto,
            Model isiData
            
    )throws IOException{  
        byte[] img = bagianfoto.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String imglink= "data:image/png;base64,".concat(base64Image);
        isiData.addAttribute("paket1", bagianA);
        isiData.addAttribute("paket2", bagianB);
        isiData.addAttribute("paket3", imglink);
        
        
        return "view";
    }
    
}
