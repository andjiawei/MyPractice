#  解决输入法挡住界面UI的demo

    用的RelativeLayout 没用LinearLayout的 weight
    
## 使用步骤
    

    1 AndroidManifest.xml 中在对应activity 中增加 android:windowSoftInputMode="adjustResize"
    2 把自定义的 InputMethodRelativeLayout 复制进来，只可继承RelativeLayout 
    3 在mainActivity 中设置监听 InputMethodRelativeLayout.setOnSizeChangedListenner 
      重写onSizeChanged 方法 写需要隐藏的view和显示的view
      