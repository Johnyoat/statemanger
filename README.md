# Simple Sate Manager for Android

This library is a simple state manager written in Java for android

### Sdk Version ###
`compileSdkVersion` >= 25

### Importing to project ###

#### Example for Gradle: ####

Step 1. Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
		maven { url "https://maven.google.com" }
	}
}
```

##### If you're using gradle 3.+.+ 
```groovy
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
		google()
	}
}
```

Step 2. Add the dependency
```groovy
implementation 'com.github.Johnyoat:statemanger:1.0.0'
implementation 'com.google.code.gson:gson:2.8.5'
```

## How to use it
In your application or starting activity ```onCreate()``` method initialize the library by calling `SateManager.init(Context context)`
> NB: you can call this method anywhere in your code but it must be called before you start using any other methods provided by the StateManager class
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

## License

Copyright 2017 Litetech Ghana

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.