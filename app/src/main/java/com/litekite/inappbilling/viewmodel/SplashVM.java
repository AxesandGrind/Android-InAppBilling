/*
 * Copyright 2018 LiteKite Startup. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.litekite.inappbilling.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Handler;
import android.support.annotation.NonNull;

/**
 * SplashVM, which notifies {@link #splashTimeDelay} to the view when the
 * {@link #SPLASH_TIME_DELAY_IN_MS} completes.
 *
 * @author Vignesh S
 * @version 1.0, 10/03/2018
 * @since 1.0
 */
public class SplashVM extends AndroidViewModel implements LifecycleObserver {

	private static final int SPLASH_TIME_DELAY_IN_MS = 3000;
	private MutableLiveData<Boolean> splashTimeDelay;

	/**
	 * @param application application An Application Instance.
	 */
	public SplashVM(@NonNull Application application) {
		super(application);
	}

	/**
	 * A view gets this {@link #splashTimeDelay} and observes for changes.
	 *
	 * @return whether the {@link #splashTimeDelay} whether the {@link #SPLASH_TIME_DELAY_IN_MS}
	 * completed or not.
	 */
	public MutableLiveData<Boolean> getSplashTimeDelay() {
		if (splashTimeDelay == null) {
			splashTimeDelay = new MutableLiveData<>();
		}
		return splashTimeDelay;
	}

	@OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
	public void initHandler() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				splashTimeDelay.postValue(true);
			}
		}, SPLASH_TIME_DELAY_IN_MS);
	}

}
