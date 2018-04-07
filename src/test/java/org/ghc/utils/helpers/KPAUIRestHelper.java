package org.ghc.utils.helpers;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.ghc.utils.KPAIUTestConstants.links.*;
import static org.ghc.utils.KPAIUTestConstants.mess.consumer;
import static org.ghc.utils.KPAIUTestConstants.mess.totalCount;
import static org.ghc.utils.helpers.KPAUIStringHelper.getSiteWithPrefix;

public class KPAUIRestHelper {

    /** Send a GET request string to FaDSS to see how many results are
     * @param searchTerm String to search for
     * @return
     */
    public static int getRestSearchResults(String searchTerm) { //TODO: getting java.net.ConnectException in prod
        String path = getSiteWithPrefix(findADoctorSite + searchTerm.replace("%20", " "));
        return given().when().relaxedHTTPSValidation().port(443)
                .get(path).jsonPath().get(totalCount);
    }

    public static Map getRestAccountInfo(String id) {   //TODO: getting JsonPathException in prod
        return given().when().relaxedHTTPSValidation().port(443)
                .get(getSiteWithPrefix(accountInfoSite + id)).jsonPath().getMap(consumer);
    }

    // RETURN an arraylist with list for the requested type - language or specialty
    public static int getList(String type) {    //TODO: getting ConnectionException in prod
        return given().when().relaxedHTTPSValidation().port(443)
                .get(getSiteWithPrefix(findADoctorSiteLists + "type=" + type)).jsonPath().getList(type).size();
    }
}
