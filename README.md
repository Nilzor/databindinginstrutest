# A project illustrating how adding data binding to a project breaks instrumentation tests.

Here is the output from a test run I did on a Samsung Galaxy Tab 3 10.1 running Android 4.4.2 (sdk 19)

## Test Output

    Testing started at 21.44 ...
    Target device: samsung-gt_p5220-430036c6467e2100
    Installing APK: D:\coding\source\testing\DataBindInstruTest\app\build\outputs\apk\app-debug.apk
    Uploading file to: /data/local/tmp/com.example.databindinstrutest
    Installing com.example.databindinstrutest
    DEVICE SHELL COMMAND: pm install -r "/data/local/tmp/com.example.databindinstrutest"
        pkg: /data/local/tmp/com.example.databindinstrutest
    Success


    Installing APK: D:\coding\source\testing\DataBindInstruTest\app\build\outputs\apk\app-debug-androidTest-unaligned.apk
    Uploading file to: /data/local/tmp/com.example.databindinstrutest.test
    Installing com.example.databindinstrutest.test
    DEVICE SHELL COMMAND: pm install -r "/data/local/tmp/com.example.databindinstrutest.test"
        pkg: /data/local/tmp/com.example.databindinstrutest.test
    Success


    Running tests
    Test running started
    Test failed to run to completion. Reason: 'Instrumentation run failed due to 'java.lang.IllegalAccessError''. Check device logcat for details
    Test running failed: Instrumentation run failed due to 'java.lang.IllegalAccessError'

## Logcat output

```
01-28 21:44:51.382 20951-20951/? E/AndroidRuntime: FATAL EXCEPTION: main
                                                   Process: com.example.databindinstrutest, PID: 20951
                                                   java.lang.IllegalAccessError: Class ref in pre-verified class resolved to unexpected implementation
                                                       at android.databinding.DataBindingUtil.<clinit>(DataBindingUtil.java:31)
                                                       at com.example.databindinstrutest.MainActivity.onCreate(MainActivity.java:15)
                                                       at android.app.Activity.performCreate(Activity.java:5541)
                                                       at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1093)
                                                       at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2368)
                                                       at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2464)
                                                       at android.app.ActivityThread.access$900(ActivityThread.java:172)
                                                       at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1308)
                                                       at android.os.Handler.dispatchMessage(Handler.java:102)
                                                       at android.os.Looper.loop(Looper.java:146)
                                                       at android.app.ActivityThread.main(ActivityThread.java:5653)
                                                       at java.lang.reflect.Method.invokeNative(Native Method)
                                                       at java.lang.reflect.Method.invoke(Method.java:515)
                                                       at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1291)
                                                       at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1107)
                                                       at dalvik.system.NativeStart.main(Native Method)
01-28 21:44:51.382 2422-2851/? W/ActivityManager:   java.lang.IllegalAccessError
01-28 21:44:51.382 2422-2851/? W/ActivityManager:   java.lang.IllegalAccessError: Class ref in pre-verified class resolved to unexpected implementation

```

## Update: 

Fixed in Gradle 2.3

https://issuetracker.google.com/issues/37056708
