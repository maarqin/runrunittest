package com.thomazmarcos.runrunittest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.thomazmarcos.runrunittest.dto.Task;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.thomazmarcos.runrunittest", appContext.getPackageName());
    }

    @Test
    public void testGetTasks() throws Exception {


//        List tasks = Mockito.mock(ArrayList.class);
//
//        Task t1 = new Task();
//        t1.setId(1L);
//        t1.setIs_working_on(false);
//
//        tasks.add(t1);
//
//        Task t2 = new Task();
//        t2.setId(2L);
//        t2.setIs_working_on(true);
//
//        tasks.add(t2);
//
//        assertEquals(2, tasks.size());
//
//        assertEquals(1L, (long) ((Task) tasks.get(0)).getId());

//        List mockedList = Mockito.mock(List.class);
//
//// using mock object - it does not throw any "unexpected interaction" exception
//        mockedList.add("one");
//        mockedList.clear();
//
//// selective, explicit, highly readable verification
//        Mockito.verify(mockedList).add("one");
//        Mockito.verify(mockedList).clear();

    }

}
