import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException() throws Exception {
        throw new IllegalArgumentException();
    }

    @Test
    public void shouldReturnOne() throws Exception {
        assertEquals(1, 1);
    }
}