package base;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(
        locations = {"classpath*:/spring/*",
                "classpath*:/application*",
                "classpath*:/datasource.xml"
        }
)
public class JintangTest extends BaseTest {
}
