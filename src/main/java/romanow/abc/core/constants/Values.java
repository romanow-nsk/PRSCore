package romanow.abc.core.constants;

import romanow.abc.core.UniException;
import romanow.abc.core.entity.EntityIndexedFactory;
import romanow.abc.core.entity.base.WorkSettingsBase;
import romanow.abc.core.entity.subjectarea.*;
import romanow.abc.core.entity.subjectarea.statemashine.Transition;
import romanow.abc.core.entity.subjectarea.statemashine.TransitionsFactory;
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
    private final static int EMReleaseNumber=1;                  // номер сборки сервера
    private User superUser = new User(UserSuperAdminType, "Система", "", "", "EMDataserver", "schwanensee1969","9139877277");
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
            "em",
            "em",
            "em",
            "em",
            "EM.apk",
            "EMDataserver.jar",
            "romanow.abc.desktop.module",
            "/drawable/lecture.png",
            "БРС-НГТУ-ВТ"
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
        EntityFactory.put(new TableItem("Ответ", SAAnswer.class));
        EntityFactory.put(new TableItem("Предмет", SADiscipline.class));
        EntityFactory.put(new TableItem("Рейтинг группы", SAGroupRating.class));
        EntityFactory.put(new TableItem("Регламент экз.", SAExamRule.class));
        EntityFactory.put(new TableItem("Регламент сем.", SASemesterRule.class));
        EntityFactory.put(new TableItem("Прием экзамена", SAExamTaking.class));
        EntityFactory.put(new TableItem("Группа", SAGroup.class));
        EntityFactory.put(new TableItem("Сообщение", SAMessage.class));
        EntityFactory.put(new TableItem("Студент", SAStudent.class));
        EntityFactory.put(new TableItem("Задание", SATask.class));
        EntityFactory.put(new TableItem("Тема", SATheme.class));
        EntityFactory.put(new TableItem("Рейтинг студента", SAStudRating.class));
        EntityFactory.put(new TableItem("Уч.единица", SAEduUnit.class));
        EntityFactory.put(new TableItem("Оценка", SAPoint.class));
        HashMap<String,String> PrefixMap = getPrefixMap();
        PrefixMap.put("SAMessage.sendTime","s");
        PrefixMap.put("SAExamTaking.startTime","s");
        PrefixMap.put("SAExamTaking.endTime","e");
        PrefixMap.put("SASemesterRule.beginTime","b");
        PrefixMap.put("SAPoint.date","d");
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
    //------------- Вид занятия (учебной единицы)  -----------------------------------------------------
    @CONST(group = "EduUnit", title = "Не определен")
    public final static int UnitUndefined = 0;
    @CONST(group = "EduUnit", title = "Лаб.раб.")
    public final static int UnitLabWork = 1;
    @CONST(group = "EduUnit", title = "Практика")
    public final static int UnitPractic = 2;
    @CONST(group = "EduUnit", title = "Инд.задание")
    public final static int UnitIndividualTask= 3;
    @CONST(group = "EduUnit", title = "Контр.раб.")
    public final static int UnitTestTask= 4;
    @CONST(group = "EduUnit", title = "Тестирование")
    public final static int UnitTesting= 5;
    @CONST(group = "EduUnit", title = "РГР(З)")
    public final static int UnitPersonalTask= 6;
    @CONST(group = "EduUnit", title = "Защита")
    public final static int UnitDefence= 7;
    @CONST(group = "EduUnit", title = "Экзамен")
    public final static int UnitExam= 8;
    @CONST(group = "EduUnit", title = "Зачёт")
    public final static int UnitExamLight= 9;
    //------------- Показатели качества (в троичной системе) (0-не оценен, 1-плюс, 2-минус) ----------------------------
    @CONST(group = "QualityType", title = "Оформление")
    public final static int QualityGetUp= 0;
    @CONST(group = "QualityType", title = "Объем")
    public final static int QualityVolume= 1;
    @CONST(group = "QualityType", title = "Оригинальность")
    public final static int QualityOriginality= 2;
    @CONST(group = "QualityType", title = "Сложность")
    public final static int QualityСomplexity=3;
    @CONST(group = "QualityType", title = "Полнота")
    public final static int QualityСompleteness=4;
    @CONST(group = "QualityType", title = "Вериф./Ошибки")
    public final static int QualityErrors=5;
    //------------- Состояние студента  -----------------------------------------------------
    @CONST(group = "Student", title = "Не определен")
    public final static int StudentStateUndefined = 0;
    @CONST(group = "Student", title = "Учится")
    public final static int StudentStateNormal = 1;
    @CONST(group = "Student", title = "Ак.отпуск")
    public final static int StudentStateAcadem = 2;
    @CONST(group = "Student", title = "Отчислен")
    public final static int StudentStateSendDown = 3;
    //------------- Состояние сдачи экзамена студентом --------------------------------------------------
    @CONST(group = "StudRating", title = "Не определен")
    public final static int StudRatingUndefined = 0;
    @CONST(group = "StudRating", title = "Нет допуска")
    public final static int StudRatingNotAllowed = 1;
    @CONST(group = "StudRating", title = "Допущен")
    public final static int StudRatingAllowed = 2;
    @CONST(group = "StudRating", title = "Назначен на сдачу")
    public final static int StudRatingTakingSet = 3;
    @CONST(group = "StudRating", title = "Подтверждение явки")
    public final static int StudRatingConfirmation = 4;
    @CONST(group = "StudRating", title = "Неявка")
    public final static int StudRatingNoConfirmation = 5;
    @CONST(group = "StudRating", title = "На экзамене")
    public final static int StudRatingOnExam = 6;
    @CONST(group = "StudRating", title = "Закончил сдачу")
    public final static int StudRatingPassedExam = 7;
    @CONST(group = "StudRating", title = "Получил оценку")
    public final static int StudRatingGotRating = 8;
    //------------- Состояние приема экзамена --------------------------------------------------
    @CONST(group = "Taking", title = "Не определено")
    public final static int TakingUndefined = 0;
    @CONST(group = "Taking", title = "Редактируется")
    public final static int TakingEdit = 1;
    @CONST(group = "Taking", title = "Готово")
    public final static int TakingReady = 2;
    @CONST(group = "Taking", title = "Назначено время")
    public final static int TakingTimeIsSet = 3;
    @CONST(group = "Taking", title = "Идет экзамен")
    public final static int TakingInProcess = 4;
    @CONST(group = "Taking", title = "Проверка ответов")
    public final static int TakingAnswerCheck = 5;
    @CONST(group = "Taking", title = "Экзамен закончен")
    public final static int TakingClosed = 6;
    //------------- Состояние ответа --------------------------------------------------
    @CONST(group = "Answer", title = "Нет ответа")
    public final static int AnswerNoAck = 0;
    @CONST(group = "Answer", title = "Отвечает")
    public final static int AnswerInProcess = 1;
    @CONST(group = "Answer", title = "Ответ отправлен")
    public final static int AnswerDone = 2;
    @CONST(group = "Answer", title = "Проверка")
    public final static int AnswerCheck = 3;
    @CONST(group = "Answer", title = "Оценен")
    public final static int AnswerRatingIsSet = 4;
    @CONST(group = "Answer", title = "Без оценки")
    public final static int AnswerRatingNotSet = 5;
    //------------- Тип задания --------------------------------------------------
    @CONST(group = "Task", title = "Не определен")
    public final static int TaskUndefined = 0;
    @CONST(group = "Task", title = "Вопрос (тест)")
    public final static int TaskQuestion = 1;
    @CONST(group = "Task", title = "Задача")
    public final static int TaskExercise = 2;
    //------------------------------------------------------------------------------------------
    public final static TransitionsFactory TakingFactory = new TransitionsFactory("EMExamTaking");
    static {
        TakingFactory.add(new Transition(TakingEdit,TakingReady,"Закончить редакт.","EndEdit"));
        TakingFactory.add(new Transition(TakingReady,TakingTimeIsSet,"Назначить время","TimeSet"));
        TakingFactory.add(new Transition(TakingTimeIsSet,TakingReady,"Отменить назначенное время","TimeCancel"));
        TakingFactory.add(new Transition(TakingTimeIsSet,TakingInProcess,"Начать экзамен","Start"));
        TakingFactory.add(new Transition(TakingInProcess,TakingAnswerCheck,"Закончить прием","Stop"));
        TakingFactory.add(new Transition(TakingAnswerCheck,TakingInProcess,"Продолжить прием","Continue"));
        TakingFactory.add(new Transition(TakingAnswerCheck,TakingClosed,"Закончить экзамен","Close"));
        }
    public final static TransitionsFactory StudRatingFactory = new TransitionsFactory("EMStudRating");
    static  {
        StudRatingFactory.add(new Transition(StudRatingNotAllowed,StudRatingAllowed,"Допустить к сдаче","Allow"));
        StudRatingFactory.add(new Transition(StudRatingAllowed,StudRatingTakingSet,"Назначить прием","TakingSet"));
        StudRatingFactory.add(new Transition(StudRatingTakingSet,StudRatingAllowed,"Отменить назначение","TakingCancel"));
        StudRatingFactory.add(new Transition(StudRatingTakingSet,StudRatingConfirmation,"Ждать начала","Wait"));
        StudRatingFactory.add(new Transition(StudRatingConfirmation,StudRatingOnExam,"Подтв. явку","Confirmation"));
        StudRatingFactory.add(new Transition(StudRatingConfirmation,StudRatingNoConfirmation,"Неявка","NonConfirmation"));
        StudRatingFactory.add(new Transition(StudRatingNoConfirmation,StudRatingAllowed,"Повт.допуск","RetryAllow"));
        StudRatingFactory.add(new Transition(StudRatingOnExam,StudRatingPassedExam,"Закончить","Finish"));
        StudRatingFactory.add(new Transition(StudRatingPassedExam,StudRatingGotRating,"Оценка","SetRating"));
        StudRatingFactory.add(new Transition(StudRatingGotRating,StudRatingOnExam,"Доделать","Retry"));
        StudRatingFactory.add(new Transition(StudRatingGotRating,StudRatingAllowed,"Пересдача","NewTaking"));
        }
    public final static TransitionsFactory AnswerFactory = new TransitionsFactory("EMAnswer");
    static  {
        AnswerFactory.add(new Transition(AnswerNoAck,AnswerInProcess,"Начать ответ","Start"));
        AnswerFactory.add(new Transition(AnswerInProcess,AnswerDone,"Проверить (студ)","SendStud"));
        AnswerFactory.add(new Transition(AnswerInProcess,AnswerDone,"Проверить","Send"));
        AnswerFactory.add(new Transition(AnswerDone,AnswerCheck,"Начать проверку","Check"));
        AnswerFactory.add(new Transition(AnswerCheck,AnswerRatingIsSet,"Проверен","SetRating"));
        AnswerFactory.add(new Transition(AnswerRatingIsSet,AnswerInProcess,"Вернуть","Retry"));
        AnswerFactory.add(new Transition(AnswerCheck,AnswerInProcess,"Вернуть","Retry2"));
        }
    public final static HashMap<String,TransitionsFactory> stateFactoryMap = new HashMap<>();
    static  {
            stateFactoryMap.put(TakingFactory.name,TakingFactory);
            stateFactoryMap.put(StudRatingFactory.name,StudRatingFactory);
            stateFactoryMap.put(AnswerFactory.name,AnswerFactory);
            }
    //-------------------------------------------------------------------------------------------
    public static void main(String a[]){
        Values.init();
        System.out.println(title("User", UserAdminType));
        System.out.print(Values.constMap().toString());
        }
}
