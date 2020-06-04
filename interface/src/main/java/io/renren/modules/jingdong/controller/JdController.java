package io.renren.modules.jingdong.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import io.renren.common.utils.R;

import io.renren.modules.generator.entity.KZsActivityEntity;
import io.renren.modules.generator.entity.KZsGoodsEntity;
import io.renren.modules.generator.entity.KZsOrderPayEntity;
import io.renren.modules.generator.entity.KZsSellerEntity;
import io.renren.modules.generator.service.KZsActivityService;
import io.renren.modules.generator.service.KZsGoodsService;
import io.renren.modules.generator.service.KZsOrderPayService;
import io.renren.modules.generator.service.KZsSellerService;
import jd.union.open.goods.promotiongoodsinfo.query.request.UnionOpenGoodsPromotiongoodsinfoQueryRequest;
import jd.union.open.goods.promotiongoodsinfo.query.response.PromotionGoodsResp;
import jd.union.open.goods.promotiongoodsinfo.query.response.UnionOpenGoodsPromotiongoodsinfoQueryResponse;
import jd.union.open.order.query.request.OrderReq;
import jd.union.open.order.query.request.UnionOpenOrderQueryRequest;
import jd.union.open.order.query.response.OrderResp;
import jd.union.open.order.query.response.SkuInfo;
import jd.union.open.order.query.response.UnionOpenOrderQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.keyvalue.core.QueryEngine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("jDController")
public class JdController {


    @Autowired
    private KZsActivityService actService;
    @Autowired
    private KZsOrderPayService orderPayService;
    @Autowired
    private KZsGoodsService goodsService;
    @Autowired
    private KZsSellerService sellerService;


    private String SERVER_URL = "https://router.jd.com/api";
    private String accessToken = "";
    private String appKey = "151b85409d7c3e0523ee5558cc301109";
    private String appSecret="4bec22df162640acab0b4cbe27514cfd";




    @RequestMapping("/getProductInfo")
    public R getProductInfo(@RequestParam Map<String, Object> params) throws JdException {
        String url = String.valueOf(params.get("url"));
        /*Map<String, Objects>paramsMap = UrlToMapUtil.getUrlParams(url);
        String id = String.valueOf(paramsMap.get("id"));*/
        //判断该链接中是否含有前面一段
        if(url.contains("https://item.jd.com/") && url.contains(".html")){
            int startIndex = url.indexOf("https://item.jd.com/")+20;
            int endIndex  = url.indexOf(".html");
            String str = url.substring(startIndex,endIndex);
            if(str.isEmpty()){
                return R.error("请输入正确的商品链接");
            }

            JdClient client=new DefaultJdClient(SERVER_URL,accessToken,appKey,appSecret);
            UnionOpenGoodsPromotiongoodsinfoQueryRequest request=new UnionOpenGoodsPromotiongoodsinfoQueryRequest();
            request.setSkuIds(str);
            UnionOpenGoodsPromotiongoodsinfoQueryResponse response=client.execute(request);
            PromotionGoodsResp[] data = response.getData();
            System.out.println(data.length);
            if(0 == data.length || null ==data){
                return R.error("未找到对应商品");
            }
            PromotionGoodsResp resp = data[0];
            return R.ok().put("data",resp);
        }else{
            return R.error("请输入正确的商品链接");
        }
    }




    @RequestMapping("/getOrder")
    public R getOrder(@RequestParam Map<String, Object> params) throws JdException {
        return R.ok();
    }


    public void operationData(String time) throws JdException, ParseException {

        JdClient client=new DefaultJdClient(SERVER_URL,accessToken,appKey,appSecret);
        UnionOpenOrderQueryRequest request=new UnionOpenOrderQueryRequest();
        OrderReq orderReq=new OrderReq();
        orderReq.setPageSize(1000);
        orderReq.setPageNo(1);
        orderReq.setType(1);
        orderReq.setTime(time);

        request.setOrderReq(orderReq);
        UnionOpenOrderQueryResponse response=client.execute(request);
        OrderResp[] data = response.getData();
        if(null == data){
            return;
        }
        for (int i = 0; i < data.length; i++) {
            OrderResp resp = data[i];
            String finishTime = String.valueOf(resp.getFinishTime());
            String orderEmt = String.valueOf(resp.getOrderEmt());
            String orderId = String.valueOf(resp.getOrderId());
            String orderTime = String.valueOf(resp.getOrderTime());
            String parentId = String.valueOf(resp.getParentId());
            String payMonth = resp.getPayMonth();
            String plus = String.valueOf(resp.getPlus());
            String popId = String.valueOf(resp.getPopId());
            String unionId = String.valueOf(resp.getUnionId());
            String validCode = String.valueOf(resp.getValidCode());

            SkuInfo[]skuArray =  resp.getSkuList();

            String skuIds = "";
            if(skuArray.length != 0 ){
                for (int j = 0; j < skuArray.length; j++) {
                    SkuInfo skuEntity = skuArray[j];

                    String skuValidCode = String.valueOf(skuEntity.getValidCode());
                    String actualCosPrice = String.valueOf(skuEntity.getActualCosPrice());
                    String actualFee = String.valueOf(skuEntity.getActualFee());
                    String cid1 = String.valueOf(skuEntity.getCid1());
                    String cid2 = String.valueOf(skuEntity.getCid2());
                    String cid3 = String.valueOf(skuEntity.getCid3());
                    String commissionRate = String.valueOf(skuEntity.getCommissionRate());
                    String cpActid = String.valueOf(skuEntity.getCpActId());
                    String estimateCosPrice = String.valueOf(skuEntity.getEstimateCosPrice());
                    String estimateFee = String.valueOf(skuEntity.getEstimateFee());
                    String finalRate =String.valueOf(skuEntity.getFinalRate());
                    String skuId = String.valueOf(skuEntity.getSkuId());
                    String skuName = skuEntity.getSkuName();
                    String skuNum = String.valueOf(skuEntity.getSkuNum());
                    String skuReturnNum = String.valueOf(skuEntity.getSkuReturnNum());
                    String price = String.valueOf(skuEntity.getPrice());
                    String subSideRate = String.valueOf(skuEntity.getSubSideRate());
                    String subsidyRate = String.valueOf(skuEntity.getSubsidyRate());
                    String frozenSkuNum = String.valueOf(skuEntity.getFrozenSkuNum());

                    //从这里开始是商品赋值的逻辑
                    //获取到skuid
                    //调用一次京东商品查询接口，获取到所有的商品信息集合。然后进入新增还是修改的逻辑
                    Integer addMid = 0;
                    PromotionGoodsResp[]goods = findTaoBaoSkuInfo(skuId);
                    if(null != goods && 0 != goods.length)
                    {
                        addMid = addOrUpdate(goods);
                    }

                    //这个地方开始赋值。然后入库
                    KZsOrderPayEntity entity = new KZsOrderPayEntity();
                    entity.setMid(addMid);
                    entity.setActualcosprice(actualCosPrice);
                    entity.setActualfee(actualFee);
                    entity.setCid1(cid1);
                    entity.setCid2(cid2);
                    entity.setCid3(cid3);
                    entity.setCommissionrate(commissionRate);
                    entity.setCreateTime(new Date());
                    entity.setEstimatecosprice(estimateCosPrice);
                    entity.setEstimatefee(estimateFee);
                    entity.setFinalrate(finalRate);
                    entity.setFrozenskunum(frozenSkuNum);
                    entity.setSubsiderate(subSideRate);
                    entity.setSubsidyrate(subsidyRate);
                    entity.setYugu_money(estimateCosPrice);

                    entity.setSkuname(skuName);
                    entity.setSkunum(skuNum);
                    entity.setSkureturnnum(skuReturnNum);
                    entity.setValidcode(validCode);
                    entity.setOrderNo(orderId);


                    if(skuValidCode.equals("18")){
                        entity.setIsPay(1);
                        entity.setIsSettle(1);
                    }else{
                        entity.setIsPay(1);
                        entity.setIsSettle(0);
                    }
                    entity.setPrice(new BigDecimal(price));
                    entity.setNum(Integer.valueOf(skuNum));
                    entity.setPopid(popId);
                    //京东的活动id和商品id
                    entity.setTaobao_act_id(cpActid);
                    //连表查询一下看是否在我们这边的商品表和活动表存在。如果存在则设置字段值。如果不存在则不设置值
                    QueryWrapper actWrapper = new QueryWrapper();
                    actWrapper.eq("taobao_act_id",cpActid);
                    List<KZsActivityEntity>actList = actService.list(actWrapper);
                    if(actList.size() != 0){
                        KZsActivityEntity actEntity = actList.get(0);
                        String id = String.valueOf(actEntity.getId());
                        entity.setActivityId(Integer.parseInt(id));
                    }else{
                        entity.setActivityId(0);
                    }

                    entity.setSkuid(skuId);
                    entity.setSkuname(skuName);
                    QueryWrapper skuWrapper = new QueryWrapper();
                    skuWrapper.eq("skuId",skuId);
                    List<KZsGoodsEntity>goodList = goodsService.list(skuWrapper);
                    if(goodList.size() != 0){
                        KZsGoodsEntity goodsEntity = goodList.get(0);
                        String id = String.valueOf(goodsEntity.getId());
                        entity.setGoodsId(Integer.parseInt(id));
                    }else{
                        entity.setGoodsId(0);
                    }
                    if(finishTime != null & !finishTime.equals("0")){
                        entity.setFinishTime(castDate(finishTime));
                    }else{
                        entity.setFinishTime(null);
                    }
                    if(orderTime != null & !orderTime.equals("0")){
                        entity.setOrderTime(castDate(orderTime));
                    }else{
                        entity.setOrderTime(null);
                    }
                    if(payMonth != null & !payMonth.equals("0")){
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = simpleDateFormat.parse(payMonth);
                        entity.setPayMonth(simpleDateFormat1.parse(simpleDateFormat1.format(date)));
                    }else{
                        entity.setPayMonth(null);
                    }

                    //在入库之前，先查询库里是否存在相同订单，相同商品id，相同活动
                    //如果存在则做update操作，如果不存在则做新增操作
                    QueryWrapper updateWp = new QueryWrapper();
                    updateWp.eq("order_no",orderId);
                    List<KZsOrderPayEntity>updateList = orderPayService.list(updateWp);
                    if(updateList.size() !=0){
                        KZsOrderPayEntity update = updateList.get(0);
                        entity.setId(update.getId());
                        orderPayService.updateById(entity);
                    }else{
                        orderPayService.save(entity);
                    }


                }
            }
        }

    }




    @RequestMapping("/getoldOrder")
    public R getoldOrder(@RequestParam Map<String, Object> params) throws JdException, ParseException {
        String startTime = String.valueOf(params.get("startTime"));
        String endTime = String.valueOf(params.get("endTime"));

        //遍历时间。获取某段时间（按天）的每一个小时的订单数据
        List<String> everyHour = getTwoDaysDay(startTime, endTime);
        //传入时间开始查询并且做入库处理
        String time = "";
        for (int i = 0; i < everyHour.size(); i++) {
            time = everyHour.get(i);
            operationData(time);
        }
        return R.ok();
    }



    //取一段时间的每一天
    public  List<String> getTwoDaysDay(String dateStart, String dateEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        List<String> dateList = new ArrayList<String>();
        try{
            Date dateOne = sdf.parse(dateStart);
            Date dateTwo = sdf.parse(dateEnd);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateTwo);

            //dateList.add(dateEnd);
            while(calendar.getTime().after(dateOne)){ //倒序时间,顺序after改before其他相应的改动。
                calendar.add(Calendar.DAY_OF_MONTH, -1);

                //dateList.add(sdf.format(calendar.getTime()));
                String dateTime = sdf.format(calendar.getTime());
                for (int i = 0; i < 25; i++) {
                    String hour = "";
                    if(i<10){
                        hour = "0"+String.valueOf(i);
                    }else{
                        hour = String.valueOf(i);
                    }
                    String everyHour = dateTime+hour;
                    dateList.add(everyHour);
                }

            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return dateList;
    }


    //将毫秒数转成date
    public Date castDate(String time) throws ParseException {
        long timeLong = Long.valueOf(time);
        String df1="yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(new SimpleDateFormat(df1).format(timeLong));
    }

    //将毫秒数转成date
    public Date castDate(long time) throws ParseException {
        long timeLong = Long.valueOf(time);
        String df1="yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(new SimpleDateFormat(df1).format(timeLong));
    }



    public  PromotionGoodsResp[]findTaoBaoSkuInfo(String skuIds) throws JdException {

        JdClient client=new DefaultJdClient(SERVER_URL,accessToken,appKey,appSecret);
        UnionOpenGoodsPromotiongoodsinfoQueryRequest request=new UnionOpenGoodsPromotiongoodsinfoQueryRequest();
        request.setSkuIds(skuIds);
        UnionOpenGoodsPromotiongoodsinfoQueryResponse response=client.execute(request);
        PromotionGoodsResp[] data = response.getData();
        if(null ==data || 0 == data.length){
            return null;
        }
        return data;
    }



    //遍历商品数组
    //开始赋值
    //查询商品是否在商品表中存在，如果存在则update，如果不存在则add
    public Integer addOrUpdate(PromotionGoodsResp[]goodsResps) throws ParseException {
        Integer addMid = 0;

        for (int i = 0; i < goodsResps.length; i++) {
            PromotionGoodsResp good = goodsResps[i];

            KZsGoodsEntity entity = new KZsGoodsEntity();
            entity.setGoodsUrl(good.getMaterialUrl());
            entity.setLogoImg(good.getImgUrl());
            entity.setTitle(good.getGoodsName());
            entity.setPrice(new BigDecimal(good.getUnitPrice()));

            //Mid需要去查询店铺表，如果查询到了就赋值。如果没有的话就不赋值
            entity.setCreateTime(new Date());
            entity.setUpdateTime(new Date());
            entity.setSkuid(String.valueOf(good.getSkuId()));
            entity.setUnitprice(new BigDecimal(good.getUnitPrice()));
            entity.setMaterialurl(good.getImgUrl());

            entity.setIsfreefreightrisk(good.getIsFreeFreightRisk());
            entity.setIsfreeshipping(good.getIsFreeShipping());
            entity.setCommisionratiowl(new BigDecimal(good.getCommisionRatioWl()));
            entity.setCommisionratiopc(new BigDecimal(good.getCommisionRatioPc()));
            entity.setImgurl(good.getImgUrl());
            entity.setVid(good.getVid().intValue());
            entity.setCidname(good.getCidName());
            entity.setCid(good.getCid().intValue());
            entity.setCid2(good.getCid2().intValue());
            entity.setCid2name(good.getCid2Name());
            entity.setCid3(good.getCid3().intValue());
            entity.setCid3name(good.getCid3Name());
            entity.setWlunitprice(new BigDecimal(good.getWlUnitPrice()));
            entity.setIsseckill(good.getIsSeckill());
            entity.setInordercount(good.getInOrderCount().intValue());
            entity.setShopid(good.getShopId().intValue());
            entity.setIsjdsale(good.getIsJdSale());
            entity.setGoodsname(good.getGoodsName());


            entity.setStartdate(castDate(good.getStartDate()));
            entity.setEnddate(castDate(good.getEndDate()));


            String skuId = String.valueOf(good.getSkuId());
            QueryWrapper qw = new QueryWrapper();
            qw.eq("skuId",skuId);
            List<KZsGoodsEntity>list = goodsService.list(qw);

            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("shopId",entity.getShopid());
            List<KZsSellerEntity>sellerList = sellerService.list(queryWrapper);
            if(sellerList != null && sellerList.size()!=0){
                KZsSellerEntity sellerEntity = sellerList.get(0);
                entity.setMid(sellerEntity.getMid());
                addMid = sellerEntity.getMid();
            }
            if(list != null && list.size()!=0){
                KZsGoodsEntity findEntity = list.get(0);
                entity.setId(findEntity.getId());
                entity.setUpdateTime(new Date());
                KZsGoodsEntity fingGodsEntity = list.get(0);
                BigDecimal oldWl = fingGodsEntity.getCommisionratiowl();
                DecimalFormat df2 =new DecimalFormat("#.00");
                BigDecimal newWl = entity.getCommisionratiowl();


                // 四舍五入
                BigDecimal value = new BigDecimal(newWl.toString()).setScale(2,BigDecimal.ROUND_HALF_UP);
                // 不足两位小数补0
                DecimalFormat decimalFormat = new DecimalFormat("0.00#");
                BigDecimal newWlBig = new BigDecimal(decimalFormat.format(value));


                if(oldWl.compareTo(newWlBig) != 0 ){
                    entity.setCommisionratiowl(null);
                    entity.setState(2);
                }
                entity.setCommissionratenow(newWlBig);
                goodsService.updateById(entity);
            }else{
                entity.setCommissionratenow(new BigDecimal(good.getCommisionRatioWl()));
                goodsService.save(entity);
            }
        }

        return addMid;
    }





}
