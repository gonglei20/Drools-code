package com.gl.test;

import com.gl.entity.Car;
import com.gl.entity.People;
import com.gl.utils.BaseKieUtil;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Drools7ApiTest extends BaseKieUtil  {

    @Test
    public void droos7test(){

       /* KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("all-rules");*/

        KieSession kieSession =getKieSession("carDiscount1");

        People p1 = new People();
        p1.setAge(30);
        Car c1 = new Car();
        c1.setPeople(p1);

        People p2 = new People();
        p2.setAge(70);
        Car c2 = new Car();
        c2.setPeople(p2);
        System.out.println("before");
        System.out.println("c1折率"+c1.getDiscount());
        System.out.println("c2折率"+c1.getDiscount());

        kieSession.insert(c1);
        kieSession.insert(c2);

        int count = kieSession.fireAllRules();

        System.out.println("命中："+count+"条规则");


        kieSession.dispose();

    }
}
