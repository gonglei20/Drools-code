package com.gl.test;

import com.gl.entity.Goods;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
@Slf4j
public class Drools5ApiTest {

    @Test
    public void drools5Test(){

        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("com/gl/goods.drl",this.getClass()), ResourceType.DRL);

        if (kbuilder.hasErrors()){
            log.error("drl文件内存在异常{}",kbuilder.getErrors());
        }


    }
}
