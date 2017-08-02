# Animations
Beautiful animations and views from AOSP

# Usage

* FingerprintAnimationImageView
  帶有指紋識別動畫的ImageView。

  **設置 -> 安全性 -> 指紋 -> 新增指紋**

  ![FingerprintAnimationImageView](https://raw.githubusercontent.com/AndroidSnippet/Animations/master/art/FingerprintAnimationImageView_0.PNG)

  ```xml
  <top.trumeet.snippet.aospanimation.library.FingerprintAnimationImageView
            android:id="@+id/fingerprint_animator"
            android:layout_width="@dimen/fingerprint_animation_size"
            android:layout_height="@dimen/fingerprint_animation_size" />
  ```

  開始動畫: `startIconAnimation()`
  停止動畫: `stopIconAnimation()`

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