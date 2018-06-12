# Simple Sate Manager for Android

This library is a simple state manager written in Java for android

## How to use it
In your application or starting activity ```onCreate()``` method initialize the library by calling `SateManager.init(Context context)`
> NB: you can call this method anywhere in your code by it must be called before you start using any other methods provided by the StateManager class
``` java
public class SateApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SateManager.init(this);
    }
}

```
##### Saving an object
In another activity or fragment you can save or update an object by calling the `sm.saveObject(String key, Object object)` 
which overrides any object stored in the key reference
``` java
SateManager sm = StateManager.getInstance();
sm.saveObject("Message", "Hello World");
``` 

##### Retrieve an object
In another activity or fragment you can retrieve an object by calling `sm.getObject(String key, Type type)`
which takes  String Key and Object Type as parameters

``` java
SateManager sm = StateManager.getInstance();
String message = sm.getObject("Message",String.class);
``` 

##### Delete an object
In another activity or fragment you can delete an object by passing in the key of the object
``` java
SateManager sm = StateManager.getInstance();
sm.deleteObject("Message");
``` 