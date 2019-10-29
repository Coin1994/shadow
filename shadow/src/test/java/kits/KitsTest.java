package kits;
import base.TestCase;
import com.coin.shadow.kits.ByteKits;
import com.coin.shadow.kits.ReflexKits;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/22 15:22
 * @description：
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public class KitsTest implements TestCase {

    static class A {
        public String a;
        public String b;
    }


    public void run() {
        runByteKits();
        runReflexKits();
    }

    private void runByteKits(){
        String msg = "msg";
        byte [] bytes = ByteKits.stringToByteArray(msg);
        String ret = ByteKits.byteArrayToString(bytes);
        if (msg.equalsIgnoreCase(ret)) {
            System.out.println("OK");
        }
    }

    private void runReflexKits(){
        List<Field> list = ReflexKits.getFields((List<Field>) null, A.class, true);
        System.out.println(list);
    }


}
