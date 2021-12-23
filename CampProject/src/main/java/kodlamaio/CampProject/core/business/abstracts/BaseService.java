package kodlamaio.CampProject.core.business.abstracts;

import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;

import java.util.List;

public interface BaseService<T> {
    Result add(T entity);
    Result delete(T entity);
    Result update(T entity);
    DataResult<List<T>> getAll();
    DataResult<T> getById(int id);
}
