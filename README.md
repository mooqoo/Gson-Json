Gson-Json
=========

An Android sample code that convert data between json and java object using both Android's JSONObject and Google's gson. This sample code is based on [this tutorial][tutorial] and modifed to test the conversion between json and java object with nested object.   

Three Custom Class was created and used:
 -   Albums (Contains a List of **Dataset**)
 -   Dataset (Contains a List of **AlbumImages**)
 -   AlbumImages

Below is the layout of this sample app:

![app layout](https://cloud.githubusercontent.com/assets/6467567/9994470/f84b08f8-60af-11e5-84b7-e3636e2f77d5.png)

### Reset Object Button  
By pressing this button, a new Albums object will be created with random values.   

### Gson Section :  
**To JSON**: this button will convert album object to json using gson library.   
**PARSING**: this button will convert json data back to album object using gson library.   

### JSONObject Section :
An JSONUtil Class was created and used to handle all the json conversion using Android's JSONObject library.   
**To JSON**: this button will convert album object to json using JSONUtil(JSONObject).   
**PARSING**: this button will convert json data back to album object using JSONUtil(JSONObject).

Gradle:  
 -   ButterKnife (compile 'com.jakewharton:butterknife:7.0.1')
 -   Gson (compile 'com.google.code.gson:gson:2.3.1')
    
<!-- link -->
[tutorial]: http://www.studytrails.com/java/json/java-google-json-parse-json-to-java.jsp
