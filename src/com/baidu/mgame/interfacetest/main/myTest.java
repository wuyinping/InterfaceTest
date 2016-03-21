package com.baidu.mgame.interfacetest.main;

import com.baidu.mgame.interfacetest.utils.AES;
import com.baidu.mgame.interfacetest.utils.HttpUtil;

public class myTest {
    public static void main(String[] args) {
        // 发�? POST 请求
        // String url = "http://10.10.0.104:9999/thunder/getFriendAddressList";
        // String url = "http://10.10.0.104:9999/thunder/uploadFriendAddress";

        // String url="http://10.10.0.93:9999/thunder/initSDK";
        // String url2="http://10.10.0.94:9999/thunder/initSDK";
        // String url3="http://10.10.0.95:9999/thunder/initSDK";

        // 63269
        // String url4 = "http://10.10.0.95:9999/thunder/getFriendAddressList";

        // String url = "http://10.11.0.62:9090/gamehall/service2";

        // String url = "http://10.11.0.62:9510/compete/pkcompete";

        // 0-争霸赛测试；1-自定义测试；IOS测试
        int flag = 0;

        // 线上测试环境
        String urlOnline = "http://gamesdk.pk.baidu-mgame.com/compete/pkcompete";

        // QA测试环境
        // String url = "http://apitest.duoku.com:9510/compete/pkcompete";
        String urlQA = "http://apitest.duoku.com:9501/compete/pkcompete";

        // 本地测试环境
        String url = "http://localhost:8080/competepk/pkcompete";
        // 本地定时任务调试
        String url2 = "http://localhost:8080/competepk/devTest";

        String urlIOSYY = "http://iosyy.m.baidu-mgame.com/";

        String IOSQA113 = "http://apitest.duoku.com:8082/iosyy/helpCenter";
        String IOSMY113 = "http://localhost:8080/gamesdk-iosyy/helpCenter";
        String IOSQA102 = "http://apitest.duoku.com:8082/iosyy/loginbaidu";
        String IOSMY102 = "http://localhost:8080/gamesdk-iosyy/loginbaidu";
        String IOSQA101 = "http://apitest.duoku.com:8082/iosyy/login91";
        String IOSMY101 = "http://localhost:8080/gamesdk-iosyy/login91";

        String parm =
                "{\"os\":\"android\",\"bdcuid\":\"D8B3025A8A032607D804DA7C0CC3CF57|321107150335953\",\"location\":\"\",\"tag\":\"45\",\"gameversion\":\"1.4.3\",\"imei\":\"359533051701123\",\"appkey\":\"b80b8ecead42c8678537d282096df15c\","
                        + "\"appid\":\"4110\",\"udid\":\"C36E6792BFC960159D792F4C94CD5267\","
                        + "\"version\":\"1.4.3\","
                        + "\"packageName_list\":[\"com.android.system.op.notebook\",\"com.baidu.appsearch\","
                        + "\"com.baidu.searchbox\",\"com.dragon.android.pandaspace\",\"com.duoku.platform.demo.single\","
                        + "\"com.feistma.appmove\",\"com.ljmobile.yjb.move.app\",\"com.nd.assistance\",\"com.qihoo.yunpan\","
                        + "\"com.shuame.mobile\",\"com.shuame.sprite\",\"com.tencent.FileManager\",\"com.tencent.android.qqdownloader\","
                        + "\"com.tencent.mm\",\"com.thinksky.itools\",\"com.thinksky.itools.markets\",\"rui.eh.myb.qv\"],"
                        + "\"gamepackagename\":\"com.duoku.platform.demo.single\",\"screen_orientation\":1,\"screenwh\":\"540_960\",\"connecttype\":\"wifi\",\"bdchannelid\":\"4087083005247825032\",\"ua\":\"GT-I9152\",\"app_secret\":\"828e3bd4c3c9903cbde222e2d6e51920\",\"bdpushid\":\"659242493682098524\",\"px_version\":\"1.0.0\","
                        + "\"channel\":\"13744,\",\"gameversioncode\":\"143\"}";

        // String url2 = "http://itest.client.duoku.com:88/huaweitvsdk/hw_tvgame";

        // String url = "http://apitest.duoku.com:8081/gameplus/gameplus";
        // String url = "http://10.11.0.62:9111/gameplus/gameplus";

        // String url = "http://apitest.duoku.com:9111/gameplus/gameplus";

        // String parm = "{\"os\":\"4.4.2\",\"location\":\"40.025833_116.305569\"," +
        // "\"bdcuid\":\"A821A8C19F518F4CFABC53C8EBF382B1|021773640341753\",\"tag\":\"401\"," +
        // "\"gameversion\":\"2.0.0.7\",\"imei\":\"357143046377120\",\"competition_id\":\"12347241\"," +
        // "\"page_number\":1,\"userid\":\"2253937459\",\"appkey\":\"f191b4af1d8b6e4636e84a683569c29f\"," +
        // "\"appid\":\"4384\",\"udid\":\"E3E19F88825BE1CBC29C8EA801E2D999\"," +
        //
        // // "\"sessionid
        // ":\"EotbFpYV2lybHA1Z0tuMFNIdUMwOEVQSGlLb1BOdTZEOFNtYXE1TC15T2lJZWhVQVFBQUFBJCQAAAAAAAAAAAEAAAAVhuxcAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAKKUwFSilMBUZ\",\"push_channelid\":\"3561780703894414518\",\"page_count\":20,\"version\":\"2.1.0\",\"token\":\"\",\"connecttype\":\"wifi\",\"screenwh\":\"1794_1080\",\"push_userid\":\"594007400396825968\",\"ua\":\"H60-L01\",\"channel\":\"4384\"}";

        // String parm = "{\"os\":\"4.2.2\",\"location\":\"40.027072_116.306299\",\"tag\":\"101\"," +
        // "\"p_flag\":\"BMG_ONLINE\",\"imei\":\"A0000049DA61FA\",\"appid\":\"10086\"," +
        // "\"udid\":\"90625BE7E89ED17E54E8F4CF49011114\",\"telphone\":\"\",\"version\":\"1.0\"," +
        // "\"connecttype\":\"3\",\"screenwh\":\"1184_720\",\"ua\":\"HUAWEI P6-C00\",\"channel\":\"-100\"," +
        // "\"gameid\":\"51063\",\"pkgname\":\"com.lk.wzzj.duoku\"}";

        // String parm = "{\"udid\":\"45C658052B326DEDDA05B89BEF1D2E3C\"," +
        // "\"bdcuid\":\"32C15320D3BC3C98C05948529D72CF91|937209050819353\",\"version\":\"2.0.0\"," +
        // "\"gameversion\":\"2.0.0.7\",\"ua\":\"Nexus 4\",\"os\":\"5.0.1\",\"screenwh\":\"1196_768\"," +
        // "\"connecttype\":\"wifi\",\"imei\":\"353918050902739\",\"channel\":\"4183\",\"appid\":\"4183\"," +
        // "\"appkey\":\"f191b4af1d8b6e4636e84a683569c29f\",\"token\":\"\",\"userid\":\"\",\"sessionid\":\"\"," +
        // "\"location\":\"40.0259208_116.3056823\",\"push_channelid\":\"3668805693854139153\"," +
        // "\"push_userid\":\"600012141700722270\",\"competition_id\":\"12345619\",\"tag\":\"102\"}";

        // String parm =
        // "{\"os\":\"4.4.2\",\"location\":\"40.0260877_116.3056042\","
        // + "\"bdcuid\":\"D6B9DC906F11C635394D35EF60A4AFCA|937209050819353\",\"tag\":\"109\","
        // + "\"gameversion\":\"1.0.0.9\",\"imei\":\"353918050902739\",\"competition_id\":\"\",\"userid\":\"\","
        // + "\"appkey\":\"f191b4af1d8b6e4636e84a683569c29f\",\"appid\":\"4183\","
        // + "\"udid\":\"658DFD9C47AB5E169D2E5A3E051D06AC\",\"sessionid\":\"\",\"push_channelid\":\"111\","
        // + "\"version\":\"2.0.1\",\"token\":\"\",\"connecttype\":\"wifi\",\"screenwh\":\"768_1184\","
        // + "\"push_userid\":\"111\",\"ua\":\"Nexus 4\",\"channel\":\"4183\",\"page_number\":\"1\","
        // + "\"page_count\":\"5\"}";

        // tag 107
        String param107 =
                "{\"os\":\"4.4.2\",\"location\":\"0_0\",\"bdcuid\":\"E260ED060BD39FDCB3A0F0783E09B423|456694360126253\",\"tag\":\"107\",\"gameversion\":\"2.0.0.7\",\"imei\":\"352621063496654\",\"userid\":\"\",\"appkey\":\"f191b4af1d8b6e4636e84a683569c29f\",\"appid\":\"3456\",\"udid\":\"AFDD326DC83BF25571AC26609D51F36F\",\"sessionid\":\"\",\"push_channelid\":\"4382350182831187417\",\"version\":\"2.1.0\",\"token\":\"\",\"connecttype\":\"wifi\",\"screenwh\":\"1920_1080\",\"push_userid\":\"918703507845800090\",\"ua\":\"SM-G9006V\",\"channel\":\"3456\"}";

        // tag 403
        String param403 =
                "{\"os\":\"4.4.2\",\"location\":\"40.025917_116.305673\",\"bdcuid\":\"A821A8C19F518F4CFABC53C8EBF382B1|021773640341753\",\"tag\":\"403\",\"gameversion\":\"2.0.0.7\",\"imei\":\"357143046377120\",\"competition_id\":\"12357333\",\"page_number\":1,\"userid\":\"2253937459\",\"appkey\":\"f191b4af1d8b6e4636e84a683569c29f\",\"appid\":\"4384\",\"udid\":\"E3E19F88825BE1CBC29C8EA801E2D999\",\"sessionid\":\"EotbFpYV2lybHA1Z0tuMFNIdUMwOEVQSGlLb1BOdTZEOFNtYXE1TC15T2lJZWhVQVFBQUFBJCQAAAAAAAAAAAEAAAAVhuxcAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAKKUwFSilMBUZ\",\"push_channelid\":\"3561780703894414518\",\"page_count\":20,\"version\":\"2.1.0\",\"token\":\"\",\"connecttype\":\"wifi\",\"screenwh\":\"1080_1776\",\"push_userid\":\"594007400396825968\",\"ua\":\"H60-L01\",\"channel\":\"3456\"}";

        // tag106
        // String param106 =
        // "{\"os\":\"4.4.2\",\"score_desc\":\"2015-05-25 11:08:41\",\"location\":\"40.026362_116.305801\",\"bdcuid\":\"6A5E57C519724936ADB3F729647C004B|630927120661568\",\"tag\":\"106\",\"gameversion\":\"2.0.0.7\",\"imei\":\"865166021729036\",\"competition_id\":\"12357370\",\"userid\":\"3126966949\",\"appkey\":\"f191b4af1d8b6e4636e84a683569c29f\",\"appid\":\"4384\",\"game_score\":123,\"game_password\":\"1432523318460\",\"security\":\"123123123123\",\"udid\":\"3DC746E1F3BD3D7E7D02588D472CFF33\",\"sessionid\":\"EhlS1JZclJDSkhsWWdEdm5rd08yaE9hLU85cnZPSjN2Q3JoUHBNS0JyQjQxb0JWQVFBQUFBJCQAAAAAAAAAAAEAAAD0unplAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHhJWVV4SVlVS\",\"push_channelid\":\"3670648159073775950\",\"version\":\"2.1.0\",\"token\":\"\",\"connecttype\":\"wifi\",\"screenwh\":\"1080_1812\",\"push_userid\":\"1121014974139378200\",\"ua\":\"HUAWEI MT7-TL00\",\"channel\":\"4384\"}";

        // tag109
        String param109 =
                "{\"os\":\"4.2.2\",\"location\":\"0_0\",\"bdcuid\":\"1FE8CE3AB9F7939547311B5ACFFE18C7|955585050430953\",\"tag\":\"109\",\"gameversion\":\"2.0.0.7\",\"imei\":\"359034050585559\",\"competition_id\":\"12357344\",\"page_number\":1,\"userid\":\"AC7FD20D6463770B3342C4AD9024CA53\",\"appkey\":\"f191b4af1d8b6e4636e84a683569c29f\",\"appid\":\"4384\",\"udid\":\"AC7FD20D6463770B3342C4AD9024CA53\",\"sessionid\":\"AC7FD20D6463770B3342C4AD9024CA53\",\"push_channelid\":\"4180220404775340327\",\"page_count\":50,\"version\":\"2.1.0\",\"token\":\"\",\"connecttype\":\"wifi\",\"screenwh\":\"480_800\",\"push_userid\":\"686558585476474131\",\"ua\":\"SM-G3858\",\"channel\":\"4384\"}";

        // tag 206
        String param206 =
                "{\"udid\":\"A4353E261951B1A504C22CF18876FA7F\",\"bdcuid\":\"79B365380C3780A7FF42BE4284EE68C8|939703250052953\",\"version\":\"2.1.0\",\"gameversion\":\"2.0.0.7\",\"ua\":\"Nexus 5\",\"os\":\"5.0.1\",\"screenwh\":\"1080_1776\",\"connecttype\":\"wifi\",\"imei\":\"359250052307939\",\"channel\":\"4384\",\"appid\":\"4384\",\"appkey\":\"f191b4af1d8b6e4636e84a683569c29f\",\"token\":\"\",\"userid\":\"2086931850\",\"sessionid\":\"UzTnpkMkVRQ29DdWpNRlVDY0wxRUo1MkExQ1REZThKQWlJSjlNcUFPTmlvaVJWQVFBQUFBJCQAAAAAAAAAAAEAAABDfFVgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGIV~VRiFf1URU\",\"location\":\"0_0\",\"push_channelid\":\"3671360972180653470\",\"push_userid\":\"676828569286812269\",\"tag\":\"206\",\"competition_id\":\"12357369\"}";

        // tag 203
        String param203 =
                "{\"udid\":\"A4353E261951B1A504C22CF18876FA7F\",\"bdcuid\":\"79B365380C3780A7FF42BE4284EE68C8|939703250052953\",\"version\":\"2.1.0\",\"gameversion\":\"2.0.0.7\",\"ua\":\"Nexus 5\",\"os\":\"5.0.1\",\"screenwh\":\"1080_1776\",\"connecttype\":\"wifi\",\"imei\":\"359250052307939\",\"channel\":\"4384\",\"appid\":\"4384\",\"appkey\":\"f191b4af1d8b6e4636e84a683569c29f\",\"token\":\"\",\"userid\":\"2086931850\",\"sessionid\":\"UzTnpkMkVRQ29DdWpNRlVDY0wxRUo1MkExQ1REZThKQWlJSjlNcUFPTmlvaVJWQVFBQUFBJCQAAAAAAAAAAAEAAABDfFVgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGIV~VRiFf1URU\",\"location\":\"0_0\",\"push_channelid\":\"3671360972180653470\",\"push_userid\":\"676828569286812269\",\"tag\":\"203\",\"player_userid\":\"476158116\",\"msgtype\":1,\"competition_id\":\"12357369\"}";

        // tag 207
        String param207 =
                "{\"udid\":\"A4353E261951B1A504C22CF18876FA7F\",\"bdcuid\":\"79B365380C3780A7FF42BE4284EE68C8|939703250052953\",\"version\":\"2.1.0\",\"gameversion\":\"2.0.0.7\",\"ua\":\"Nexus 5\",\"os\":\"5.0.1\",\"screenwh\":\"1080_1776\",\"connecttype\":\"wifi\",\"imei\":\"359250052307939\",\"channel\":\"4384\",\"appid\":\"4384\",\"appkey\":\"f191b4af1d8b6e4636e84a683569c29f\",\"token\":\"\",\"userid\":\"2086931850\",\"sessionid\":\"UzTnpkMkVRQ29DdWpNRlVDY0wxRUo1MkExQ1REZThKQWlJSjlNcUFPTmlvaVJWQVFBQUFBJCQAAAAAAAAAAAEAAABDfFVgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGIV~VRiFf1URU\",\"location\":\"0_0\",\"push_channelid\":\"3671360972180653470\",\"push_userid\":\"676828569286812269\",\"tag\":\"207\",\"pk_style\":3,\"pk_id\":\"1100430\",\"record_val\":222,\"player_score\":234,\"anti_cheating_content\":\"1432544726426\",\"pkfromuserid\":\"2086931850\",\"pktouserid\":\"476158116\",\"pktime\":1432544728716,\"score_desc\":\"2015-05-25 17:05:38\",\"competition_id\":\"12357369\",\"security\":\"123123123123\"}";

        // tag 106
        String param106 =
                "{\"os\":\"4.2.1\",\"score_desc\":\"2015-05-25 15:27:08\",\"location\":\"0_0\",\"bdcuid\":\"1B671DA7EF13974AFF635FC399D89515|373823220192268\",\"tag\":\"106\",\"gameversion\":\"2.0.0.7\",\"imei\":\"862291022328373\",\"competition_id\":\"12357380\",\"userid\":\"476158116\",\"appkey\":\"f191b4af1d8b6e4636e84a683569c29f\",\"appid\":\"4384\",\"game_score\":500000000,\"game_password\":\"1432538819489\",\"security\":\"123123123123\",\"udid\":\"BD1817AFCD8F904D4029F3938C40C695\",\"sessionid\":\"k9nNXpXUTE5YVNqaGgwNU9ITk5TdnRwSGZvZFpsd2MySVRHZEd1TWExTnAyb0JWQVFBQUFBJCQAAAAAAAAAAAEAAADWHHtlAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGlNWVVpTVlVN\",\"push_channelid\":\"4316322831682149297\",\"version\":\"2.1.0\",\"token\":\"\",\"connecttype\":\"net\",\"screenwh\":\"480_800\",\"push_userid\":\"991202761839831610\",\"ua\":\"M601\",\"channel\":\"4384\"}";

        // tag 201
        String param201 =
                "{\"os\":\"4.2.1\",\"location\":\"40.026172_116.305355\",\"bdcuid\":\"497CC5D86C7FDC8C39CF1DE002D1F3E5|715886120151368\",\"tag\":\"201\",\"gameversion\":\"2.0.0.7\",\"imei\":\"863151021688517\",\"competition_id\":\"12357369\",\"page_number\":1,\"userid\":\"2170705132\",\"appkey\":\"f191b4af1d8b6e4636e84a683569c29f\",\"appid\":\"4384\",\"udid\":\"510747444E3876BAECFDDD179D401040\",\"sessionid\":\"U93ZUgwYmdmcVJKZ2l-dEtzTjN3Q2hCNTU2cn5CaE1jOGhXcWVRYnFGeFhlSXBWQVFBQUFBJCQAAAAAAAAAAAEAAAAagTNmAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFfrYlVX62JVZ\",\"push_channelid\":\"4237815354818941121\",\"page_count\":20,\"version\":\"2.1.0\",\"token\":\"\",\"connecttype\":\"net\",\"screenwh\":\"1080_1800\",\"push_userid\":\"1101704939280590870\",\"ua\":\"M355\",\"channel\":\"4384\"}";

        String paramIOS113 =
                "{\"bduserid\":\"17001774\",\"channel\":\"700\",\"gameversion\":\"16\",\"appkey\":\"5t6y7u8i\",\"udid\":\"76AF164E-23A5-444E-BDCF-428B14029710\",\"connecttype\":\"3\",\"screenwh\":\"320.000000_568.000000\",\"imei\":\"e3f5536a141811db40efd6400f1d0a4e\",\"os\":\"iPhone OS 8.2\",\"tag\":\"113\",\"version\":\"1.0.0\",\"appid\":\"102\",\"dkuserid\":\"1032770066\",\"ua\":\"iPhone\",\"sessionid\":\"A822AEBB2FC76C2FF48EAFEFA056B5B5\",\"bduss\":\"E1WQVRHcGwybzBPODNQemxUdllpWmRubVd6UWFmVTVEWWp1ZWJvMGd-YlJSNVpWQVFBQUFBJCQAAAAAAAAAAAEAAAAjAfEHxbfOxLXEueK71Mvq1MIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANG6blXRum5VU\",\"baidu91token\":\"\"}";

        String paramIOS102 =
                "{\"imei\":\"e3f5536a141811db40efd6400f1d0a4e\",\"bduss\":\"hhSUpPejdiNmk2SHlDSTQwaHlEVGNvUkJGaTJmflBqZEZhR000dUxsUVNTWlpWQVFBQUFBJCQAAAAAAAAAAAEAAAAjAfEHxbfOxLXEueK71Mvq1MIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABK8blUSvG5VaG\",\"bdlogintype\":\"1\",\"baidu91token\":\"\",\"bduserid\":\"133234979\",\"udid\":\"76AF164E-23A5-444E-BDCF-428B14029710\",\"channel\":\"700\",\"version\":\"1.0.0\",\"ua\":\"iPhone\",\"screenwh\":\"320.000000_568.000000\",\"tag\":\"102\",\"os\":\"iPhone OS 8.2\",\"username\":\"欧文的光辉岁月\",\"gameversion\":\"16\",\"appid\":\"102\",\"appkey\":\"5t6y7u8i\",\"connecttype\":\"3\",\"dkuserid\":\"1032770066\",\"bdptoken\":\"d60b804ffe4239850d3373946e983dc3\"}";

        String paramIOS101 =
                "{\"channel\":\"700\",\"password\":\"abc123\",\"gameversion\":\"10\",\"username\":\"sj223448595\",\"connecttype\":\"3\",\"screenwh\":\"320.000000_568.000000\",\"imei\":\"a688e0ac08636657dc59f4668d7f4da2\",\"os\":\"iOS 7.1\",\"tag\":\"101\",\"version\":\"1.0.0\",\"appid\":\"102\",\"ua\":\"iPhone5c\",\"udid\":\"a58e9ba678bb203a62c97ed2502bfc88\",\"appkey\":\"5t6y7u8i\",\"logintype\":\"2\"}";

        // 定时任务
        String paramTask = "action=0";

        if (flag == 0) {
            AES myaes = new AES("compete");
            String sr = null;
            sr = HttpUtil.http("http://10.11.0.62:8082/standalone/getGameRecommendV140", myaes.aesEncrypt(parm.trim()));
            System.out.println(" : 返回结果:\n" + myaes.aesDecrypt(sr));
        } else if (flag == 1) {
            HttpUtil.http(url2, paramTask);
        } else if (flag == 2) {
            AES myaes = new AES("ios");
            String sr = null;
            sr = HttpUtil.http(IOSQA113, myaes.aesEncrypt(paramIOS113.trim()));
            System.out.println(" : 返回结果:\n" + myaes.aesDecrypt(sr));
        }

    }
}
