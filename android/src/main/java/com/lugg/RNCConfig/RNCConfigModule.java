package com.lugg.RNCConfig;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import java.lang.ClassNotFoundException;
import java.lang.IllegalAccessException;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;

public class RNCConfigModule extends ReactContextBaseJavaModule {

    public RNCConfigModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNCConfigModule";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        try {
            
           
            Class clazz = Class.forName("com.core.BuildConfig");
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                try {
                    constants.put(f.getName(), f.get(null));
                } catch (IllegalAccessException e) {
                    Log.d("ReactNative", "ReactConfig: Could not access BuildConfig field " + f.getName());
                }
            }
        } catch (ClassNotFoundException e) {
            Log.d("ReactNative", "ReactConfig: Could not find BuildConfig class");
        }
        return constants;
    }
}
