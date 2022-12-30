package Analyzer.vkApi;

import Analyzer.models.person.Person;
import Analyzer.models.person.Student;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.groups.Group;
import com.vk.api.sdk.objects.users.Fields;
import com.vk.api.sdk.objects.users.UserFull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VkRepository {

    private final int APP_ID = 51507062;

    private final String CODE = "vk1.a.PF0lCcsYlrMroQwzZbUqq_vniGRiO4M8k_oBq2XMALwja7O-28Q5Mvh1LKWh4u3EcPE3YEtXQ3cWRQH5T1alSeFvxAp4zhiAHZjqRZZI4BqOTcGHG9Cxs-cqmKoLsFk3MRs8ZNmX0npb8k8cWDV0v4SN7dmYjAHMtD-MBJSmL8BDrZQudB3mjEw0nqcblZ1Z";
    private final VkApiClient vk;
    private final UserActor actor;

    public VkRepository() {
        TransportClient transportClient = new HttpTransportClient();
        vk = new VkApiClient(transportClient);
        actor = new UserActor(APP_ID, CODE);
    }

    public Group getIritGroup() throws ClientException, ApiException {
        var groupName = "Уральский федеральный университет | УрФУ";
        return vk.groups()
                .search(actor, groupName)
                .execute()
                .getItems()
                .get(0);
    }
    public UserFull getPersonByGroup(Group group, String name) throws ClientException, ApiException, InterruptedException {
        Thread.sleep(1000);
        return vk.users()
                .search(actor)
                .groupId(group.getId())
                .q(name)
                .fields(Fields.SEX)
                .execute()
                .getItems()
                .stream()
                .findFirst()
                .orElse(new UserFull());
    }
    public HashMap<Student, Person> getPersonByVk(List<Student> people) throws ClientException, ApiException, InterruptedException {
        HashMap<Student, Person> persons = new HashMap<>();
        var group = getIritGroup();
        for(var name: people) {
            var gender = getGender(getPersonByGroup(group, name.getName()));
            Person person = new Person(name.getName(), gender);
            persons.put(name, person);
        }
        return persons;
    }

    public String getGender(UserFull user) {
        if (user.getSex() == null) {
            return null;
        } else {
            return user.getSex().toString();
        }
    }

}