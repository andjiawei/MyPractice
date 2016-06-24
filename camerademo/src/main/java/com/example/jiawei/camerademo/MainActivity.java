package com.example.jiawei.camerademo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final int TAKE_PHOTO_REQUEST_CODE = 1;
    private Button camera;
    private Button photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera = (Button) findViewById(R.id.camera);
        photo = (Button) findViewById(R.id.photo);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camera();
            }
        });

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void camera() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 指定存储照片的路径
        Uri imageUri = Uri.fromFile(getTempImage());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, TAKE_PHOTO_REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((resultCode == RESULT_OK)) {
            switch (requestCode) {
                case TAKE_PHOTO_REQUEST_CODE: // 拍照后进行裁剪
                    Uri uri = Uri.fromFile(new File(this.camera_fileName));
                    startPhotoZoom(uri);
                    break;
                case AppFinal.RESULT_CODE_PHOTO_PICKED: // 从本地选择图片后
                    if (data != null) {
                        String filePath = AppFinal.getPath(this, data.getData());
                        Uri uri1 = Uri.fromFile(new File(filePath));
                        this.startPhotoZoom(uri1);
                        // this.startPhotoZoom(data.getData());
                    }

                    break;
                case AppFinal.RESULT_CODE_PHOTO_CUT: // 裁剪后

                    // 将Uri图片转换为Bitmap
                    Bitmap bitmap = null;
                    try {
                        bitmap = BitmapFactory.decodeStream(getContentResolver()
                                .openInputStream(uritempFile));
                        // TODO，将裁剪的bitmap显示在imageview控件上
                        Drawable dr = new BitmapDrawable(bitmap);
                        // SendUserPhoto(imgName, dr);
                        // test
                        bitmap = UiUtil.getCroppedRoundBitmap(bitmap, 40);// 设置圆形图片
                        img_photo.setImageBitmap(bitmap);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    public static File getTempImage() {
        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED)) {
            File tempFile = new File(Environment.getExternalStorageDirectory(), "temp.jpg");
            try {
                tempFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return tempFile;
        }
        return null;
    }

    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, AppFinal.IMAGE_UNSPECIFIED);
        Log.d("Uri:", "" + uri);
        intent.putExtra("crop", "true");
        // intent.putExtra("noFaceDetection", true);
        // 宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪图片宽高
        intent.putExtra("outputX", 400);
        intent.putExtra("outputY", 400);
        // intent.putExtra("scale", true);
        // intent.putExtra("return-data", true);
        // this.startActivityForResult(intent, AppFinal.RESULT_CODE_PHOTO_CUT);

        /**
         * 此方法返回的图片只能是小图片（sumsang测试为高宽160px的图片）
         * 故将图片保存在Uri中，调用时将Uri转换为Bitmap，此方法还可解决miui系统不能return data的问题
         */
        // intent.putExtra("return-data", true);

        // uritempFile为Uri类变量，实例化uritempFile
        imgName = System.currentTimeMillis() + ".jpg";
        uritempFile = Uri.parse("file://" + "/"
                + AppFinal.CACHE_DIR_UPLOADING_IMG + "/" + imgName);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uritempFile);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());

        startActivityForResult(intent, AppFinal.RESULT_CODE_PHOTO_CUT);
    }


}
