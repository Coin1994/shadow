package kits;
import base.TestCase;
import com.coin.shadow.kits.ByteKits;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/22 15:22
 * @description：
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public class KitsTest implements TestCase {
    public void run() {
        runByteKits();
    }

    public void runByteKits(){
        String msg = "msg";
        byte [] bytes = ByteKits.stringToByteArray(msg);
        String ret = ByteKits.byteArrayToString(bytes);
        if (msg.equalsIgnoreCase(ret)) {
            System.out.println("OK");
        }
    }


}
