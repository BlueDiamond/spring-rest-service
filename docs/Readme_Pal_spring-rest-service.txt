


rest service URL to access: tomcat
http://localhost:8080/spring-rest-service/rest/userprofiles

jboss:
get all user profiles:
http://localhost:9090/spring-rest-service/rest/userprofiles

create a new user profile: - post
http://localhost:9090/spring-rest-service/rest/createuserprofile


 
 -----------------------------------------------------------------------------------------------------------------------------------------------------
json to pojo:
https://github.com/astav/JsonToJava.git

https://github.com/wotifgroup/json2pojo.git
----
docs:

https://github.com/astav/JsonToJava/wiki/JsonToJava
-----------------------------------------------------------------------------------------------------------------------------------------------------
main function to be used inside com.astav.jsontojava.JsonToJava:

 public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        
        System.out.println("JsonToJava v0.1");
        System.out.println();
        
        String jsonFile = "/Users/palani/git/RESTful/rest-service/docs/json/getUserProfile-response.json";
        String outputDirectory = "/Users/palani/git/RESTful/rest-service/src/main/java";
        String packageName = "com.bd.spring.rest.domain";
        String mainClass = "BdJsonResponse";
        String regeexFile = "";
        boolean promptForComplexValueTypes = false;
        String importBaseDir = null;
        List<String> importPackageNames = null;
        
        
        @SuppressWarnings("unchecked") Map<String, Object> map = mapper.readValue(FileUtils.readFileToString(new File(jsonFile)), Map.class);
        
        Generator generator = new Generator(outputDirectory, packageName, regeexFile, importBaseDir, importPackageNames, promptForComplexValueTypes);
        
        System.out.println("Generating classes....");
        
        generator.generateClasses(mainClass, map);
        
        System.out.println();
        
        System.out.println(String.format("Generated %s files. All done.", generator.getGeneratedFileCount()));
    }
    
 -----------------------------------------------------------------------------------------------------------------------------------------------------

 
 