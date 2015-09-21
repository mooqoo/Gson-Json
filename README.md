Gson-Json
=========

An Android sample code that convert data between json and java object using both Android's JSONObject and Google's gson. This sample code is based on [this tutorial][tutorial] and modifed to test the conversion between json and java object with nested object.   

Three Custom Class was created and used:
 -   Albums (Contains a List of **Dataset**)
 -   Dataset (Contains a List of **AlbumImages**)
 -   AlbumImages


Gradle:  
 -   ButterKnife (compile 'com.jakewharton:butterknife:7.0.1')
 -   Gson (compile 'com.google.code.gson:gson:2.3.1')
    
<!-- link -->
[tutorial]: http://www.studytrails.com/java/json/java-google-json-parse-json-to-java.jsp
