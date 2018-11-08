package com.gl.utils;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author 龚磊
 * @data 2018/11/8 11:14
 * @describe 生成kieSeesion工具类
 */
public class BaseKieUtil {



    /**
     * 描述：获取所有规则文件
     *
     */
    public  KieSession getKieSession(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("all-rules");
        return kieSession;
    }

    /**
     * 描述：通过agenda 的分组来获取指定规则文件
     * @param agendaGroupName String类型，即规则文件中的分组名称（agenda-group）
     *
     */
    public  KieSession getKieSession(String agendaGroupName){
        //获取kieSession
        KieSession kieSession = getKieSession();
        //设置agenda为焦点
        kieSession.getAgenda().getAgendaGroup(agendaGroupName).setFocus();

        return kieSession;
    }
}
