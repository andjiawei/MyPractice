package com.example.jiawei.picassodemo;

import android.os.Bundle;
import android.widget.ListView;

import com.example.jiawei.picassodemo.adapter.MyAdapter;
import com.example.jiawei.picassodemo.bean.BaseBean;
import com.example.jiawei.picassodemo.nohttp.HttpListener;
import com.example.jiawei.picassodemo.nohttp.NohttpHelper;
import com.example.jiawei.picassodemo.utils.CacheManager;
import com.google.gson.Gson;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import java.util.List;

public class MainActivity extends BaseActivity {

    private String url="http://www.xiuyuewang.com/selection.action";
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);



        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.POST);
        if (request != null) {
            request.add("GoodsTypeoneID", 0 + "");
                // 二级分类 类目Id 如果不需要就传0 。 需要的话从1 开始
                request.add("GoodsTypeTwoId", 0 + "");
                // 默认不选 。 （ 给个-1就行了 ）
                request.add("PriceIncerase", -1 + "");
                request.add("Newest", 0 + ""); // 最新
                request.add("LowPrice", 0 + ""); // 最低价格
                request.add("HightPrice", 0 + ""); // 最高价格
                request.add("sourceId", 0 + "") ;// 来源（0全部1淘宝2天猫）
                request.add("goodsName", 0 + "") ;// 搜索标题
                request.add("pageSize", 8 + ""); // 每页个数
                request.add("pageNo", 1+ ""); // 第几页
            NohttpHelper.getRequestInstance().add(this, 0, request, httpListener, true, true);
        }
    }

    //请求的监听 如get post
    private HttpListener<String> httpListener = new HttpListener<String>() {

        @Override
        public void onSucceed(int what, Response<String> response) {
            int responseCode = response.getHeaders().getResponseCode();// 服务器响应码
            if (responseCode == 200) {
                if (RequestMethod.HEAD == response.getRequestMethod()) {// 请求方法为HEAD时没有响应内容
                    showMessageDialog("请求成功", "head无响应");
                }else {
//                    showMessageDialog("请求成功", response.get());
                    String s = response.get();
                    Gson gson=new Gson();
                    BaseBean baseBean = gson.fromJson(s, BaseBean.class);
                    CacheManager.saveObject(MainActivity.this,baseBean,"baseBean");
                    List<BaseBean.DataBean.ListBean> list = baseBean.getData().getList();
                    MyAdapter myAdapter=new MyAdapter(MainActivity.this,list);
                    listView.setAdapter(myAdapter);
                }
            }
        }

        @Override
        public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
//            showMessageDialog("请求失败", exception.getMessage());
            BaseBean baseBean = (BaseBean) CacheManager.readObject(MainActivity.this, "baseBean");
            if(baseBean!=null){
                List<BaseBean.DataBean.ListBean> list = baseBean.getData().getList();
                MyAdapter myAdapter=new MyAdapter(MainActivity.this,list);
                listView.setAdapter(myAdapter);
            }

        }
    };
}
