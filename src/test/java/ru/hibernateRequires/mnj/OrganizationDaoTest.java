package ru.hibernateRequires.mnj;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.hibernateRequires.mnj.organization.dao.OrganizationDao;
import ru.hibernateRequires.mnj.organization.dao.OrganizationDaoImpl;
import ru.hibernateRequires.mnj.organization.entity.Organization;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OrganizationDaoTest {
    @Autowired
    private OrganizationDaoImpl orDao;
    @Test
    public void test() {

        List<Organization> orgs = orDao.all();

        Assert.assertEquals(2, orgs.size());

    }

}
