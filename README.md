# Simple Sate Manager for Android

This library is a simple state manager written in Java for android

### How to use it
In your application or starting activity ```onCreate()``` method initialize the library my calling
``` java
public class SateApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SateManager.init(Context context);
    }
}

```
##### Saving an object
In another activity or fragment you can save or update an object by calling the ```saveObject()``` 
which overrides any object stored in the key reference
``` java
SateManager sm = StateManager.getInstance();
sm.saveObject(String key, Object object); //String Key and Any Pojo Object as parameters
``` 

##### Retrieve an object
In another activity or fragment you can retrieve an object by 
``` java
SateManager sm = StateManager.getInstance();
sm.getObject(String key, Type type); //String Key and Object Type as parameters
``` 

##### Delete an object
In another activity or fragment you can delete an object by passing in the key of the object
``` java
SateManager sm = StateManager.getInstance();
sm.deleteObject(String key); //String Key
``` 