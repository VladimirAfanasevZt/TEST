package ua.com.foxminded.task.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.database.rider.core.DBUnitRule;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.junit5.api.DBRider;

import ua.com.foxminded.task.domain.Group;

@DBRider
@SpringBootTest
public class GroupRepositoryIntegrationTest {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private DataSource dataSource;

    @Rule
    public DBUnitRule dbUnitRule = DBUnitRule.instance(() -> dataSource.getConnection());

    @Test
    @DataSet(cleanBefore = true)
    public void whenRepositoryHasNotRecords_thenReturnEmptyList() {
        List<Group> groups = groupRepository.findAll();
        assertThat(groups).isNotNull().isEmpty();
    }

    @Test
    @DataSet(value = "group/groups.yml", cleanBefore = true)
    @ExpectedDataSet(value = "group/expectedGroups.yml")
    public void whenRepositoryHasRecords_thenReturnNonEmptyList() {
        List<Group> groups = groupRepository.findAll();
        assertThat(groups).isNotNull().isNotEmpty().hasSize(4);
    }

    @Test
    @DataSet(value = "group/groups.yml", cleanBefore = true)
    public void whenPutAtTableDbGroupObjects_thenGetThisObjectsFindById() {
        Group expectedGroup = new Group();
        expectedGroup.setTitle("group3");
        expectedGroup.setYearEntry(2017);
        Group group = groupRepository.findById(3).get();
        assertThat(group).isEqualTo(expectedGroup);
    }

    @Test
    @DataSet(value = "group/groups.yml", cleanBefore = true)
    public void whenFindByTitle_thenGetExitsGroup() {
        String title = "group2";
        Group groupActually = groupRepository.findByTitle(title);
        assertThat(groupActually.getTitle()).isNotNull().isEqualTo(title);
    }

    @Test
    @DataSet(cleanBefore = true)
    @ExpectedDataSet(value = "group/expectedGroup.yml")
    public void whenSaveObject_thenExpectRecord() {
        Group group = new Group();
        group.setTitle("group10");
        group.setYearEntry(2015);
        Group groupActually = groupRepository.saveAndFlush(group);
        assertThat(groupActually).isNotNull();
    }

    @Test
    @DataSet(value = "group/group.yml", cleanBefore = true)
    @ExpectedDataSet(value = "group/expectedGroup.yml")
    public void whenUpdateObject_thenExpectUpdatedRecord() {
        Group group = new Group();
        group.setId(1);
        group.setTitle("group10");
        group.setYearEntry(2015);
        Group groupActually = groupRepository.saveAndFlush(group);
        assertThat(groupActually).isNotNull();
    }

}
