package com.lugg.RNCConfig;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import java.util.Map;

public abstract class RNCConfigSpec extends ReactContextBaseJavaModule {
    public RNCConfigSpec(ReactApplicationContext context) {
        super(context);
    }

    public abstract Map<String, Object> getConstants();
}