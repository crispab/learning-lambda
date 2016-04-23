package se.crisp.examples.lambda.hello;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldTest {

    private static final Integer SOME_COUNT = 42;

    @Mock
    private Context context;

    @Mock
    private LambdaLogger logger;

    @Test
    public void returnStringOfCount() throws Exception {

        when(context.getLogger()).thenReturn(logger);
        assertThat(new HelloWorld().myHandler(SOME_COUNT, context), is(SOME_COUNT.toString()));
    }
}