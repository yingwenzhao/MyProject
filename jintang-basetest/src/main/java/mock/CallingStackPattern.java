package mock;

import lombok.Data;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class CallingStackPattern {


    private List<Entrance> entranceList;

    public static CallingStackPattern ANY = new CallingStackPattern("any.any");

    public CallingStackPattern(String... entranceStr) {
        entranceList = new ArrayList<Entrance>(entranceStr.length);
        for (String entrance : entranceStr) {
            Entrance entrance1 = Entrance.parse(entrance);
            if (entrance1 != null) {
                entranceList.add(entrance1);
            }
        }
    }

    public boolean match(StackTraceElement[] stack) {
        if (stack == null || stack.length == 0) return false;
        for (Entrance entrance : entranceList) {
            for (StackTraceElement stackTraceElement : stack) {
                if (entrance.match(stackTraceElement)) {
                    return true;
                }
            }
        }
        return false;
    }


    @Data
    public static class Entrance {


        private String className;
        private String methodName;
        private int lineNo;


        public Entrance(String className, String methodName) {
            this.className = className;
            this.methodName = methodName;
        }

        public Entrance(String className, String methodName, int lineNo) {
            this.className = className;
            this.methodName = methodName;
            this.lineNo = lineNo;
        }

        public boolean match(StackTraceElement element) {

            if (className.equals("any") && methodName.equals("any")) {
                return true;
            }

            if (lineNo == 0) {
                if (element.getClassName().contains(className) && element.getMethodName().equals(methodName)) {
                    return true;
                }
            } else {
                if (element.getClassName().contains(className) && element.getMethodName().equals(methodName)
                        && element.getLineNumber() == lineNo) {
                    return true;
                }
            }
            return false;
        }

        public static Entrance parse(String entranceStr) {
            if (entranceStr == null || entranceStr.length() == 0) {
                return null;
            }

            String[] split = entranceStr.split("\\.");
            Assert.isTrue(split.length == 2 || split.length == 3, "当前传入格式不符合class.method或者class.method.lineNo");

            if (split.length == 2) {
                return new Entrance(split[0], split[1]);
            } else {
                return new Entrance(split[0], split[1], Integer.parseInt(split[2]));
            }
        }
    }

}
