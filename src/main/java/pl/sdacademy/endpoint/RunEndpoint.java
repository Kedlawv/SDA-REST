package pl.sdacademy.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.database.hibernate.entity.Member;
import pl.sdacademy.database.hibernate.entity.Run;
import pl.sdacademy.database.hibernate.utils.DaoProvider;

import java.util.List;

@RestController
@RequestMapping("/run")
@Api(value = "Obsluga wszystkich biegow")
public class RunEndpoint {


    @ApiOperation(value = "Metoda zwraca wszystkie biegi z bazy")
    @RequestMapping(method = RequestMethod.GET)
    public List<Run> getAllRuns() {
        List<Run> list = DaoProvider
                .instance()
                .getRunDao()
                .getAll();

        return list;
    }

    @RequestMapping(value = "/{runId}", method = RequestMethod.GET)
    public Run getRunById(@PathVariable("runId") Long runId) {
        Run run = DaoProvider
                .instance()
                .getRunDao()
                .getById(runId);

        return run;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Run addRun(@RequestBody Run newRun) {
        DaoProvider
                .instance()
                .getRunDao()
                .save(newRun);

        return newRun;
    }

    @RequestMapping(value = "/{runId}", method = RequestMethod.DELETE)
    public void deleteRun(@PathVariable("runId") Long runId) {
        Run run = DaoProvider
                .instance()
                .getRunDao()
                .getById(runId);

        for(Member member : run.getMembers()) {
            DaoProvider
                    .instance()
                    .getMemberDao()
                    .delete(member.getId());
        }

        DaoProvider
                .instance()
                .getRunDao()
                .delete(runId);
    }

}
