package lk.easycar.rental.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FilesStorageService {
    void init();

    void save(MultipartFile file,String id,String rootPath);

    void load(String filename,String rootPath);

    void deleteAll();

    Stream<Path> loadAll();
}
