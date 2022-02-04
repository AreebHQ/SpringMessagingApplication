package io.inboxmsgapplication.inbox.folders;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.domain.Pageable;


@Repository
public interface FolderRepository extends CassandraRepository<Folder, String> {
    // its gonna look for the value after findAllBy[id] in model class
    List<Folder> findAllById(String id, Pageable pageRequest);
    List<Folder> findAllById(String id);

}
