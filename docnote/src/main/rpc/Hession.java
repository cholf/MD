package rpc;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author gangwen.xu
 * Date  : 2018/10/23
 * Time  : 上午11:06
 * 类描述 :
 */
public class Hession implements Serializable{

    private static final long serialVersionUID = 7392140405790373499L;

    public class TestHe implements Serializable{
        private static final long serialVersionUID = 4095557480107845051L;
        int index ;
        BigDecimal big;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public BigDecimal getBig() {
            return big;
        }

        public void setBig(BigDecimal big) {
            this.big = big;
        }
    }


    @Test
    public  void Test() {
        Byte weather = null;
        try {
            Map<String, Byte> map = new HashMap<String, Byte>();
            map.put("weather", (byte) 1);

            TestHe testHe = new TestHe();
            testHe.setBig(new BigDecimal(20));
            testHe.setIndex(33);
            byte[] bytes = serialize(testHe);
            TestHe object = (TestHe) deserialize(bytes);
            System.out.println(object);
            //这里会抛异常
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(weather);
    }

    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output ho = new Hessian2Output(os);
        byte[] cc = null;
        try {
            if (obj == null) throw new NullPointerException();
            ho.writeObject(obj);
            ho.flushBuffer();
            cc = os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ho.close();
        }
        return cc;

    }

    public static Object deserialize(byte[] by) throws IOException {
        try {
            if (by == null) throw new NullPointerException();
            ByteArrayInputStream is = new ByteArrayInputStream(by);
            Hessian2Input hi = new Hessian2Input(is);
            return hi.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
