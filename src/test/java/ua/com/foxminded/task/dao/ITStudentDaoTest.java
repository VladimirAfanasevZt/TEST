package ua.com.foxminded.task.dao;

public class ITStudentDaoTest {

//    private static StudentDao studentDao;
//    private static GroupDao groupDao;
//    private static final Student STUDENT1 = StudentModelRepository.getModel1();
//    private static final Student STUDENT2 = StudentModelRepository.getModel2();
//    private static final Student STUDENT3 = StudentModelRepository.getModel3();
//    private static final Student STUDENT4 = StudentModelRepository.getModel4();
//    private static final Student STUDENT5 = StudentModelRepository.getModel5();
//    private static final Student STUDENT6 = StudentModelRepository.getModel6();
//    private static final Group GROUP11 = GroupModelRepository.getModel11();
//    private static final Group GROUP12 = GroupModelRepository.getModel12();
//    private static final Group GROUP13 = GroupModelRepository.getModel13();
//
//    private static FlywayConnection flywayConnection = new FlywayConnection();
//    private static InitialContextBinder initialContextBinder = InitialContextBinder.getInstance();
//
//    @BeforeAll
//    public static void createRecords() {
//        initialContextBinder.setInitialContext();
//        flywayConnection.createTables();
////        studentDao = new StudentDaoImpl();
////        groupDao = new GroupDaoImpl();
//        groupDao.create(GROUP11);
//        groupDao.create(GROUP12);
//        groupDao.create(GROUP13);
//        studentDao.create(STUDENT1);
//        studentDao.create(STUDENT2);
//        studentDao.create(STUDENT3);
//        studentDao.create(STUDENT4);
//        studentDao.create(STUDENT5);
//        studentDao.create(STUDENT6);
//    }
//
////    @Test
//    public void WhenPutAtTableDbStudentObjects_thenGetThisObjectsFindById() {
//        int id = STUDENT2.getId();
//        assertTrue(studentDao.findById(id).equals(STUDENT2));
//    }
//
////    @Test
//    public void WhenPutAtTableDbStudentObjects_thenGetThisObjects() {
//        assertTrue(studentDao.findAll().containsAll(Arrays.asList(STUDENT1, STUDENT2, STUDENT3, STUDENT4, STUDENT5)));
//    }
//
////    @Test
//    public void WhenUpdateAtTableDbStudentObject_thenGetNewObject() {
//        Student student = studentDao.findById(6);
//        String firstNameExpected = "test_first_name";
//        student.setFirstName(firstNameExpected);
//        student.setGroup(GROUP11);
//
//        Student studentActually = studentDao.update(student);
//
//        String firstNameActually = studentActually.getFirstName();
//        Group groupActually = studentActually.getGroup();
//        assertEquals(firstNameExpected, firstNameActually);
//        assertEquals(GROUP11, groupActually);
//    }
//
////    @Test
//    public void WhenFindByIdNotExistinRecord_thenGetException() {
//        assertThrows(NoEntityFoundException.class, () -> studentDao.findById(9999));
//    }
//
////    @Test
//    public void WhenFindByIdGroup_thenReturnGroupWithSetId() {
//        int groupId = GROUP12.getId();
//        List<Student> students = studentDao.findByGroupId(groupId);
//        assertTrue(students.containsAll(Arrays.asList(STUDENT3, STUDENT4, STUDENT5)));
//    }
//
//    @AfterAll
//    public static void removeCreatedTables() {
//        flywayConnection.removeTables();
//        initialContextBinder.closeInitialContext();
//    }
}
