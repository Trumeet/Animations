# Animations

[![](https://jitpack.io/v/AndroidSnippet/Animations.svg)](https://jitpack.io/#AndroidSnippet/Animations)

Beautiful animations and views from AOSP

# 依賴

* Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

* 查詢最新版本

請前往 [Release頁面](https://github.com/AndroidSnippet/Animations/releases) 獲取最新版本號

* 添加依賴

```
    dependencies {
	        compile 'com.github.AndroidSnippet:Animations:<最新版本號>'
	}
```

# Usage


## Fingerprint isolated animation

 **設置 -> 安全性 -> 指紋 -> 新增指紋** 中間的指紋圖標動畫

 來自 [platform_packages_apps_settings/FingerprintEnrollEnrolling.java](https://github.com/android/platform_packages_apps_settings/blob/master/src/com/android/settings/fingerprint/FingerprintEnrollEnrolling.java)

 ![animation](https://raw.githubusercontent.com/AndroidSnippet/Animations/master/art/FingerprintAnimationImageView_0.PNG)

 ```xml
 <android.support.v7.widget.AppCompatImageView
             android:id="@+id/fingerprint_animator"
             android:layout_width="@dimen/fingerprint_animation_size"
             android:layout_height="@dimen/fingerprint_animation_size"
             app:background="@drawable/fp_illustration_enrollment"
             app:backgroundTint="@color/fingerprint_indicator_background_resting"
             />
 ```

 Set up animation:

 ```java
 LoopAnimatedVectorDrawableCompat mFingerprintAnimator = new LoopAnimatedVectorDrawableCompat(AnimatedVectorDrawableCompat.create(this,
                                                                       R.drawable.enrollment_fingerprint_isolated_animation));
 fingerprintIsolated.setImageDrawable(mFingerprintAnimator.getDrawable());
 ```

 Set background image:

 ```java
 fingerprintIsolated.setBackgroundDrawable(AppCompatResources.getDrawable(MainActivity.this
                 , top.trumeet.snippet.aospanimation.library.R.drawable.fp_illustration_enrollment));
 fingerprintIsolated.setSupportBackgroundTintList(ColorStateList.valueOf(getResources().getColor(top.trumeet.snippet.aospanimation.library.R.color.fingerprint_indicator_background_resting)));
 ```

 開始動畫: `mFingerprintAnimator.startIconAnimation()`

 停止動畫: `mFingerprintAnimator.stopIconAnimation()`

# Licenses
使用本項目請確保您遵守 `Apache License 2.0`
```
Copyright (C) 2017 AndroidSnippet

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
```
Copyright (C) 2015 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```