
package com.excel.demo.service;

import com.excel.demo.repository.TeleComRepository;
import com.github.opendevl.JFlat;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TelComService {
    public TeleComRepository telcomrepo;
    
    public TelComService(TeleComRepository telcomrepo){
        this.telcomrepo = telcomrepo;
    };
    
    public ResponseEntity<?> generateCSV() throws Exception{

        List<Object> telComAd = telcomrepo.findAllJsons();
        
        String str = new String(telComAd.toString());
        System.out.println(str);
        System.out.println(telComAd);

        JFlat flatMe = new JFlat(str);

//        get the 2D representation of JSON document
        flatMe.json2Sheet().headerSeparator("_").getJsonAsSheet();

//        write the 2D representation in csv format
        flatMe.write2csv("/Users/fatech98/Desktop/path_to_output.csv");//Rename ur folder space
        return ResponseEntity.ok("OK");
    }
}
