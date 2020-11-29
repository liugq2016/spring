import cn.lgq.www.MyTestBean;
import org.junit.Test;

/**
 * @SuppressWarnings:告诉编译器忽略指定的警告，不用在编译完成后出现警告信息
 */
@SuppressWarnings("deprecation")
public class BeanFactoryTest {

    @Test
    public void testSimpleLoad(){
        BeanFactory bf = XmlBeanFactory(new ClassPathResource("beanFactoryTestXml.xml"));
        MyTestBean bean = bf.getBean("myTestBean");
        assertEquals("testStr",bean.getTestStr());
    }

}
