package org.smart4j.chapter3.aspect;

import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.plugin.security.aspect.AuthzAnnotationAspect;

/**
 * 书上的例子的AuthzAnnotationAspect类的包，和smart.framework.app.base_package = org.smart4j.chapter5配置中的包
 * 不一致，所以扫描不到这个类。
 * 为了能扫描到这个类，所以在本地新建了一个类，继承AuthzAnnotationAspect类，就能扫描到了。
 * Created by shijiapeng on 16/12/26.
 */
@Aspect(Controller.class)
public class LocalAuthzAnnotationAspect extends AuthzAnnotationAspect {
}
