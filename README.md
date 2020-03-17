# AwesomeEdittext 
[ ![Download](https://api.bintray.com/packages/anoop44/maven/awesome-edittext/images/download.svg?version=1.1.0) ](https://bintray.com/anoop44/maven/awesome-edittext/1.1.0/link) <a href="https://android-arsenal.com/api?level=17"><img alt="API" src="https://img.shields.io/badge/API-17%2B-brightgreen.svg?style=flat"/></a> [![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-AwesomeEditText-green.svg?style=flat )]( https://android-arsenal.com/details/1/8044 )

AwesomeEdittext is a better Edittext with a cool character zoom out animation while typing
![gif of AwesomeEdittext](https://raw.githubusercontent.com/anoop44/AwesomeEditText/master/art/awesome-edittext-demo.gif)

## Adding to project

### Gradle
Add below code to your **root** `build.gradle` file (if you have multiple modules and only one of them require `AwesomeEditText`, add the `jcenter()` repository only in that module's `build.gradle`).
```gradle
allprojects {
    repositories {
        jcenter()
    }
}
```
And add the following dependency code to your **module**'s `build.gradle` file.
```gradle
dependencies {
    implementation "ss.anoop:awesome-edittext:${latest-version}"
}
```
AwesomeEdittext can be included in your layout xml like any other view. Below is a simple example

## Usage
```xml
<ss.anoop.awesomeedittext.AwesomeEditText
        android:id="@+id/amount_input"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:animationDuration="500"/>
```

## Find this library useful? :heart:
Support it by joining __[stargazers](https://github.com/anoop44/AwesomeEditText/stargazers)__ for this repository. :star:

# License
```
Copyright 2020 anoop44 (Anoop)

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
