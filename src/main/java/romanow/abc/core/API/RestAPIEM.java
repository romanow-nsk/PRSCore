package romanow.abc.core.API;

import romanow.abc.core.constants.OidList;
import romanow.abc.core.entity.EntityList;
import romanow.abc.core.entity.EntityRefList;
import romanow.abc.core.entity.baseentityes.*;
import romanow.abc.core.entity.subjectarea.*;
import retrofit2.Call;
import retrofit2.http.*;
import romanow.abc.core.entity.users.User;

import java.util.ArrayList;

public interface RestAPIEM {
    //==================================  API ПРЕДМЕТНОЙ ОБЛАСТИ =======================================================
    /** Добавить группу к экзамену (создание EMTicket для студентов) */
    @POST("/api/exam/group/add")
    Call<JInt> addGroupToExam(@Header("SessionToken") String token, @Query("examId") long examId, @Query("groupId") long groupId);
    /** Удалить группу с экзамена (удаление EMTicket для студентов) */
    @POST("/api/exam/group/remove")
    Call<JInt> removeGroupFromExam(@Header("SessionToken") String token, @Query("examId") long examId, @Query("groupId") long groupId);
    /** Получить тикеты студентов для экзамена (groupId=0 для всех групп) */
    @GET("/api/exam/ticket/list")
    Call<EMExam> getTicketsForExam(@Header("SessionToken") String token, @Query("examId") long examId,@Query("groupId") long groupId);
    /** Получить тикеты студентов для приема */
    @GET("/api/taking/ticket/list")
    Call<EMExamTaking> getTicketsForTaking(@Header("SessionToken") String token, @Query("takingId") long takingId);
}
