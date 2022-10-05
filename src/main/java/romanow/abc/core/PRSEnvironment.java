package romanow.abc.core;

import romanow.abc.core.API.RestAPI;
import romanow.abc.core.API.RestAPIBase;
import romanow.abc.core.constants.Values;
import romanow.abc.core.mongo.DAO;
import romanow.abc.core.mongo.KotlinJSConverter;

import java.util.Optional;

public class PRSEnvironment {
    //------------------------------------------------------------------------------------------------------------------
    public static void main(String aa[]){
        Values.init();
        ErrorList errorList = new ErrorList();
        KotlinJSConverter.createKotlinClassSources(errorList);
        KotlinJSConverter.createJSAPIFile(RestAPI.class,errorList);
        System.out.println(errorList.toString());
        }
    }
