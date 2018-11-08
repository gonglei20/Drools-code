package com.gl.test;

import com.gl.entity.Goods;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import java.util.Collection;

@Slf4j
public class Drools5ApiTest {

    @Test
    public void drools5Test(){

        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("com/goods.drl",this.getClass()), ResourceType.DRL);

        if (kbuilder.hasErrors()){
            //System.out.println("drl文件内存在异常"+kbuilder.getErrors());
            log.error("drl文件内存在异常{}"+kbuilder.getErrors());
        }
        KnowledgeBase knowledgeBase = kbuilder.newKnowledgeBase();
        Collection<KnowledgePackage> knowledgePackages = kbuilder.getKnowledgePackages();
        knowledgeBase.addKnowledgePackages(knowledgePackages);

        //创建会话
        StatefulKnowledgeSession statefulKnowledgeSession = knowledgeBase.newStatefulKnowledgeSession();

        Goods gds = new Goods();
        System.out.println("before "+gds.getDiscount());
        //执行rule
        statefulKnowledgeSession.insert(gds);
        statefulKnowledgeSession.fireAllRules();

        System.out.println("after "+gds.getDiscount());
        //关闭资源
        statefulKnowledgeSession.dispose();


    }
}
