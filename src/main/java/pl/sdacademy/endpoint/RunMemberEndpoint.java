package pl.sdacademy.endpoint;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.sdacademy.database.hibernate.entity.RunMember;
import pl.sdacademy.database.hibernate.utils.DaoProvider;

@RestController
@RequestMapping("/run-member")
public class RunMemberEndpoint {

    @RequestMapping(method = RequestMethod.POST)
    RunMember save(@RequestBody RunMember runMember) {
        DaoProvider.instance().getMemberDao().save(runMember);
        return runMember;
    }
}
