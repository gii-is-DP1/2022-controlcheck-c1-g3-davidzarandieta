package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
    
    List<RecoveryRoom> findAll();
    
    Optional<RecoveryRoom> findById(int id);
    
    RecoveryRoom save(RecoveryRoom p);
    
    @Query("SELECT recRoomt FROM RecoveryRoomType recRoomt")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();

    @Query("SELECT recRoomt FROM RecoveryRoomType recRoomt WHERE recRoomt.name = ?1")
    RecoveryRoomType getRecoveryRoomType(String name);
}
