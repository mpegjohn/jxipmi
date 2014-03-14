package com.xyratex.jxipmi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.imageio.stream.FileImageInputStream;

import com.xyratex.jxipmi.yamlspecs.*;

import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.constructor.Constructor;

public class ReadYaml {

	public static void main(String[] args) throws FileNotFoundException {
		Yaml yaml = new Yaml();
		
		File file = new File("/home/john/common_sdr_header.yaml");
		
		InputStream stream = new FileInputStream(file);
		
	//	Constructor cstr = new Constructor(SdrHeaderSpec.class);
	//	TypeDescription pDesc = new TypeDescription(SdrHeaderSpec.class);
		//pDesc.putListPropertyType("enums", Enums.class);
		//cstr.addTypeDescription(pDesc);
		//Yaml yaml = new Yaml(cstr);
		
		
		
		//SdrHeaderSpec hdr =  (SdrHeaderSpec) yaml.load(stream);
		
		Map<String, Object> data = (Map<String, Object>) yaml.load(stream);

		String name = (String)data.get("name");
		
		Map<String, Object> enums = (Map<String, Object>)  data.get("enums");
		List<String> overlay = (List<String>)  data.get("overlay");
		
		
	}

}
