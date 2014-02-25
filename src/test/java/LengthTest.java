/**
 * Created by twer on 12/20/13.
 */
import com.thoughtworks.Length;
import com.thoughtworks.Unit;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

public class LengthTest {

    Length length1cm = new Length(1, Unit.CM);
    Length length2cm = new Length(2,Unit.CM);
    Length length1m = new Length(1,Unit.M);
    Length length1km = new Length(1,Unit.KM);

    @Before
    public void setUp(){

    }

    @Test
    public void should_not_be_equal_1cm_and_2cm() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        assertEquals(false, length1cm.equalTo(length2cm));
    }

    @Test
    public void should_be_equal_1cm_and_1cm() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Length anotherlength1cm = new Length(1,Unit.CM);

        assertEquals(true, anotherlength1cm.equalTo(length1cm));
    }

    @Test
    public void should_not_be_equal_1m_and_1cm() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        assertEquals(false, length1cm.equalTo(length1m));
    }

    @Test
    public void  should_be_equal_to_3cm() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Length result = length1cm.plus(length2cm);
        Length length3cm = new Length(3,Unit.CM);

//        assertEquals(true,result.equals(length3cm));
        assertEquals(length3cm,result);
    }

    @Test
    public void should_be_equal_to_1_01m() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Length result = length1m.plus(length1cm);
        Length length1_01m = new Length(1.01,Unit.M);

        assertEquals(true, result.equalTo(length1_01m));
    }
}
