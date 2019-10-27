package pl.sdacademy.endpoint;

import org.springframework.web.bind.annotation.*;
import pl.sdacademy.database.hibernate.entity.Run;
import pl.sdacademy.database.hibernate.utils.DaoProvider;

import java.util.List;

@RestController
@RequestMapping("/run")
public class RunEndpoint {

    @RequestMapping(method = RequestMethod.GET)
    List<Run> findAll(){
        List<Run> list = DaoProvider
                .instance()
                .getRunDao()
                .getAll();
        return list;
    }

    @RequestMapping(method = RequestMethod.POST)
    Run save(@RequestBody Run newRun){
        DaoProvider.instance().getRunDao().save(newRun);
        return newRun;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    int delete(@RequestParam long id){
        if(DaoProvider.instance().getRunDao().getById(id) != null){
            return DaoProvider.instance().getRunDao().delete(id);
        }

    return -1;
    }
}
