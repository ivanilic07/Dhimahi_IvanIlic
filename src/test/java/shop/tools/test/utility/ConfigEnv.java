package shop.tools.test.utility;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "file:src/test/resources/.env"}
)
public interface ConfigEnv extends Config {

    ConfigEnv config = ConfigFactory.create(ConfigEnv.class);

    @Key("BASEURL")
    String baseURL();

    @Key("MY_PASSWORD")
    String myPassword();

    @Key("MY_OLD_PASSWORD")
    String myOldPassword();

    @Key("MY_ACCOUNT")
    String myAccount();


}
