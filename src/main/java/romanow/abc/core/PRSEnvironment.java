package romanow.abc.core;

import romanow.abc.core.constants.Values;
import romanow.abc.core.mongo.DAO;

public class PRSEnvironment {
    //------------------------------------------------------------------------------------------------------------------
    public static void main(String aa[]){
        Values.init();
        DAO.createKotlinClassSources();
        }
    }
