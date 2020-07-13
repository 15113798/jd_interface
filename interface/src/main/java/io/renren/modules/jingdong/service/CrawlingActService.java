package io.renren.modules.jingdong.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import io.renren.common.utils.R;
import io.renren.modules.generator.entity.KZsActivityEntity;
import io.renren.modules.generator.entity.KZsGoodsEntity;
import io.renren.modules.generator.entity.KZsJdCookierEntity;
import io.renren.modules.generator.entity.KZsSellerEntity;
import io.renren.modules.generator.service.KZsActivityService;
import io.renren.modules.generator.service.KZsGoodsService;
import io.renren.modules.generator.service.KZsJdCookierService;
import io.renren.modules.generator.service.KZsSellerService;
import jd.union.open.goods.promotiongoodsinfo.query.request.UnionOpenGoodsPromotiongoodsinfoQueryRequest;
import jd.union.open.goods.promotiongoodsinfo.query.response.PromotionGoodsResp;
import jd.union.open.goods.promotiongoodsinfo.query.response.UnionOpenGoodsPromotiongoodsinfoQueryResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class CrawlingActService {

    @Autowired
    private KZsActivityService activityService;
    @Autowired
    private KZsGoodsService goodsService;
    @Autowired
    private KZsSellerService sellerService;
    @Autowired
    private KZsJdCookierService cookierService;


    private String cookie = "";


    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM


    private String SERVER_URL = "https://router.jd.com/api";
    private String accessToken = "";
    private String appKey = "151b85409d7c3e0523ee5558cc301109";
    private String appSecret="4bec22df162640acab0b4cbe27514cfd";

    public void startCrawlingAct() throws IOException, ParseException, JdException {
        //开始爬取的时候先获取下数据库中的cookier状态，如果状态是OK的则开始爬取。如果状态不正常，则直接进入短信发送逻辑
        boolean bool = checkCookier();
        if(bool == false){
            return;
        }

        //每次跑定时器的时候，都要把活动拿完。开始时间为35天之前的数据，结束时间为当前时间
        //总条数在爬取接口的时候也包含了。所以先请求一把接口，单独拿一把总条数
        int totalCount = findActTotalCount();

        if(totalCount != 0){
            //然后拼接成对应的请求去for循环拼接请求
            //totalPage 总页数
            int page = 1;
            if(totalCount%10==0){
                //说明整除，正好每页显示pageSize条数据，没有多余一页要显示少于pageSize条数据的
                page = totalCount / 10;
            }else{
                //不整除，就要在加一页，来显示多余的数据。
                page = totalCount / 10 +1;
            }

            for (int j = 1; j < 10; j++) {
                String urlPath = "https://api.m.jd.com/api?functionId=union_cp&appid=unionpc&_=1594266665523&loginType=3&body={%22funName%22:%22getCpActivityList%22,%22param%22:{%22createTimeStart%22:%22%22,%22createTimeEnd%22:%22%22,%22title%22:%22%22,%22activityId%22:%22%22,%22activityStatus%22:%22%22,%22pageNo%22:"+j+",%22pageSize%22:10}}";
                //String cookie = "pinId=MlLL-4mlsxJDNijXjQc9DA; shshshfpa=6cedb008-4b21-9746-d3bd-ef2098d89a63-1587623390; shshshfpb=qqATehNfX2KLOr%2F2eFZpjlA%3D%3D; unick=yinqiaobing942; _tp=BKP6c7Bs6Y0sUAzYwyZzSw%3D%3D; _pst=yinqiaobing942; user-key=e9a3caa6-88b2-4a6b-bdce-8b31c8791f3d; cn=6; __jdv=209449046|baidu|-|organic|not set|1594265351065; __jdu=15942653510611172806449; areaId=18; ipLoc-djd=18-1482-48936-0; PCSYCityID=CN_430000_430100_430104; shshshfp=0503326902ebb5ca8744bc794f29abee; 3AB9D23F7A4B3C9B=X64X3ZOIAQLDC3YTB7GIINW33GADAWMY2R4COKQHPG7ZXFWESU2R55FL42XGETA4EUDEXJXDZJ74TADDPUL5CQBKFI; sidebarStatus=1; ssid=\\\"D9qt32WIQp67MSTMZq2GrA==\\\"; TrackID=1lYYv2MC1hm2aVF5pPUdHRzB-d7AmJQMga6YD9X-MfxDKjREdgDNwmVNGkGTszsseFpNT2ZsQbV-kipZ2FPYaQMP-q0BJJl37DoY7S-T0dmk; thor=61CE30BAEDFEB924A833A65F520E97D216A7B0FEC2FE004D63DD034CC040D05D948BA3BD8D91A2252CA61161F54F5F5ED4FE54D3F41CF9A2CA9BE70261BE5E0C6768D05B29F30C243C8EAC6993F1608509AD2FA1D7ADA97C29F8AA13B48601BAABB273B77B54FA6AD6A4828B8B8640490A7E4DCD43DFBCEF92E2C525D523C97C49D357960E46C3EC928E878076A50013; pin=yinqiaobing942; ceshi3.com=000; logining=1; __jda=209449046.15942653510611172806449.1594265351.1594289900.1594357996.9; __jdc=209449046; login=true; MNoticeIdyinqiaobing942=293; __jdb=209449046.7.15942653510611172806449|9.1594357996; RT=\\\"z=1&dm=jd.com&si=vgcthauykpn&ss=kcfrl2mn&sl=4&tt=3nf&ld=q5e&nu=6b84f814976156ac6b60f272e8f2714c&cl=oly&ul=129o";
                URL url = new URL(urlPath);
                URLConnection conn = url.openConnection();
                conn.setRequestProperty("Origin", "https://union.jd.com");
                conn.setRequestProperty("Referer", "https://union.jd.com/investment/groupList");
                conn.setRequestProperty("Cookie", cookie);
                conn.setDoInput(true);
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                String repStr = "["+sb+"]";
                JSONArray jSONArray = JSONArray.fromObject(repStr);

                if(0 == jSONArray.size()){
                    System.out.println("没有活动");
                }else{
                    JSONObject data =  ((JSONObject)jSONArray.get(0)).getJSONObject("result");
                    if(null == data ){
                        System.out.println("cookie失效了，请重新获取cookie");
                    }
                    //爬取到活动的列表
                    JSONArray paymentList = data.getJSONArray("result");
                    for (int i =0;i<paymentList.size();i++){
                        JSONObject paymentObject= paymentList.getJSONObject(i);
                        KZsActivityEntity entity = new KZsActivityEntity();

                        if(paymentObject.has("activityStatus")){
                            //活动状态
                            String activityStatus = paymentObject.getString("activityStatus");
                            int activitystatus = Integer.parseInt(activityStatus);
                            entity.setActivitystatus(activitystatus);
                        }
                        if(paymentObject.has("activityId")){
                            //入库活动
                            String activityId = paymentObject.getString("activityId");
                            entity.setTaobaoActId(activityId);
                        }

                        if(paymentObject.has("endTime")){
                            //结束时间
                            String endTime = paymentObject.getString("endTime");
                            Date date = simpleDateFormat.parse(endTime);
                            entity.setEndTime(date);
                        }if(paymentObject.has("startTime")){
                            //开始时间
                            String startTime = paymentObject.getString("startTime");
                            Date date = simpleDateFormat.parse(startTime);
                            entity.setStartTime(date);
                        }
                        if(paymentObject.has("title")){
                            //活动名称
                            String title = paymentObject.getString("title");
                            entity.setActivityTitle(title);
                        }if(paymentObject.has("skuCnt")){
                            String skuCnt = paymentObject.getString("skuCnt");
                            Integer skuC = Integer.parseInt(skuCnt);
                            entity.setSkucnt(skuC);
                        }else{
                            entity.setSkucnt(0);
                        }
                        if(paymentObject.has("estimateFee")){
                            //这个字段不知道是什么意思，先不插入至库中
                            String estimateFee = paymentObject.getString("estimateFee");
                        }
                        if(paymentObject.has("orderCntIn")){
                            //引入订单量
                            String orderCntIn = paymentObject.getString("orderCntIn");
                            Integer orderCnt = Integer.parseInt(orderCntIn);
                            entity.setOrdercntin(orderCnt);
                        }
                        if(paymentObject.has("serviceFee")){
                            //实际服务费
                            String serviceFee = paymentObject.getString("serviceFee");
                            BigDecimal bigFee = new BigDecimal(serviceFee);
                            entity.setServicefee(bigFee);
                        }
                        if(paymentObject.has("ygServiceFee")){
                            //预估服务费
                            String ygServiceFee = paymentObject.getString("ygServiceFee");
                            BigDecimal ygFee = new BigDecimal(ygServiceFee);
                            entity.setYgservicefee(ygFee);
                        }else{
                            entity.setYgservicefee(new BigDecimal(0));
                        }
                        if(paymentObject.has("unionId")){
                            //这个id目前没什么很大的用，先不插入到库中
                            String unionId = paymentObject.getString("unionId");
                        }

                        //先查询一把库，看这个活动库中是否存在了。如果存在则做更新操作。如果不存在则插入
                        QueryWrapper qw = new QueryWrapper();
                        qw.eq("taobao_act_id",entity.getTaobaoActId());
                        List<KZsActivityEntity> list = activityService.list(qw);
                        if(null == list || list.size()==0){
                            activityService.save(entity);
                        }else{
                            KZsActivityEntity f = list.get(0);
                            entity.setId(f.getId());
                            activityService.updateById(entity);
                        }

                        //拿到每一个活动id去请求活动下商品信息
                        findProduct(entity.getTaobaoActId());

                    }
                }
            }
        }else{
            System.out.println("需要发短信通知了，没有拿到活动信息");
        }
    }







    public void findProduct(String actId) throws IOException, ParseException, JdException {
        //先获取到指定活动下商品的总数量
        int totalCount = findGoodsTotalCount(actId);
        //然后拼接成对应的请求去for循环拼接请求
        //totalPage 总页数
        int page = 1;
        if(totalCount%20==0){
            //说明整除，正好每页显示pageSize条数据，没有多余一页要显示少于pageSize条数据的
            page = totalCount / 20;
        }else{
            //不整除，就要在加一页，来显示多余的数据。
            page = totalCount / 20 +1;
        }
        for (int j = 1; j < page+1; j++) {

            String urlPath = "https://api.m.jd.com/api?functionId=union_cp&appid=unionpc&_=1594271363589&loginType=3&body={%22funName%22:%22getCpActivityGoodsList%22,%22param%22:{%22activityId%22:"+actId+",%22type%22:0,%22skuId%22:%22%22,%22status%22:%22-1%22,%22pageNo%22:"+j+",%22pageSize%22:20}}";
            URL url = new URL(urlPath);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Origin", "https://union.jd.com");
            conn.setRequestProperty("Referer", "https://union.jd.com/investment/groupList");
            conn.setRequestProperty("Cookie", cookie);
            conn.setDoInput(true);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String repStr = "["+sb+"]";
            JSONArray jSONArray = JSONArray.fromObject(repStr);

            if(0 == jSONArray.size()){
                System.out.println("该活动下没有商品");
            }else{
                JSONObject data =  ((JSONObject)jSONArray.get(0)).getJSONObject("result");
                if(null == data ){
                    System.out.println("cookie失效了，请重新获取cookie");
                }
                //爬取到商品的列表
                JSONArray paymentList = data.getJSONArray("result");
                for (int i =0;i<paymentList.size();i++){
                    JSONObject paymentObject= paymentList.getJSONObject(i);
                    KZsGoodsEntity entity = new KZsGoodsEntity();

                    if(paymentObject.has("activityId")){
                        String activityId = paymentObject.getString("activityId");
                        entity.setActivityid(activityId);
                        entity.setTaobaoActId(activityId);
                    }
                    if(paymentObject.has("commissionRate")){
                        String commissionRate = paymentObject.getString("commissionRate");
                        BigDecimal bigDecimal = new BigDecimal(commissionRate);
                        entity.setCommissionrate(bigDecimal);
                    }
                    if(paymentObject.has("endTime")){
                        String endTime = paymentObject.getString("endTime");
                        entity.setEndtime(endTime);
                    }
                    if(paymentObject.has("imageUrl")){
                        String imageUrl = paymentObject.getString("imageUrl");
                        entity.setImgurl("https://img14.360buyimg.com/n1/"+imageUrl);
                    }
                    if(paymentObject.has("orderCntIn")){
                        String orderCntIn = paymentObject.getString("orderCntIn");
                        int orderCnt = Integer.parseInt(orderCntIn);
                        entity.setOrdercntin(orderCnt);
                    }
                    if(paymentObject.has("price")){
                        String price = paymentObject.getString("price");
                        entity.setPrice(new BigDecimal(price));
                    }
                    if(paymentObject.has("serviceRate")){
                        String serviceRate = paymentObject.getString("serviceRate");
                        entity.setServicerate(new BigDecimal(serviceRate));
                    }
                    if(paymentObject.has("shopId")){
                        String shopId = paymentObject.getString("shopId");
                        entity.setShopid(Integer.parseInt(shopId));
                    }
                    if(paymentObject.has("shopName")){
                        String shopName = paymentObject.getString("shopName");
                        entity.setShopname(shopName);
                    }
                    if(paymentObject.has("skuId")){
                        String skuId = paymentObject.getString("skuId");
                        entity.setSkuid(skuId);
                    }
                    if(paymentObject.has("skuName")){
                        String skuName = paymentObject.getString("skuName");
                        entity.setSkuname(skuName);
                    }
                    if(paymentObject.has("startTime")){
                        String startTime = paymentObject.getString("startTime");
                        entity.setStarttime(startTime);
                    }
                    if(paymentObject.has("status")){
                        String status = paymentObject.getString("status");
                        entity.setStatus(Integer.parseInt(status));
                    }

                    //先查询一把库，看这个商品库中是否存在了。如果存在则做更新操作。如果不存在则插入
                    //这里需要去查询一下商品的接口。获取一些商品的属性
                    PromotionGoodsResp[] respData = null;
                    try{
                        JdClient client=new DefaultJdClient(SERVER_URL,accessToken,appKey,appSecret);
                        UnionOpenGoodsPromotiongoodsinfoQueryRequest request=new UnionOpenGoodsPromotiongoodsinfoQueryRequest();
                        request.setSkuIds(entity.getSkuid());
                        UnionOpenGoodsPromotiongoodsinfoQueryResponse response=client.execute(request);
                        respData = response.getData();
                        System.out.println(respData.length);
                    }catch (Exception e){

                    }
                    String materUrl = "";
                    if(null ==respData||0 == respData.length){
                        System.out.println("查询未找到商品");
                        materUrl = "http://item.jd.com/"+entity.getSkuid()+".html";
                    }else{
                        PromotionGoodsResp resp = respData[0];
                        materUrl = resp.getMaterialUrl();
                        entity.setMaterialurl(materUrl);
                        entity.setGoodsUrl(materUrl);
                    }


                    QueryWrapper qw = new QueryWrapper();
                    qw.eq("activityId",entity.getActivityid());
                    qw.eq("skuId",entity.getSkuid());
                    List<KZsGoodsEntity> list = goodsService.list(qw);
                    if(null == list || list.size() == 0){
                        goodsService.save(entity);
                    }else{
                        KZsGoodsEntity f = list.get(0);
                        entity.setId(f.getId());
                        goodsService.updateById(entity);
                    }
                    //查询一把店铺表，如果店铺存在则更新，不存在则插入
                    QueryWrapper shellQW = new QueryWrapper();
                    shellQW.eq("shopId",entity.getShopid());
                    List<KZsSellerEntity>shellList = sellerService.list(shellQW);

                    KZsSellerEntity shellEntity = new KZsSellerEntity();
                    shellEntity.setShopid(entity.getShopid().toString());
                    shellEntity.setSellerNickname(entity.getShopname());
                    shellEntity.setSellerTitle(entity.getShopname());
                    if(null == shellList || shellList.size() == 0){
                        sellerService.save(shellEntity);
                    }else{
                        KZsSellerEntity f = shellList.get(0);
                        shellEntity.setId(f.getId());
                        sellerService.updateById(shellEntity);
                    }
                }
            }
        }
    }





    public Integer findGoodsTotalCount(String actId) throws IOException {
        Integer count = 0;

        String urlPath = "https://api.m.jd.com/api?functionId=union_cp&appid=unionpc&_=1594271363589&loginType=3&body={%22funName%22:%22getCpActivityGoodsList%22,%22param%22:{%22activityId%22:"+actId+",%22type%22:0,%22skuId%22:%22%22,%22status%22:%22-1%22,%22pageNo%22:1,%22pageSize%22:20}}";
        //String cookie = "pinId=MlLL-4mlsxJDNijXjQc9DA; shshshfpa=6cedb008-4b21-9746-d3bd-ef2098d89a63-1587623390; shshshfpb=qqATehNfX2KLOr%2F2eFZpjlA%3D%3D; unick=yinqiaobing942; _tp=BKP6c7Bs6Y0sUAzYwyZzSw%3D%3D; _pst=yinqiaobing942; user-key=e9a3caa6-88b2-4a6b-bdce-8b31c8791f3d; cn=6; __jdv=209449046|baidu|-|organic|not set|1594265351065; __jdu=15942653510611172806449; areaId=18; ipLoc-djd=18-1482-48936-0; PCSYCityID=CN_430000_430100_430104; shshshfp=0503326902ebb5ca8744bc794f29abee; 3AB9D23F7A4B3C9B=X64X3ZOIAQLDC3YTB7GIINW33GADAWMY2R4COKQHPG7ZXFWESU2R55FL42XGETA4EUDEXJXDZJ74TADDPUL5CQBKFI; sidebarStatus=1; ssid=\\\"D9qt32WIQp67MSTMZq2GrA==\\\"; TrackID=1lYYv2MC1hm2aVF5pPUdHRzB-d7AmJQMga6YD9X-MfxDKjREdgDNwmVNGkGTszsseFpNT2ZsQbV-kipZ2FPYaQMP-q0BJJl37DoY7S-T0dmk; thor=61CE30BAEDFEB924A833A65F520E97D216A7B0FEC2FE004D63DD034CC040D05D948BA3BD8D91A2252CA61161F54F5F5ED4FE54D3F41CF9A2CA9BE70261BE5E0C6768D05B29F30C243C8EAC6993F1608509AD2FA1D7ADA97C29F8AA13B48601BAABB273B77B54FA6AD6A4828B8B8640490A7E4DCD43DFBCEF92E2C525D523C97C49D357960E46C3EC928E878076A50013; pin=yinqiaobing942; ceshi3.com=000; logining=1; __jda=209449046.15942653510611172806449.1594265351.1594289900.1594357996.9; __jdc=209449046; login=true; MNoticeIdyinqiaobing942=293; __jdb=209449046.7.15942653510611172806449|9.1594357996; RT=\\\"z=1&dm=jd.com&si=vgcthauykpn&ss=kcfrl2mn&sl=4&tt=3nf&ld=q5e&nu=6b84f814976156ac6b60f272e8f2714c&cl=oly&ul=129o";
        URL url = new URL(urlPath);
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("Origin", "https://union.jd.com");
        conn.setRequestProperty("Referer", "https://union.jd.com/investment/groupList");
        conn.setRequestProperty("Cookie", cookie);
        conn.setDoInput(true);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String repStr = "["+sb+"]";
        JSONArray jSONArray = JSONArray.fromObject(repStr);

        if(0 == jSONArray.size()){
            System.out.println("没有活动");
        }else{
            JSONObject data =  ((JSONObject)jSONArray.get(0)).getJSONObject("result");
            String totalNum = data.getString("totalNum");
            count = Integer.parseInt(totalNum.toString());
        }
        return count;
    }




    public Integer findActTotalCount() throws IOException {
        Integer count = 0;

        String urlPath = "https://api.m.jd.com/api?functionId=union_cp&appid=unionpc&_=1594266665523&loginType=3&body={%22funName%22:%22getCpActivityList%22,%22param%22:{%22createTimeStart%22:%22%22,%22createTimeEnd%22:%22%22,%22title%22:%22%22,%22activityId%22:%22%22,%22activityStatus%22:%22%22,%22pageNo%22:1,%22pageSize%22:10}}";
        //String cookie = "pinId=MlLL-4mlsxJDNijXjQc9DA; shshshfpa=6cedb008-4b21-9746-d3bd-ef2098d89a63-1587623390; shshshfpb=qqATehNfX2KLOr%2F2eFZpjlA%3D%3D; unick=yinqiaobing942; _tp=BKP6c7Bs6Y0sUAzYwyZzSw%3D%3D; _pst=yinqiaobing942; user-key=e9a3caa6-88b2-4a6b-bdce-8b31c8791f3d; cn=6; __jdv=209449046|baidu|-|organic|not set|1594265351065; __jdu=15942653510611172806449; areaId=18; ipLoc-djd=18-1482-48936-0; PCSYCityID=CN_430000_430100_430104; shshshfp=0503326902ebb5ca8744bc794f29abee; 3AB9D23F7A4B3C9B=X64X3ZOIAQLDC3YTB7GIINW33GADAWMY2R4COKQHPG7ZXFWESU2R55FL42XGETA4EUDEXJXDZJ74TADDPUL5CQBKFI; sidebarStatus=1; ssid=\"D9qt32WIQp67MSTMZq2GrA==\"; TrackID=1lYYv2MC1hm2aVF5pPUdHRzB-d7AmJQMga6YD9X-MfxDKjREdgDNwmVNGkGTszsseFpNT2ZsQbV-kipZ2FPYaQMP-q0BJJl37DoY7S-T0dmk; thor=61CE30BAEDFEB924A833A65F520E97D216A7B0FEC2FE004D63DD034CC040D05D948BA3BD8D91A2252CA61161F54F5F5ED4FE54D3F41CF9A2CA9BE70261BE5E0C6768D05B29F30C243C8EAC6993F1608509AD2FA1D7ADA97C29F8AA13B48601BAABB273B77B54FA6AD6A4828B8B8640490A7E4DCD43DFBCEF92E2C525D523C97C49D357960E46C3EC928E878076A50013; pin=yinqiaobing942; ceshi3.com=000; logining=1; __jda=209449046.15942653510611172806449.1594265351.1594289900.1594357996.9; __jdc=209449046; login=true; MNoticeIdyinqiaobing942=293; __jdb=209449046.7.15942653510611172806449|9.1594357996; RT=\"z=1&dm=jd.com&si=vgcthauykpn&ss=kcfrl2mn&sl=4&tt=3nf&ld=q5e&nu=6b84f814976156ac6b60f272e8f2714c&cl=oly&ul=129o";
        URL url = new URL(urlPath);
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("Origin", "https://union.jd.com");
        conn.setRequestProperty("Referer", "https://union.jd.com/investment/groupList");
        conn.setRequestProperty("Cookie", cookie);
        conn.setDoInput(true);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String repStr = "["+sb+"]";
        JSONArray jSONArray = JSONArray.fromObject(repStr);
        String code = "";
        if(((JSONObject)jSONArray.get(0)).has("code")){
            code =  ((JSONObject)jSONArray.get(0)).getString("code");
        }
        if(0 == jSONArray.size() || !code.equals("200")){
            System.out.println("没有获取到活动信息");
        }else{
            JSONObject data =  ((JSONObject)jSONArray.get(0)).getJSONObject("result");
            String totalNum = data.getString("totalNum");
            count = Integer.parseInt(totalNum.toString());
        }
        return count;
    }


    public Boolean checkCookier(){
        List<KZsJdCookierEntity>list = cookierService.list();
        KZsJdCookierEntity entity = list.get(0);
        if(entity.getState() == 1 && StringUtils.isNotEmpty(entity.getCookierValue())){
            if(entity.getCookierValue().contains("cookie:")){
                cookie =entity.getCookierValue().substring(8,entity.getCookierValue().length());
            }
        }else{
            //开始进入发送短信的逻辑，并且终止上面的爬虫逻辑
            // sendMessage();
            return false;
        }
        return true;
    }


}
