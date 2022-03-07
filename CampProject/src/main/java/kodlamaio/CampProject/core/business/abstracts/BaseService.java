package kodlamaio.CampProject.core.business.abstracts;

import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;


public interface BaseService<T> {
    Result add(T entity);
    Result delete(T entity);
    Result update(T entity);
}
