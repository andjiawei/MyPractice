package com.example.jiawei.picassodemo.nohttp;


import com.example.jiawei.picassodemo.BaseActivity;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.download.DownloadQueue;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;

public class NohttpHelper {

    private static final String TAG = "NohttpHelper";
    private static NohttpHelper callServer;
    private RequestQueue requestQueue;

    private NohttpHelper() {
        requestQueue = NoHttp.newRequestQueue();
    }

    public synchronized static NohttpHelper getRequestInstance() {
        if (callServer == null)
            callServer = new NohttpHelper();
        return callServer;
    }

    private static DownloadQueue downloadQueue;

    public static DownloadQueue getDownloadInstance() {
        if (downloadQueue == null)
            downloadQueue = NoHttp.newDownloadQueue(2);//同时下载数默认是3个
        return downloadQueue;
    }
    /**
     * 取消这个sign标记的所有请求.
     */
    public void cancelBySign(Object sign) {
        requestQueue.cancelBySign(sign);
    }

    /**
     * 取消队列中所有请求.
     */
    public void cancelAll() {
        requestQueue.cancelAll();
    }

    /**
     * 退出app时停止所有请求.
     */
    public void stopAll() {
        requestQueue.stop();
    }

    /**
     * 添加一个请求到请求队列.
     *  @param context   context用来实例化dialog.
     * @param what      用来标志请求, 当多个请求使用同一个{@link HttpListener}时, 在回调方法中会返回这个what.
     * @param request   请求对象.
     * @param callback  结果回调对象.
     * @param canCancel 是否允许用户取消请求.
     * @param isLoading 是否显示dialog.
     */
    public <T> void add(BaseActivity context, int what, Request<T> request, HttpListener<T> callback, boolean canCancel, boolean isLoading) {
        requestQueue.add(what, request, new HttpResponseListener<T>(context, request,  callback, canCancel, isLoading));
    }

}
