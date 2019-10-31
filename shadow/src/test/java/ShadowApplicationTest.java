import com.coin.shadow.kits.IoKits;
import base.TestCase;
import com.coin.shadow.kits.StringKits;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/22 15:20
 * @description：
 * @modified By：孙伟
 * @version: v1.0.0.0
 */

public class ShadowApplicationTest {
    public static void main(String args[]){
        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void run() throws Exception {
        InputStream input = new FileInputStream(new File("D:/github/shadow/shadow/src/test/java/load.properties"));
        IoKits.readContent(input, (lineContent)->{
            if (StringKits.isBlank(lineContent)){
                return "";
            }
            Class<?> target = null;
            try {
                target = Class.forName(lineContent);
                TestCase instance = (TestCase)target.newInstance();
                cases.add(instance);

            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
            return "";
        });

        for (TestCase target : cases){
            target.run();
        }
    }


    private static List<TestCase> cases = new ArrayList<>();
}
