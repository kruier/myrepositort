import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
        SqlSession ss = ssf.openSession();
        Student stu = ss.getMapper(StudentMapper.class).selectStuById1(2);
        System.out.println(stu);
    }
}