package romanow.abc.core;

import romanow.abc.core.API.RestAPI;
import romanow.abc.core.constants.Values;
import romanow.abc.core.mongo.ExportKotlin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class PRSExportKotlin {
    //------------------------------------------------------------------------------------------------------------------
    public static void exportKotlin(String path){
        if (path.length()!=0)
            path+="/";
        ErrorList errorList = new ErrorList();
        ExportKotlin.createKotlinClassSources(path,errorList);
        ExportKotlin.createJSAPIFile(path,RestAPI.class, errorList);
        ExportKotlin.exrortKotlinErrors(path,errorList);
        }
    public static void main(String aa[]) {
        Values.init();
        PRSExportKotlin.exportKotlin("f:/temp");
        }
    }