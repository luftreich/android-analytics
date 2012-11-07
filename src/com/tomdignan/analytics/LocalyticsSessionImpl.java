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
import com.localytics.android.LocalyticsSession;
import static com.tomdignan.analytics.AnalyticsSessionConfig.LOCALYTICS_APP_KEY;

/**
 * Hides the details of the Analytics API from the rest of the application.
 *
 * @author Tom Dignan <tom@tomdignan.com>
 */
class LocalyticsSessionImpl extends AnalyticsSession {
    @SuppressWarnings("unused")
    private static String TAG = "LocalyticsHelper";

    private com.localytics.android.LocalyticsSession session;

    /** {@inheritDoc} */
    @Override
    public void create(Context context, String tag) {
        super.create(context, tag);
        this.session = 
            new LocalyticsSession(context.getApplicationContext(), LOCALYTICS_APP_KEY);
        this.session.open();
        // tagScreen() only works on premium accounts.
        this.session.tagScreen(tag);
        this.session.upload();
    }

    /** {@inheritDoc} */
    @Override
    public void resume() {
        super.resume();
        this.session.open();
    }

    /** {@inheritDoc} */
    @Override
    public void pause() {
        super.pause();
        this.session.close();
        this.session.upload();
    }

    /** {@inheritDoc} */
    @Override 
    public void event(String tag, HashMap<String,String> values) {
        super.event(tag, values);
        this.session.tagEvent(tag, values);
    }

    /** {@inheritDoc} */
    @Override 
    public void event(String tag) {
        super.event(tag);
        this.session.tagEvent(tag);
    }
}
