package util;

import org.springframework.cglib.beans.BeanCopier;

public final class BeanCopyUtil {

    public static <T> T createAndCopy(Object source,Class<T> clazz){
        try {
            BeanCopier copier = BeanCopier.create(source.getClass(), clazz, false);
            T target = clazz.newInstance();
            copier.copy(source,target,null);
            return target;
        } catch (Exception e) {
            throw new RuntimeException("对象属性复制出现错误",e);
        }
    }


}
