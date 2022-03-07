package kodlamaio.CampProject.dataAccess.abstracts;

import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.JobAdvert;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

    Optional<JobAdvert> findByJobAdvertName(String jobAdvertName);

    Optional<JobAdvert> findById(int id);

    List<JobAdvert> findAllByEmployer_Id(int id);

    Result existsByCity_IdAndJobPosition_IdAndEmployer_Id(int cityId, int jobPositionId, int employerId);

    List<JobAdvert> findAllByActiveTrueAndVerifiedTrue();       // All active jobAdverts are listing.

    List<JobAdvert> findAllByActiveTrueAndVerifiedTrueOrderByCreatedAtDesc();   // All active jobAdverts are listing by sort DECS.

    List<JobAdvert> findAllByActiveTrueAndVerifiedTrueOrderByCreatedAtAsc();    // All active jobAdverts are listing by sort ASC.

    List<JobAdvert> findAllByActiveTrueAndVerifiedTrueAndEmployer_Id(int employerId);   // All active jobAdverts of a employer is listing.

    List<JobAdvert> getAllByVerifiedFalseOrderByCreatedAtAsc();

    List<JobAdvert> getAllByVerifiedFalseOrderByCreatedAtDesc();

    List<JobAdvert> findAllByActiveTrueAndVerifiedTrueAndApplicationDeadlineBefore(LocalDate date);

    @Modifying
    @Query("update JobAdvert j set j.active =:status where j.id =:id")
    void updateActivation(@Param(value = "status") boolean status, @Param(value = "id") int id);


    @Modifying
    @Query("update JobAdvert j set j.verified =: status where j.id =: id ")
    void updateVerified(@Param(value = "status") boolean status, @Param(value = "id") int id);

  //  @Modifying
 //   @Query("update JobAdvert j set j.lastModifiedAt = : lastModifiedAt where j.id = :id")
    //void updateLastModifiedAt(@Param(value = "id") int id, LocalDateTime lastModifiedAt);


}
