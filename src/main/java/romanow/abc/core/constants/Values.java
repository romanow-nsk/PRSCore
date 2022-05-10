package romanow.abc.core.constants;

import romanow.abc.core.UniException;
import romanow.abc.core.entity.EntityIndexedFactory;
import romanow.abc.core.entity.base.WorkSettingsBase;
import romanow.abc.core.entity.subjectarea.*;
import romanow.abc.core.entity.users.User;

import java.util.HashMap;


public class Values extends ValuesBase {
    private static Values two=null;
    private Values(){
        super();
        System.out.println("Инициализация Values");
        initEnvTwo();
        getConstMap().createConstList(this);
        }
    public final static Values init(){
        if (two == null){
            two = new Values();
            setOne(two);
            }
        return two;
        }

    // 1. Константы наследуются (аннотации)
    // 2. Массивы строк перекрываются
    // 3. статическая инициализация наследуется
    private final static int EMReleaseNumber=14;                  // номер сборки сервера
    private User superUser = new User(UserSuperAdminType, "Система", "", "", "ESSDataserver", "schwanensee1969","9139877277");
    //----------- Данные ПЛК вне мета-системы -------------------------------------
    public final static String ESSStateIcon[]={"/ess_none.png","/ess_off.png","/ess_on.png"};
    //-----------------------------------------------------------------------------
    public final static int PopupMessageDelay=6;                // Тайм-аут всплывающего окна
    public final static int PopupLongDelay=20;                  // Тайм-аут всплывающего окна
    private  final static String EMClassNames[]={
            "romanow.abc.core.constants.Values",
            "romanow.abc.core.entity.subjectarea.WorkSettings",
            "romanow.abc.dataserver.EMDataServer",
            "romanow.abc.dataserver.EMConsoleServer",
            "romanow.abc.desktop.EMCabinet",
            "romanow.abc.desktop.EMClient",
            "","",""};
    private  final static String EMAppNames[]={
            "EM",
            "EM",
            "EM",
            "EM",
            "EM.apk",
            "EMDataserver.jar",
            "romanow.abc.desktop.module",
            "/drawable/EMmin.png",
            "Опоры России"
            };
    private void initEnvTwo(){
        I_Environment env = new I_Environment() {
            @Override
            public String applicationClassName(int classType) {
                return EMClassNames[classType];
                }
            @Override
            public String applicationName(int nameNype) {
                return EMAppNames[nameNype];
            }
            @Override
            public User superUser() {
                return superUser;
                }
            @Override
            public Class applicationClass(int classType) throws UniException {
                return createApplicationClass(classType,EMClassNames);
                }
            @Override
            public Object applicationObject(int classType) throws UniException {
                return createApplicationObject(classType,EMClassNames);
                }
            @Override
            public int releaseNumber() { return EMReleaseNumber; }
            @Override
            public WorkSettingsBase currentWorkSettings() { return new WorkSettings(); }
            };
        setEnv(env);
        EntityIndexedFactory EntityFactory = getEntityFactory();
        EntityFactory.put(new TableItem("Настройки", WorkSettings.class));
        HashMap<String,String> PrefixMap = getPrefixMap();
        PrefixMap.put("MFSelection.createDate","c");
        PrefixMap.put("MeasureFile.importDate","i");
        PrefixMap.put("MeasureFile.measureDate","m");
        PrefixMap.put("MeasureFile.gps","g");
        /*
        EntityFactory.put(new TableItem("Мета:Внешняя подсистема", MetaExternalSystem.class));
        EntityFactory.put(new TableItem("Мета:Подсистемы", MetaSubSystem.class));
        EntityFactory.put(new TableItem("Мета:Состояние", MetaState.class).add("MetaExternalSystem"));
         */
       }
    //------------- Типы пользователей -----------------------------------------------------
    @CONST(group = "User", title = "Тьютор")
    public final static int UserEMTutor = 3;
    @CONST(group = "User", title = "Преподаватель")
    public final static int UserEMTeacher = 4;
    @CONST(group = "User", title = "Студент")
    public final static int UserEMStudent = 5;
    //-------------------------------------------------------------------------------------------
    public static void main(String a[]){
        Values.init();
        System.out.println(title("User", UserAdminType));
        System.out.print(Values.constMap().toString());
        }
}
