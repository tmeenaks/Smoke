package com.org.iot.test.smoke;

public class Workspace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "{\"m2m:cnt\": {\"rn\": \"FORM_7715941417623442173685260142853923031162472\",\"mni\": 100,\"mbs\": 1000,\"mia\": 10000,\"acp\": [\"SP_ACP_10 jan_66cb73fd-0f95-4b4f-a13f-c77935c2da3b\"]}}";
		String[] s1= pattern.split(",");
		String c = s1[0];
		System.out.println(c);
		String[] d =c.split(":");
		String e= d[3];
		System.out.println(e);
		String line1 = e.replace("\"", "").trim();
		System.out.println(line1);
		
	}

}
