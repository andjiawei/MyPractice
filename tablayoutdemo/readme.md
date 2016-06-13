##layoutdemo

第一次搞 图片太大了

    实验超大图标和不同dpi下 图片适配应该没问题。
    看源码后发现 系统写死的值
    android:layout_width="32dip"
    android:layout_height="32dip"

第一步

    compile 'com.android.support:design:23.4.0'

第二部在布局中引用 然后在代码中设置、

    照着代码抄就行了


![image](https://github.com/androidjiawei/MyPractice/blob/master/tablayoutdemo/screenshot/firststyle.png)
![image](https://github.com/androidjiawei/MyPractice/blob/master/tablayoutdemo/screenshot/havetext.png)
![image](https://github.com/androidjiawei/MyPractice/blob/master/tablayoutdemo/screenshot/no text.png)
![image](https://github.com/androidjiawei/MyPractice/blob/master/tablayoutdemo/screenshot/selecetor.png)