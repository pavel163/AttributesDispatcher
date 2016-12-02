# AttributesDispatcher
It is a lightweight library which helps to create a custom view.

**The library is 100% reflection-free.**

## Usage

AttributesDispatcher introduces a few annotations:

> NOTE: Annotated methods and fields must not be `private`.

|Annotation|Required|Description|
|---|---|---|
|`@CustomView`|**✓**|Register Custom View|
|`@Attribute`||Annotate a method which performs the action that requires one or more attributes|
|`@BooleanAttr`||Annotate fields or parameters with @BooleanAttr and a custom boolean format attribute for Attribute to find and automatically cast the corresponding attribute in your view.|
|`@ColorAttr`||Annotate fields or parameters with @ColorAttr and a custom color format attribute for Attribute to find and automatically cast the corresponding attribute in your view.|
|`@DimenAttr`||Annotate fields or parameters with @DimenAttr and a custom dimension format attribute for Attribute to find and automatically cast the corresponding attribute in your view.|
|`@FloatAttr`||Annotate fields or parameters with @FloatAttr and a custom float format attribute for Attribute to find and automatically cast the corresponding attribute in your view.|
|`@IntAttr`||Annotate fields or parameters with @IntAttr and a custom integer format attribute for Attribute to find and automatically cast the corresponding attribute in your view.|
|`@ReferenceAttr`||Annotate fields or parameters with @ReferenceAttr and a custom reference format attribute for Attribute to find and automatically cast the corresponding attribute in your view.|
|`@StringAttr`||Annotate fields or parameters with @StringAttr and a custom string format attribute for Attribute to find and automatically cast the corresponding attribute in your view.|

## Example

### 1. Create custom declare-styleable

```xml
<resources>
    <declare-styleable name="MyCustomView">
        <attr name="custom_text" format="string" />
        <attr name="custom_color" format="color" />
    </declare-styleable>
</resources>
```
### 2. In your layout 

```xml
    <com.ebr163.example.MyCustomView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:custom_text="Text1"
        app:custom_color="@android:color/holo_blue_light" />
```
### 3. Attach annotations

```java
@CustomView
public class MyCustomView extends EditText {

    @StringAttr("custom_text")
    protected String text;

    public MyCustomView(Context context) {
        super(context);
    }
    
    @Attribute
    protected void setCustomAttr(@ColorAttr("custom_color") int color) {
        this.setTextColor(color);
    }
}
```

### 4. Delegate to generated class

```java
    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        MyCustomViewAttribute.init(this, attrs);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        MyCustomViewAttribute.init(this, attrs);
    }
```

## Note

- The name of the custom view and the name of the declare-styleable should be the same
- The parameters of the method with @Attribute must be annotated with

## Installation
To add it to your project, include the following in your `build.gradle` file:

```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```  

And on your **app module** `build.gradle`:

```groovy
  provided 'com.github.pavel163.AttributesDispatcher:library:1.0.0-alpha1'
  annotationProcessor 'com.github.pavel163.AttributesDispatcher:compiler:1.0.0-alpha1'
```

## Licence

    Copyright 2016 Ergashev Bakht.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

