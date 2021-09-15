package com.zys;

import com.zys.dao.IHotContentMapper;
import com.zys.pojo.po.HotContent;
import com.zys.service.impl.SwiperItemsServiceImpl;
import com.zys.utils.GetLocalhostURLUtils;
import com.zys.utils.GetOpenIdUtils;
import com.zys.utils.List2Str;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

/**
 * @author cy
 * @create 2021-03-08-10:34 上午
 * @Description
 */
@SpringBootTest
public class wxApTest {

    @Autowired
    private GetOpenIdUtils openIdUtils;

    @Autowired
    private SwiperItemsServiceImpl swiperItemsService;

    @Test
    void testOpenId() throws IOException {

        String userInfo = openIdUtils.getUserInfo("0715tDkl2RiMD64Zs0nl2EdtcO35tDk5");
        System.out.println(userInfo);
    }

    @Test
    void testSwiperItems() {
        List swiperItems = swiperItemsService.getSwiperItems();
        for (Object swiperItem : swiperItems) {
            System.out.println(swiperItem);
        }
    }

    @Test
    void testTest1() {
        Long value1 = 1L;
        Long value2 = 1L;
        Long value3 = new Long(1);
        Long value4 = new Long(1);
        Long value5 = 129L;
        Long value6 = 129L;
        Long value7 = new Long(129);
        Long value8 = new Long(129);
        System.out.println("cmp1:" + (value1 == value2));
        System.out.println("cmp2:" + (value3 == value4));
        System.out.println("cmp3:" + (value5 == value6));
        System.out.println("cmp4:" + (value7 == value8));

    }

    @Test
    void testTest2() {
        String str = "startS";
        Map<String, String> strMap = new HashMap<>(2);
        strMap.put("startMap", "startMap");
        transfer(str, strMap);
        System.out.println("str:" + str);
        System.out.println("strMap:" + strMap.get("startMap"));
    }


    private static void transfer(String S, Map<String, String> strMap) {
        S = "endS";
        strMap.put("startMap", "endMap");
    }

    @Test
    void testTest3() {
        List<String> aa = new ArrayList<String>();
        aa.add("F1");
        aa.add("F2");
        aa.add("F3");
        for (String temp : aa) {
            if ("F3".equals(temp)) {
                aa.remove(temp);
            }
        }
        System.out.println(aa.size());
        for (String temp : aa) {
            System.out.println(temp);
        }


    }

    @Test
    void testTest4() {
        Thread t = new Thread() {
            @Override
            public void run() {
                m1();
            }
        };
        t.run();
        System.out.println("Hello");
        t.start();
        System.out.println("Hello");
    }

    static synchronized void m1() {
        System.out.println("Java");
    }


    /**
     * 某公司为激发广大员工的团队精神和竞争意识，在辛忙工作的同时不忘增强体质，特举办了秋季运动会。
     * 在运动会结束后，为了给认真参加比赛的员工颁发奖，有M名员工站成了一条直线，领导会根据每位员工场上的表现，
     * 预先给他们评分，并颁发奖品，颁发奖品的规则如下：
     * 1. 每位员工至少分到了一项奖品
     * 2. 相邻的同事中，评分高的同事获得更多的奖品。
     * 请根据该规则编码实现需要为领导至少准备多少奖品？
     * <p>
     * 输入数据： 1,2,2
     * <p>
     * 可以给三位同事分别颁发1,2,1项奖品，第三位同事虽然只得到1项奖品，但已满足上述两个条件
     * <p>
     * <p>
     * 输出： 4
     */

    @Test
    void testScanner() {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0;
        if (sc.hasNextInt()) {//double,boolean,byte…类似
            a = sc.nextInt();
            b = sc.nextInt();
        }
        System.out.println(a + b);
        sc.close();
    }

    @Autowired
    private Environment environment;

    @Test
    void getPro() throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(InetAddress.getLocalHost().getHostName());
        System.out.println(environment.getProperty("server.port"));
        System.out.println(environment.getProperty("server.servlet.context-path"));


        System.out.println(System.getProperty("user.dir"));
    }


    @Test
    void testTestIP() {
        GetLocalhostURLUtils getLocalhostURL = new GetLocalhostURLUtils();
        System.out.println(getLocalhostURL.splicingURL("/upload/swiper/2.png"));
    }

    @Autowired
    private IHotContentMapper hotContentMapper;

    @Test
    void testHot() {
        List<HotContent> hotContent = hotContentMapper.getHotContent();
        for (HotContent o : hotContent) {
            System.out.println(o);
        }
    }


    @Test
    void testList() {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("4");
        String s = List2Str.list2Str(objects, ',');
        System.out.println(s);
    }

}
