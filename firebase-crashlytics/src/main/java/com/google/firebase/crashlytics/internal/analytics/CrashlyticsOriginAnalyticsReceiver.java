// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;

/** AnalyticsReceiver which handles events from the Crashlytics origin. */
public class CrashlyticsOriginAnalyticsReceiver implements AnalyticsReceiver {

  private static final String APP_EXCEPTION_EVENT_NAME = "_ae";

  @NonNull private final AppExceptionEventHandler appExceptionEventHandler;

  public CrashlyticsOriginAnalyticsReceiver(
      @NonNull AppExceptionEventHandler appExceptionEventHandler) {
    this.appExceptionEventHandler = appExceptionEventHandler;
  }

  @Override
  public void onEvent(@NonNull String name, @NonNull Bundle params) {
    if (APP_EXCEPTION_EVENT_NAME.equals(name)) {
      appExceptionEventHandler.onEventRecorded();
    }
  }
}
