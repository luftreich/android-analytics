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

import android.app.Activity;
import android.support.v4.app.Fragment;

public class FragmentAnalyticsHelper {
    public static AnalyticsSession getAnalyticsSession(Fragment fragment) {
        Activity activity = fragment.getActivity();
        
        if (activity == null) {
            throw new IllegalStateException("getSession() must be called during or after onActivityCreated()!");
        }

        if (activity instanceof Trackable) {
            AnalyticsSession session = ((Trackable)activity).getAnalyticsSession();
            if (session == null) {
                throw new IllegalStateException("Trackable activities must return a valid AnalyticsSession!");
            }
            return session;
        } else {
            return new DummySession();
        }
    }
}
