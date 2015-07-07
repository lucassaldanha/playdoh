package com.lsoftware.playdoh.reader;

import com.lsoftware.playdoh.exception.FixtureNotFoundException;
import com.lsoftware.playdoh.objects.models.ClassWithoutFixture;
import com.lsoftware.playdoh.objects.models.NestedDummy;
import com.lsoftware.playdoh.objects.models.User;
import com.lsoftware.playdoh.util.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.ConstructorException;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class YamlModelReaderTest {

    public static final String USERS_YAML_FILE = "user.yml";

    private YamlModelReader reader = new YamlModelReader();

    private FileUtils mockFileUtils;

    @Before
    public void setUp() throws Exception {
        configureFileUtilsMock();
    }

    private void configureFileUtilsMock() throws FileNotFoundException {
        mockFileUtils = mock(FileUtils.class);
        reader.setFileUtils(mockFileUtils);
    }

    private void mockFileUtilsToReturnFileInputStream(String filename) throws FileNotFoundException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        assertNotNull(inputStream);

        when(mockFileUtils.readFileFromClasspath(eq(filename))).thenReturn(inputStream);
    }

    @After
    public void tearDown() {
        Mockito.reset(mockFileUtils);
    }

    @Test
    public void testYamlReaderSearchFileWithNameOfClass() throws FileNotFoundException {
        mockFileUtilsToReturnFileInputStream(USERS_YAML_FILE);

        reader.read(User.class);

        verify(mockFileUtils, times(1)).readFileFromClasspath(eq(USERS_YAML_FILE));
    }

    @Test
    public void testYamlReaderSearchFileWithComposedNameAsSnakeCase() throws FileNotFoundException {
        mockFileUtilsToReturnFileInputStream("nested_dummy.yml");

        reader.read(NestedDummy.class);

        verify(mockFileUtils, times(1)).readFileFromClasspath(eq("nested_dummy.yml"));
    }

    @Test(expected = FixtureNotFoundException.class)
    public void testReadAbsentFileThrowsFixtureNotFoundException() throws FileNotFoundException {
        when(mockFileUtils.readFileFromClasspath(eq("class_without_fixture.yml")))
                .thenThrow(new FileNotFoundException());

        reader.read(ClassWithoutFixture.class);
    }

    @Test(expected = FixtureNotFoundException.class)
    public void testReadWithIdentifierAbsentFileThrowsFixtureNotFoundException() throws FileNotFoundException {
        when(mockFileUtils.readFileFromClasspath(eq("class_without_fixture.yml")))
                .thenThrow(new FileNotFoundException());

        reader.read("identifier", ClassWithoutFixture.class);
    }

    @Test
    public void testMapReturnedFromReaderMatchDataInYml() throws Exception {
        mockFileUtilsToReturnFileInputStream(USERS_YAML_FILE);

        User user = reader.read("aUser", User.class);
        assertNotNull(user);

        assertEquals("Lucas Saldanha", user.getName());
        assertEquals("lucas@example.com", user.getEmail());
        assertEquals(123, user.getAge());
    }

    @Test
    public void testReadFixtureObjectCollectionFromYmlFile() throws Exception {
        mockFileUtilsToReturnFileInputStream(USERS_YAML_FILE);

        Map<String, User> users = reader.read(User.class);
        assertNotNull(users);
        assertEquals(2, users.size());
    }

    @Test
    public void testYamlThrowsConstructorExceptionShouldThrowIllegalArgumentException() {
        Yaml mockYaml = mock(Yaml.class);
        when(mockYaml.loadAs(anyString(), Matchers.<Class<Object>>anyObject())).thenThrow(ConstructorException.class);
        reader.setYaml(mockYaml);

        reader.read(User.class);
    }
}