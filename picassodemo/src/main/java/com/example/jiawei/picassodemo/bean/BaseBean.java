package com.example.jiawei.picassodemo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by QYer on 2016/7/15.
 */
public class BaseBean implements Serializable {


    /**
     * msg : 获取商品信息成功
     * code : 0
     * data : {"limit":120,"list":[{"evaluates":[],"goodsId":1821,"goodsName":"【买2送1】宝宝腹卷肚兜婴幼儿童肚围纯棉加厚弹力护肚","goodsPrice":9.9,"goodsimages":[],"goodstypeonerelations":[],"goodstypeones":[],"goodstypetwos":[],"monsales":23595,"photoUrl":"http://img03.taobaocdn.com/bao/uploaded/i3/TB1w126KpXXXXcRXXXXXXXXXXXX_!!0-item_pic.jpg","sourceId":1,"unitCost":12,"weblinkurl":"http://s.click.taobao.com/ESxdJWx","zhekou":8.25},{"evaluates":[],"goodsId":1822,"goodsName":"【买6送1_擀面皮280g】陕西西安凉皮小吃 宝鸡岐山特产 方便食品","goodsPrice":3.88,"goodsimages":[],"goodstypeonerelations":[],"goodstypeones":[],"goodstypetwos":[],"monsales":2683,"photoUrl":"http://img02.taobaocdn.com/bao/uploaded/i2/1760889373/TB28FbuoFXXXXc5XXXXXXXXXXXX_!!1760889373.jpg","sourceId":1,"unitCost":6,"weblinkurl":"http://s.click.taobao.com/2xwdJWx","zhekou":6.689655172413794},{"evaluates":[],"goodsId":1823,"goodsName":"0-1-3 4个月岁婴儿宝宝男女儿童船袜子纯可爱棉夏季透气地板防滑","goodsPrice":3.5,"goodsimages":[],"goodstypeonerelations":[],"goodstypeones":[],"goodstypetwos":[],"monsales":52972,"photoUrl":"http://img04.taobaocdn.com/bao/uploaded/i4/1782277066/TB2sq5GoVXXXXXXXpXXXXXXXXXX_!!1782277066.jpg","sourceId":1,"unitCost":3,"weblinkurl":"http://s.click.taobao.com/q4sdJWx","zhekou":10},{"evaluates":[],"goodsId":1824,"goodsName":"0pp0a53m手机钢化膜oppoa31刚化玻璃模opopa33屏保前贴oppa51防爆","goodsPrice":3.9,"goodsimages":[],"goodstypeonerelations":[],"goodstypeones":[],"goodstypetwos":[],"monsales":87,"photoUrl":"http://img01.taobaocdn.com/bao/uploaded/i1/2778954272/TB2N6jJjVXXXXc_XXXXXXXXXXXX_!!2778954272.jpg","sourceId":1,"unitCost":10,"weblinkurl":"http://s.click.taobao.com/geBYJWx","zhekou":3.9000000000000004},{"evaluates":[],"goodsId":1825,"goodsName":"1.8m床上夏季1.5床单人三件套宿舍2.0双人卡通学生条纹被套四件套","goodsPrice":38.22,"goodsimages":[],"goodstypeonerelations":[],"goodstypeones":[],"goodstypetwos":[],"monsales":5633,"photoUrl":"http://img04.taobaocdn.com/bao/uploaded/i4/393522915/TB2.AT8lFXXXXb8XpXXXXXXXXXX_!!393522915.jpg","sourceId":1,"unitCost":147,"weblinkurl":"http://s.click.taobao.com/UyDYJWx","zhekou":2.6},{"evaluates":[],"goodsId":1826,"goodsName":"16春夏运动乐福帆布鞋女鞋韩版小白鞋板鞋厚底懒人鞋女平底学生鞋","goodsPrice":15.9,"goodsimages":[],"goodstypeonerelations":[],"goodstypeones":[],"goodstypetwos":[],"monsales":16321,"photoUrl":"http://img01.taobaocdn.com/bao/uploaded/i1/2213245910/TB2l_rsjVXXXXXdXpXXXXXXXXXX_!!2213245910.jpg","sourceId":1,"unitCost":128,"weblinkurl":"http://s.click.taobao.com/m5tdJWx","zhekou":1.2421875},{"evaluates":[],"goodsId":1827,"goodsName":"16寸木质DIY相册手工情侣宝宝粘贴式影集本拍立得创意礼物纪念册","goodsPrice":16.8,"goodsimages":[],"goodstypeonerelations":[],"goodstypeones":[],"goodstypetwos":[],"monsales":9611,"photoUrl":"http://img04.taobaocdn.com/bao/uploaded/i4/TB1c7tuLpXXXXcaXFXXXXXXXXXX_!!0-item_pic.jpg","sourceId":2,"unitCost":128,"weblinkurl":"http://s.click.taobao.com/plGYJWx","zhekou":1.3125},{"evaluates":[],"goodsId":1828,"goodsName":"16夏装新品童装中小男女童纯棉竹节棉圆领短袖潮T恤特价","goodsPrice":12.8,"goodsimages":[],"goodstypeonerelations":[],"goodstypeones":[],"goodstypetwos":[],"monsales":33698,"photoUrl":"http://img02.taobaocdn.com/bao/uploaded/i2/TB12QkpJFXXXXaqXpXXXXXXXXXX_!!0-item_pic.jpg","sourceId":1,"unitCost":28,"weblinkurl":"http://s.click.taobao.com/ebtdJWx","zhekou":4.571428571428572}],"page":1,"totalCount":0,"totalPage":0}
     */

    private String msg;
    private int code;
    /**
     * limit : 120
     * list : [{"evaluates":[],"goodsId":1821,"goodsName":"【买2送1】宝宝腹卷肚兜婴幼儿童肚围纯棉加厚弹力护肚","goodsPrice":9.9,"goodsimages":[],"goodstypeonerelations":[],"goodstypeones":[],"goodstypetwos":[],"monsales":23595,"photoUrl":"http://img03.taobaocdn.com/bao/uploaded/i3/TB1w126KpXXXXcRXXXXXXXXXXXX_!!0-item_pic.jpg","sourceId":1,"unitCost":12,"weblinkurl":"http://s.click.taobao.com/ESxdJWx","zhekou":8.25},{"evaluates":[],"goodsId":1822,"goodsName":"【买6送1_擀面皮280g】陕西西安凉皮小吃 宝鸡岐山特产 方便食品","goodsPrice":3.88,"goodsimages":[],"goodstypeonerelations":[],"goodstypeones":[],"goodstypetwos":[],"monsales":2683,"photoUrl":"http://img02.taobaocdn.com/bao/uploaded/i2/1760889373/TB28FbuoFXXXXc5XXXXXXXXXXXX_!!1760889373.jpg","sourceId":1,"unitCost":6,"weblinkurl":"http://s.click.taobao.com/2xwdJWx","zhekou":6.689655172413794},{"evaluates":[],"goodsId":1823,"goodsName":"0-1-3 4个月岁婴儿宝宝男女儿童船袜子纯可爱棉夏季透气地板防滑","goodsPrice":3.5,"goodsimages":[],"goodstypeonerelations":[],"goodstypeones":[],"goodstypetwos":[],"monsales":52972,"photoUrl":"http://img04.taobaocdn.com/bao/uploaded/i4/1782277066/TB2sq5GoVXXXXXXXpXXXXXXXXXX_!!1782277066.jpg","sourceId":1,"unitCost":3,"weblinkurl":"http://s.click.taobao.com/q4sdJWx","zhekou":10},{"evaluates":[],"goodsId":1824,"goodsName":"0pp0a53m手机钢化膜oppoa31刚化玻璃模opopa33屏保前贴oppa51防爆","goodsPrice":3.9,"goodsimages":[],"goodstypeonerelations":[],"goodstypeones":[],"goodstypetwos":[],"monsales":87,"photoUrl":"http://img01.taobaocdn.com/bao/uploaded/i1/2778954272/TB2N6jJjVXXXXc_XXXXXXXXXXXX_!!2778954272.jpg","sourceId":1,"unitCost":10,"weblinkurl":"http://s.click.taobao.com/geBYJWx","zhekou":3.9000000000000004},{"evaluates":[],"goodsId":1825,"goodsName":"1.8m床上夏季1.5床单人三件套宿舍2.0双人卡通学生条纹被套四件套","goodsPrice":38.22,"goodsimages":[],"goodstypeonerelations":[],"goodstypeones":[],"goodstypetwos":[],"monsales":5633,"photoUrl":"http://img04.taobaocdn.com/bao/uploaded/i4/393522915/TB2.AT8lFXXXXb8XpXXXXXXXXXX_!!393522915.jpg","sourceId":1,"unitCost":147,"weblinkurl":"http://s.click.taobao.com/UyDYJWx","zhekou":2.6},{"evaluates":[],"goodsId":1826,"goodsName":"16春夏运动乐福帆布鞋女鞋韩版小白鞋板鞋厚底懒人鞋女平底学生鞋","goodsPrice":15.9,"goodsimages":[],"goodstypeonerelations":[],"goodstypeones":[],"goodstypetwos":[],"monsales":16321,"photoUrl":"http://img01.taobaocdn.com/bao/uploaded/i1/2213245910/TB2l_rsjVXXXXXdXpXXXXXXXXXX_!!2213245910.jpg","sourceId":1,"unitCost":128,"weblinkurl":"http://s.click.taobao.com/m5tdJWx","zhekou":1.2421875},{"evaluates":[],"goodsId":1827,"goodsName":"16寸木质DIY相册手工情侣宝宝粘贴式影集本拍立得创意礼物纪念册","goodsPrice":16.8,"goodsimages":[],"goodstypeonerelations":[],"goodstypeones":[],"goodstypetwos":[],"monsales":9611,"photoUrl":"http://img04.taobaocdn.com/bao/uploaded/i4/TB1c7tuLpXXXXcaXFXXXXXXXXXX_!!0-item_pic.jpg","sourceId":2,"unitCost":128,"weblinkurl":"http://s.click.taobao.com/plGYJWx","zhekou":1.3125},{"evaluates":[],"goodsId":1828,"goodsName":"16夏装新品童装中小男女童纯棉竹节棉圆领短袖潮T恤特价","goodsPrice":12.8,"goodsimages":[],"goodstypeonerelations":[],"goodstypeones":[],"goodstypetwos":[],"monsales":33698,"photoUrl":"http://img02.taobaocdn.com/bao/uploaded/i2/TB12QkpJFXXXXaqXpXXXXXXXXXX_!!0-item_pic.jpg","sourceId":1,"unitCost":28,"weblinkurl":"http://s.click.taobao.com/ebtdJWx","zhekou":4.571428571428572}]
     * page : 1
     * totalCount : 0
     * totalPage : 0
     */

    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        private int limit;
        private int page;
        private int totalCount;
        private int totalPage;
        /**
         * evaluates : []
         * goodsId : 1821
         * goodsName : 【买2送1】宝宝腹卷肚兜婴幼儿童肚围纯棉加厚弹力护肚
         * goodsPrice : 9.9
         * goodsimages : []
         * goodstypeonerelations : []
         * goodstypeones : []
         * goodstypetwos : []
         * monsales : 23595
         * photoUrl : http://img03.taobaocdn.com/bao/uploaded/i3/TB1w126KpXXXXcRXXXXXXXXXXXX_!!0-item_pic.jpg
         * sourceId : 1
         * unitCost : 12
         * weblinkurl : http://s.click.taobao.com/ESxdJWx
         * zhekou : 8.25
         */

        private List<ListBean> list;

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable{
            private int goodsId;
            private String goodsName;
            private double goodsPrice;
            private int monsales;
            private String photoUrl;
            private int sourceId;
            private int unitCost;
            private String weblinkurl;
            private double zhekou;
            private List<?> evaluates;
            private List<?> goodsimages;
            private List<?> goodstypeonerelations;
            private List<?> goodstypeones;
            private List<?> goodstypetwos;

            public int getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public double getGoodsPrice() {
                return goodsPrice;
            }

            public void setGoodsPrice(double goodsPrice) {
                this.goodsPrice = goodsPrice;
            }

            public int getMonsales() {
                return monsales;
            }

            public void setMonsales(int monsales) {
                this.monsales = monsales;
            }

            public String getPhotoUrl() {
                return photoUrl;
            }

            public void setPhotoUrl(String photoUrl) {
                this.photoUrl = photoUrl;
            }

            public int getSourceId() {
                return sourceId;
            }

            public void setSourceId(int sourceId) {
                this.sourceId = sourceId;
            }

            public int getUnitCost() {
                return unitCost;
            }

            public void setUnitCost(int unitCost) {
                this.unitCost = unitCost;
            }

            public String getWeblinkurl() {
                return weblinkurl;
            }

            public void setWeblinkurl(String weblinkurl) {
                this.weblinkurl = weblinkurl;
            }

            public double getZhekou() {
                return zhekou;
            }

            public void setZhekou(double zhekou) {
                this.zhekou = zhekou;
            }

            public List<?> getEvaluates() {
                return evaluates;
            }

            public void setEvaluates(List<?> evaluates) {
                this.evaluates = evaluates;
            }

            public List<?> getGoodsimages() {
                return goodsimages;
            }

            public void setGoodsimages(List<?> goodsimages) {
                this.goodsimages = goodsimages;
            }

            public List<?> getGoodstypeonerelations() {
                return goodstypeonerelations;
            }

            public void setGoodstypeonerelations(List<?> goodstypeonerelations) {
                this.goodstypeonerelations = goodstypeonerelations;
            }

            public List<?> getGoodstypeones() {
                return goodstypeones;
            }

            public void setGoodstypeones(List<?> goodstypeones) {
                this.goodstypeones = goodstypeones;
            }

            public List<?> getGoodstypetwos() {
                return goodstypetwos;
            }

            public void setGoodstypetwos(List<?> goodstypetwos) {
                this.goodstypetwos = goodstypetwos;
            }
        }
    }
}
