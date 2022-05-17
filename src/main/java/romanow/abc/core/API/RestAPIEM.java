package romanow.abc.core.API;

import romanow.abc.core.DBRequest;
import romanow.abc.core.entity.baseentityes.*;
import romanow.abc.core.entity.subjectarea.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface RestAPIEM {
    //==================================  API ПРЕДМЕТНОЙ ОБЛАСТИ =======================================================
    /** Добавить группу к экзамену (создание EMTicket для студентов) */
    @POST("/api/rating/group/add")
    Call<JLong> addGroupToDiscipline(@Header("SessionToken") String token, @Body() EMGroupRating rating);
    /** Удалить группу с экзамена (удаление EMTicket для студентов) */
    @POST("/api/rating/group/remove")
    Call<JEmpty> removeGroupFromExam(@Header("SessionToken") String token, @Query("ratingId") long ratingId);
    /** Получить тикеты студентов для экзамена */
    @GET("/api/rating/group/get")
    Call<EMGroupRating> getRatingsForGroup(@Header("SessionToken") String token, @Query("ratingId") long examId);
    /** Получить тикеты студентов для приема */
    @GET("/api/rating/taking/get")
    Call<EMExamTaking> getRatingsForTaking(@Header("SessionToken") String token, @Query("takingId") long takingId);
    /** Выполнить функцию перехода */
    @POST("/api/state/change")
    Call<JEmpty> execTransition(@Header("SessionToken") String token, @Body DBRequest body);
    /** Получить тикеты студентов для приема */
    @POST("/api/rating/takingforall")
    Call<JInt> setTakingForAll(@Header("SessionToken") String token, @Query("takingId") long takingId);
}
