package com.zps;

import com.zps.annotion.targetImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_anno.xml")
public class annoDemo {
    @Autowired
    private targetImpl target;

    @Test
    public void test(){
        target.save();
    }
}
