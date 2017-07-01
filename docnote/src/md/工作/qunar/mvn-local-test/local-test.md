###  Test
- mvn clean package -P beta
- @RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/spring.xml" })
- 每次修改代码后的测试之前都clean下
