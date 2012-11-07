/*
AnalyticsSession

Copyright (C) 2012 Tom Dignan <tom@tomdignan.com>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.tomdignan.analytics;

import java.util.HashMap;

import android.content.Context;
import android.util.Log;

/** 
 * Provides a generic interface for analytics. Protects against
 * misuse of analytics APIs.
 *
 * Concrete Analytics API wrappers should extend this class. 
 */
public abstract class AnalyticsSession implements IAnalyticsSession {
    private static final String TAG = "AnalyticsSession";

    @Override
    public void create(Context context, String tag) {
        Log.v(TAG, 
            String.format("creating analytics session with tag=%s", tag));
    }

    @Override
    public void resume() {
        Log.v(TAG, "resuming analytics session");
    }

    @Override
    public void pause() { 
        Log.v(TAG, "pausing analytics session");
    }

    @Override 
    public void event(String tag) {
        Log.v(TAG, 
            String.format("logging event with tag=%s", tag));
    }

    @Override
    public void event(String tag, HashMap<String,String> values) {
        Log.v(TAG, 
            String.format("logging event with tag=%s and values=%s", tag,
                String.valueOf(values)));
    }
}
