package com.example.jiawei.albumphotodemo;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.example.jiawei.albumphotodemo.utils.BitmapCreate;
import com.example.jiawei.albumphotodemo.utils.FileUtils;
import com.example.jiawei.albumphotodemo.utils.ImageUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    /**
     * 请求相册
     */
    public static final int REQUEST_CODE_GETIMAGE_BYSDCARD = 0;
    private static final int REQUEST_CODE_GETIMAGE_BYCAMERA =1 ;
    private ImageView imageView;
    private String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

    }

    /**
     * 6.0模拟器打开会崩 6.0手机没问题
     * @param view
     */
    public void openAlbum(View view){
        Intent intent;
        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent();
            intent.setAction(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "select 图片"),
                    REQUEST_CODE_GETIMAGE_BYSDCARD);
        } else {
            intent = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "select 图片"),
                    REQUEST_CODE_GETIMAGE_BYSDCARD);
        }
    }

    public void openCamera(View v){
        // 判断是否挂载了SD卡
        String savePath = "";
        String storageState = Environment.getExternalStorageState();
        if (storageState.equals(Environment.MEDIA_MOUNTED)) {
            savePath = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + "/oschina/Camera/";
            File savedir = new File(savePath);
            if (!savedir.exists()) {
                savedir.mkdirs();
            }
        }

        // 没有挂载SD卡，无法保存文件
        if (TextUtils.isEmpty(savePath)) {
//            AppContext.showToastShort("无法保存照片，请检查SD卡是否挂载");
            return;
        }

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = timeStamp + ".jpg";// 照片命名
        File out = new File(savePath, fileName);
        Uri uri = Uri.fromFile(out);

        temp=savePath + fileName; // 该照片的绝对路径

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, REQUEST_CODE_GETIMAGE_BYCAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != Activity.RESULT_OK)
            return;

        if (requestCode == ImageUtils.REQUEST_CODE_GETIMAGE_BYSDCARD) {
            if (data == null)
                return;
            Uri selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                String path = ImageUtils.getImagePath(selectedImageUri, this);
                setImageFromPath(path);
            }
        } else if (requestCode == ImageUtils.REQUEST_CODE_GETIMAGE_BYCAMERA) {
            setImageFromPath(temp);
        }
    }

    /**
     * 根据文件路径上传动弹图片
     *
     * @param path 图片在本地的路径
     */
    private void setImageFromPath(final String path) {
        if (TextUtils.isEmpty(path)) return;
        try {
            Bitmap bitmap = BitmapCreate.bitmapFromStream(
                    new FileInputStream(path), 512, 512);

            setImageFromBitmap(bitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据bitmap上传动弹图片
     *
     * @param bitmap bitmap
     */
    private void setImageFromBitmap(final Bitmap bitmap) {
        if (bitmap == null) return;
        temp = FileUtils.getSDCardPath() + "/OSChina/tempfile.png";
        FileUtils.bitmapToFile(bitmap, temp);
//        tweet.setImageFilePath(temp);

        // 压缩小图片用于界面显示
        Bitmap minBitmap = ImageUtils.zoomBitmap(bitmap, 100, 100);
        // 销毁之前的图片
        bitmap.recycle();

        imageView.setImageBitmap(minBitmap);
    }
}
